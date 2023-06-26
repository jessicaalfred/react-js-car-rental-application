package shravanatirtha.berryride.rest.common;

import java.util.List;

/**
 * The Class ErrorsDto.
 */
public class ErrorsDto {

	/** The global error. */
	private String globalError;
	
	/** The field errors. */
	private List<FieldErrorDto> fieldErrors;

	/**
	 * Instantiates a new errors dto.
	 *
	 * @param globalError the global error
	 */
	public ErrorsDto(String globalError) {
		setGlobalError(globalError);
	}

	/**
	 * Instantiates a new errors dto.
	 *
	 * @param fieldErrors the field errors
	 */
	public ErrorsDto(List<FieldErrorDto> fieldErrors) {
		setFieldErrors(fieldErrors);
	}

	/**
	 * Gets the global error.
	 *
	 * @return the global error
	 */
	public String getGlobalError() {
		return globalError;
	}

	/**
	 * Sets the global error.
	 *
	 * @param globalError the new global error
	 */
	public void setGlobalError(String globalError) {
		this.globalError = globalError;
	}

	/**
	 * Gets the field errors.
	 *
	 * @return the field errors
	 */
	public List<FieldErrorDto> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * Sets the field errors.
	 *
	 * @param fieldErrors the new field errors
	 */
	public void setFieldErrors(List<FieldErrorDto> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
