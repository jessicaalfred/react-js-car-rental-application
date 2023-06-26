package shravanatirtha.berryride.rest.dtos;

import javax.validation.constraints.NotNull;

/**
 * The Class LoginParamsDto.
 */
public class LoginParamsDto {

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new login params dto.
	 */
	public LoginParamsDto() {
		super();
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	@NotNull
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName.trim();
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@NotNull
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
