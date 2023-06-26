package shravanatirtha.berryride.rest.common;

/**
 * The Class FieldErrorDto.
 */
public class FieldErrorDto {

	/** The field name. */
	private String fieldName;
	
	/** The message. */
	private String message;

	/**
	 * Instantiates a new field error dto.
	 *
	 * @param fieldName the field name
	 * @param message the message
	 */
	public FieldErrorDto(String fieldName, String message) {

		setFieldName(fieldName);
		setMessage(message);

	}

	/**
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets the field name.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
