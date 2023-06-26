package shravanatirtha.berryride.rest.common;

/**
 * The Class JwtInfo.
 */
public class JwtInfo {

	/** The user id. */
	private Long userId;

	/** The user name. */
	private String userName;

	/** The role. */
	private String role;

	/**
	 * Instantiates a new jwt info.
	 *
	 * @param userId   the user id
	 * @param userName the user name
	 * @param role     the role
	 */
	public JwtInfo(Long userId, String userName, String role) {

		this.userId = userId;
		this.userName = userName;
		this.role = role;

	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}