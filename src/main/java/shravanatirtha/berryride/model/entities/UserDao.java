package shravanatirtha.berryride.model.entities;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The Interface UserDao.
 */
public interface UserDao extends PagingAndSortingRepository<Users, Long> {

	/**
	 * Exists by user name.
	 *
	 * @param userName the user name
	 * @return true, if successful
	 */
	boolean existsByUserName(String userName);

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the optional
	 */
	Optional<Users> findByUserName(String userName);

}
