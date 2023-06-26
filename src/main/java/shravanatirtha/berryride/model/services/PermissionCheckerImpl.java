package shravanatirtha.berryride.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shravanatirtha.berryride.model.common.exceptions.InstanceNotFoundException;
import shravanatirtha.berryride.model.entities.Users;
import shravanatirtha.berryride.model.entities.UserDao;

/**
 * The Class PermissionCheckerImpl.
 */
@Service
@Transactional(readOnly=true)
public class PermissionCheckerImpl implements PermissionChecker {
	
	/**
	 *  The user dao.
	 *
	 * @param userId the user id
	 * @return the user
	 * @throws InstanceNotFoundException the instance not found exception
	 */
	@Autowired
	private UserDao userDao;
	
	@Override
	public void checkUserExists(Long userId) throws InstanceNotFoundException {
		
		if (!userDao.existsById(userId)) {
			throw new InstanceNotFoundException("project.entities.user", userId);
		}
		
	}

	@Override
	public Users checkUser(Long userId) throws InstanceNotFoundException {

		Optional<Users> users = userDao.findById(userId);
		
		if (!users.isPresent()) {
			throw new InstanceNotFoundException("project.entities.user", userId);
		}
		
		return users.get();
		
	}

}
