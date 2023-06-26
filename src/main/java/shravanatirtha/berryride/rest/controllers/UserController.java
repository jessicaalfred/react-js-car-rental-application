package shravanatirtha.berryride.rest.controllers;

import static shravanatirtha.berryride.rest.dtos.UserConversor.toAuthenticatedUserDto;
import static shravanatirtha.berryride.rest.dtos.UserConversor.toUser;
import static shravanatirtha.berryride.rest.dtos.UserConversor.toUserDto;

import java.net.URI;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import shravanatirtha.berryride.model.common.exceptions.DuplicateInstanceException;
import shravanatirtha.berryride.model.common.exceptions.InstanceNotFoundException;
import shravanatirtha.berryride.model.entities.Users;
import shravanatirtha.berryride.model.services.exceptions.IncorrectLoginException;
import shravanatirtha.berryride.model.services.exceptions.IncorrectPasswordException;
import shravanatirtha.berryride.model.services.exceptions.PermissionException;
import shravanatirtha.berryride.model.services.UserService;
import shravanatirtha.berryride.rest.common.ErrorsDto;
import shravanatirtha.berryride.rest.common.JwtGenerator;
import shravanatirtha.berryride.rest.common.JwtInfo;
import shravanatirtha.berryride.rest.dtos.AuthenticatedUserDto;
import shravanatirtha.berryride.rest.dtos.ChangePasswordParamsDto;
import shravanatirtha.berryride.rest.dtos.LoginParamsDto;
import shravanatirtha.berryride.rest.dtos.UserDto;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	 
	/** The Constant INCORRECT_LOGIN_EXCEPTION_CODE. */
	
	private static final String INCORRECT_LOGIN_EXCEPTION_CODE = "project.exceptions.IncorrectLoginException";

	/** The Constant INCORRECT_PASSWORD_EXCEPTION_CODE. */
	private static final String INCORRECT_PASS_EXCEPTION_CODE = "project.exceptions.IncorrectPasswordException";

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The jwt generator. */
	@Autowired
	private JwtGenerator jwtGenerator;

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Handle incorrect login exception.
	 *
	 * @param exception the exception
	 * @param locale    the locale
	 * @return the errors dto
	 */
	@ExceptionHandler(IncorrectLoginException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorsDto handleIncorrectLoginException(IncorrectLoginException exception, Locale locale) {

		String errorMessage = messageSource.getMessage(INCORRECT_LOGIN_EXCEPTION_CODE, null,
				INCORRECT_LOGIN_EXCEPTION_CODE, locale);

		return new ErrorsDto(errorMessage);

	}

	/**
	 * Handle incorrect password exception.
	 *
	 * @param exception the exception
	 * @param locale    the locale
	 * @return the errors dto
	 */
	@ExceptionHandler(IncorrectPasswordException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorsDto handleIncorrectPasswordException(IncorrectPasswordException exception, Locale locale) {

		String errorMessage = messageSource.getMessage(INCORRECT_PASS_EXCEPTION_CODE, null,
				INCORRECT_PASS_EXCEPTION_CODE, locale);

		return new ErrorsDto(errorMessage);

	}

	/**
	 * Sign up.
	 *
	 * @param userDto the user dto
	 * @return the response entity
	 * @throws DuplicateInstanceException the duplicate instance exception
	 */
	@PostMapping("/signUp")
	public ResponseEntity<AuthenticatedUserDto> signUp(
			@Validated({ UserDto.AllValidations.class }) @RequestBody UserDto userDto)
			throws DuplicateInstanceException {

		Users users = toUser(userDto);

		userService.signUp(users);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(users.getId())
				.toUri();

		return ResponseEntity.created(location).body(toAuthenticatedUserDto(generateServiceToken(users), users));

	}

	/**
	 * Login.
	 *
	 * @param params the params
	 * @return the authenticated user dto
	 * @throws IncorrectLoginException the incorrect login exception
	 */
	@PostMapping("/login")
	public AuthenticatedUserDto login(@Validated @RequestBody LoginParamsDto params) throws IncorrectLoginException {

		Users users = userService.login(params.getUserName(), params.getPassword());

		return toAuthenticatedUserDto(generateServiceToken(users), users);

	}

	/**
	 * Login from service token.
	 *
	 * @param userId       the user id
	 * @param serviceToken the service token
	 * @return the authenticated user dto
	 * @throws InstanceNotFoundException the instance not found exception
	 */
	@PostMapping("/loginFromServiceToken")
	public AuthenticatedUserDto loginFromServiceToken(@RequestAttribute Long userId,
			@RequestAttribute String serviceToken) throws InstanceNotFoundException {

		Users users = userService.loginFromId(userId);

		return toAuthenticatedUserDto(serviceToken, users);

	}

	/**
	 * Update profile.
	 *
	 * @param userId  the user id
	 * @param id      the id
	 * @param userDto the user dto
	 * @return the user dto
	 * @throws InstanceNotFoundException the instance not found exception
	 * @throws PermissionException       the permission exception
	 */
	@PutMapping("/{id}")
	public UserDto updateProfile(@RequestAttribute Long userId, @PathVariable("id") Long id,
			@Validated({ UserDto.UpdateValidations.class }) @RequestBody UserDto userDto)
			throws InstanceNotFoundException, PermissionException {

		if (!id.equals(userId)) {
			throw new PermissionException();
		}

		return toUserDto(
				userService.updateProfile(id, userDto.getFirstName(), userDto.getLastName(), userDto.getEmail()));

	}

	/**
	 * Change password.
	 *
	 * @param userId the user id
	 * @param id     the id
	 * @param params the params
	 * @throws PermissionException        the permission exception
	 * @throws InstanceNotFoundException  the instance not found exception
	 * @throws IncorrectPasswordException the incorrect password exception
	 */
	@PostMapping("/{id}/changePassword")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePassword(@RequestAttribute Long userId, @PathVariable Long id,
			@Validated @RequestBody ChangePasswordParamsDto params)
			throws PermissionException, InstanceNotFoundException, IncorrectPasswordException {

		if (!id.equals(userId)) {
			throw new PermissionException();
		}

		userService.changePassword(id, params.getOldPassword(), params.getNewPassword());

	}
	
	/**
	 * Generate service token.
	 *
	 * @param users the user
	 * @return the string
	 */
	private String generateServiceToken(Users users) {

		JwtInfo jwtInfo = new JwtInfo(users.getId(), users.getUserName(), users.getRole().toString());

		return jwtGenerator.generate(jwtInfo);

	}

}
