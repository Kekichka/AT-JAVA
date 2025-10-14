package task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {
    protected static final Logger LOGGER = LogManager.getLogger(LoggerDemo.class);
    public static void main(String[] args) {
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warning");

    }

}
