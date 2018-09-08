package com.optum.hedis.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	//To check how many time loading the context.. need to improve further to avoid duplicate loading happening from SecurityFilter and ODataServlet
	public synchronized static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public synchronized  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		ApplicationContextProvider.applicationContext = applicationContext;
	}
}
