package com.genericLibraries.lims;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class Itransform implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
		annotation.setRetryAnalyzer(com.genericLibraries.lims.RetryAnalyzer.class);
	}

	
}
