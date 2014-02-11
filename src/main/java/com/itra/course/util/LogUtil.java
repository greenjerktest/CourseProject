package com.itra.course.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogUtil {

	private static Logger logger = Logger.getLogger(LogUtil.class);

	public void afterReturn(JoinPoint joinPoint) {
		logger.debug("==Leave[" + joinPoint.getTarget().getClass() + "]class["
				+ joinPoint.getSignature().getName() + "]method==");
	}

	public void before(JoinPoint joinPoint) {
		logger.debug("==Enter[" + joinPoint.getTarget().getClass() + "]class["
				+ joinPoint.getSignature().getName() + "]method==");
	}

}
