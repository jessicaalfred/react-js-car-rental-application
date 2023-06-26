package shravanatirtha.berryride.rest.common;

/**
 * The Interface JwtGenerator.
 */
public interface JwtGenerator {
	
	/**
	 * Generate.
	 *
	 * @param info the info
	 * @return the string
	 */
	String generate(JwtInfo info);
	
	/**
	 * Gets the info.
	 *
	 * @param token the token
	 * @return the info
	 */
	JwtInfo getInfo(String token);

}
