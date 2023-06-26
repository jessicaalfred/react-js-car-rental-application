package shravanatirtha.berryride.model.common.exceptions;

/**
 * The Class DuplicateInstanceException.
 */
@SuppressWarnings("serial")
public class DuplicateInstanceException extends InstanceException {

    /**
     * Instantiates a new duplicate instance exception.
     *
     * @param name the name
     * @param key the key
     */
    public DuplicateInstanceException(String name, Object key) {
    	super(name, key); 	
    }
    
}
