package com.c20g.activiti.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class MyTestJavaDelegate implements JavaDelegate {

	private Expression phaseIdExpression;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
//		System.out.println("In delegate");
		Long phaseId = new Long((String)phaseIdExpression.getValue(execution));
		long outputValue = 2 * phaseId.longValue();
		execution.setVariable("doubled", new Long(outputValue));
//		for(String x : execution.getVariableNames()) {
//			System.out.println(x);
//		}
	}

}
