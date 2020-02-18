package pl.quanton.commons;

import static net.thucydides.core.util.SystemEnvironmentVariables.createEnvironmentVariables;

public class ApiResources {

	public final static String DEFAULT_URL = createEnvironmentVariables().getProperty("default.url");
	public final static boolean RESPONSE_LOGGER_FLAG = Boolean.valueOf(createEnvironmentVariables().getProperty("payload.logger.flag"));
}
