package shravanatirtha.berryride.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AuthenticatedUserDto.
 */
public class AuthenticatedUserDto {

	/** The service token. */
	private String serviceToken;
	
	/** The user dto. */
	private UserDto userDto;

	/**
	 * Instantiates a new authenticated user dto.
	 */
	public AuthenticatedUserDto() {
	}

	/**
	 * Instantiates a new authenticated user dto.
	 *
	 * @param serviceToken the service token
	 * @param userDto the user dto
	 */
	public AuthenticatedUserDto(String serviceToken, UserDto userDto) {

		setServiceToken(serviceToken);
		setUserDto(userDto);

	}

	/**
	 * Gets the service token.
	 *
	 * @return the service token
	 */
	public String getServiceToken() {
		return serviceToken;
	}

	/**
	 * Sets the service token.
	 *
	 * @param serviceToken the new service token
	 */
	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}

	/**
	 * Gets the user dto.
	 *
	 * @return the user dto
	 */
	@JsonProperty("user")
	public UserDto getUserDto() {
		return userDto;
	}

	/**
	 * Sets the user dto.
	 *
	 * @param userDto the new user dto
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

}
