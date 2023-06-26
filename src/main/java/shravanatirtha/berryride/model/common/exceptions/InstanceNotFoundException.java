package shravanatirtha.berryride.model.common.exceptions;

/**
 * The Class InstanceNotFoundException.
 */
@SuppressWarnings("serial")
public class InstanceNotFoundException extends InstanceException {
    
    /**
     * Instantiates a new instance not found exception.
     *
     * @param name the name
     * @param key the key
     */
    public InstanceNotFoundException(String name, Object key) {
    	super(name, key); 	
    }

}
