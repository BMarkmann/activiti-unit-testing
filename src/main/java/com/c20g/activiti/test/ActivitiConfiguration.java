package com.c20g.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration {

	@Bean
	public ProcessEngine processEngine() {
		ProcessEngines.init();
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		return processEngine;
	}
	
}
