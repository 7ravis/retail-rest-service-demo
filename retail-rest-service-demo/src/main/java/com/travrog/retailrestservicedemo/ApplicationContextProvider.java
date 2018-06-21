package com.travrog.retailrestservicedemo;

import org.springframework.context.ApplicationContext;

public class ApplicationContextProvider {
	private static ApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	public static void setApplicationContext(ApplicationContext applicationContext) {
		if (ctx != null)
			throw new IllegalStateException("application context can only be set once");
		ctx = applicationContext;
	}
	
}
