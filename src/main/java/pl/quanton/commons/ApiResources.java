package pl.quanton.commons;

import static net.thucydides.core.util.SystemEnvironmentVariables.createEnvironmentVariables;

public class ApiResources {

	public final static String DEFAULT_URL = createEnvironmentVariables().getProperty("default.url");
	public final static String PROXY_HOST = createEnvironmentVariables().getProperty("proxy.default.url");
	public final static int PROXY_PORT = Integer.valueOf(createEnvironmentVariables().getProperty("proxy.default.port"));
	public final static boolean PROXY_FLAG = Boolean.valueOf(createEnvironmentVariables().getProperty("proxy.mandatory.flag"));
	public final static boolean RESPONSE_LOGGER_FLAG = Boolean.valueOf(createEnvironmentVariables().getProperty("payload.logger.flag"));
}
