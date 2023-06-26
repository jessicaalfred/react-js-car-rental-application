package shravanatirtha.berryride.model.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Users.
 */
@Entity
@Table(name = "Users")
public class Users {

	/**
	 * The Enum RoleType.
	 */
	public enum RoleType {
		/** The users. */
		USERS
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The users name. */
	private String userName;

	/** The password. */
	private String password;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The email. */
	private String email;

	/** The role. */
	private RoleType role;

	/**
	 * Instantiates a new users.
	 *
	 * @param userName  the users name
	 * @param password  the password
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param email     the email
	 */
	public Users(String userName, String password, String firstName, String lastName, String email) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the users name.
	 *
	 * @return the users name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the users name.
	 *
	 * @param usersName the new users name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
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

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public RoleType getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(RoleType role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		hash = 79 * hash + Objects.hashCode(this.userName);
		hash = 79 * hash + Objects.hashCode(this.email);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Users other = (Users) obj;
		if (this.email != other.email) {
			return false;
		}
		if (!Objects.equals(this.userName, other.userName)) {
			return false;
		}
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("City{");
		sb.append("id=").append(id);
		sb.append(", name='").append(userName).append('\'');
		sb.append(", population=").append(email);
		sb.append('}');
		return sb.toString();

	}

}
