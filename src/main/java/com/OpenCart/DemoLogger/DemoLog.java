package com.OpenCart.DemoLogger;

import org.apache.logging.log4j.LogManager;

public class DemoLog {
	static org.apache.logging.log4j.Logger logger = LogManager.getLogger(DemoLog.class.getName());
	public static void LogMsg(int num) {
		
		if(num==1) {
			logger.trace("tracking message");
		}
		else if(num==2) {
			logger.info("information message");
		}
		else if(num==3) {
			logger.error("error message");
		}
		else if(num==4) {
			logger.warn("warning message");
		}
		else if(num==5) {
			logger.fatal("fatal message");
		}
	}
}
