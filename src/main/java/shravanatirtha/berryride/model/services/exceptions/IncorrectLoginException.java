package shravanatirtha.berryride.model.services.exceptions;

/**
 * The Class IncorrectLoginException.
 */
@SuppressWarnings("serial")
public class IncorrectLoginException extends Exception {

	/** The user name. */
	private final String userName;

	/** The password. */
	private final String password;

	/**
	 * Instantiates a new incorrect login exception.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public IncorrectLoginException(String userName, String password) {

		this.userName = userName;
		this.password = password;

	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

}
