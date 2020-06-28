package info.assignments.logger;

public class AppLoggerFactory {

	public static AppLogger getLogger(Class<?> c ) {
		return AppLogger.getLogger(c);
	}
	
	public static AppLogger getLogger(String name ) {
		return AppLogger.getLogger(name);
	}
}
