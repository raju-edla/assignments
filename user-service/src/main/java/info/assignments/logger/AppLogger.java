package info.assignments.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

	private Logger logger;

	private AppLogger() {

	}

	private void setLogger(final Logger log) {
		this.logger = log;
	}

	static public AppLogger getLogger(final String name) {
		AppLogger instance = new AppLogger();
		instance.setLogger(LoggerFactory.getLogger(name));
		return instance;
	}

	static public AppLogger getLogger(final Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();

	}

	public void error(final String msg) {
		logger.error(msg);
	}

	public void warn(final String msg) {
		logger.warn(msg);
	}

	public void info(final String msg) {
		logger.info(msg);
	}

	public void debug(final String msg) {
		logger.debug(msg);
	}
	
	public void debug(final String msg,Object object) {
		logger.debug(msg.concat(",").concat(object.toString()));
	}

	public void trace(final String msg) {
		logger.trace(msg);
	}

}
