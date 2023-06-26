package shravanatirtha.berryride.model.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import shravanatirtha.berryride.model.common.exceptions.DuplicateInstanceException;
import shravanatirtha.berryride.model.common.exceptions.InstanceNotFoundException;
import shravanatirtha.berryride.model.entities.Users;

/**
 * The Class UserServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class UserServiceTest {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Creates the user.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	private Users createUser(String userName) {
		return new Users(userName, "password", "firstName", "lastName", userName + "@" + userName + ".com");
	}

	/**
	 * Test sign up and login from id.
	 *
	 * @throws DuplicateInstanceException the duplicate instance exception
	 * @throws InstanceNotFoundException  the instance not found exception
	 */
	@Test
	public void testSignUpAndLoginFromId() throws DuplicateInstanceException, InstanceNotFoundException {

		Users users = createUser("users");

		userService.signUp(users);

		Users loggedInUser = userService.loginFromId(users.getId());

		assertEquals(users, loggedInUser);
		assertEquals(Users.RoleType.USERS, users.getRole());

	}
}
