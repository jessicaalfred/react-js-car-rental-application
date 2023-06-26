package shravanatirtha.berryride.rest.dtos;

import shravanatirtha.berryride.model.entities.Users;

/**
 * The Class UserConversor.
 */
public class UserConversor {

	/**
	 * Instantiates a new user conversor.
	 */
	private UserConversor() {
	}

	/**
	 * To user dto.
	 *
	 * @param users the user
	 * @return the user dto
	 */
	public static final UserDto toUserDto(Users users) {
		return new UserDto(users.getId(), users.getUserName(), users.getFirstName(), users.getLastName(), users.getEmail(),
				users.getRole().toString());
	}

	/**
	 * To user.
	 *
	 * @param userDto the user dto
	 * @return the user
	 */
	public static final Users toUser(UserDto userDto) {

		return new Users(userDto.getUserName(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(),
				userDto.getEmail());
	}

	/**
	 * To authenticated user dto.
	 *
	 * @param serviceToken the service token
	 * @param users         the user
	 * @return the authenticated user dto
	 */
	public static final AuthenticatedUserDto toAuthenticatedUserDto(String serviceToken, Users users) {

		return new AuthenticatedUserDto(serviceToken, toUserDto(users));

	}

}

