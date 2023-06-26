package shravanatirtha.berryride.model.common.exceptions;

/**
 * The Class InstanceException.
 */
@SuppressWarnings("serial")
public abstract class InstanceException extends Exception {

	/** The name. */
	private final String name;

	/** The key. */
	private final transient Object key;

	/**
	 * Instantiates a new instance exception.
	 *
	 * @param name the name
	 * @param key  the key
	 */
	protected InstanceException(String name, Object key) {
		this.name = name;
		this.key = key;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}

}
