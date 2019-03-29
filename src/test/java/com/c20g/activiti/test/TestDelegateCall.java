package com.c20g.activiti.test;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@ContextConfiguration(classes= {ActivitiConfiguration.class})
@RunWith(SpringRunner.class)
public class TestDelegateCall {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	@Test
	public void testOne() {
		RepositoryService r = activitiRule.getRepositoryService();
		Deployment d = r.createDeployment().name("TestProcess.bpmn").addClasspathResource("diagrams/TestProcess.bpmn").deploy();
	    
	    RuntimeService runtimeService = activitiRule.getRuntimeService();
//	    Map<String, String> vars = new HashMap<String, String>();
	    ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess");
	    Assert.assertNotNull(pi);
	    
	    HistoryService h = activitiRule.getHistoryService();
	    HistoricProcessInstance hpi = h.createHistoricProcessInstanceQuery().includeProcessVariables().processInstanceId(pi.getId()).singleResult();
//	    System.out.println(hpi.getProcessDefinitionId());
//	    System.out.println(hpi.getProcessVariables().keySet().size());
	    
//	    Map<String, Object> completedVars = hpi.getProcessVariables();
//	    for(String key : completedVars.keySet()) {
//	    	System.out.println(key + " / " + completedVars.get(key));
//	    }
	    
	    assert((new Long(4)).equals(hpi.getProcessVariables().get("doubled")));
	    
	}
	
}
