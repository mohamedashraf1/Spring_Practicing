package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is were we add all of our related advises for logging
	 
//	this will match on any modifier(optional) and any return type 
//	in aopdemo.dao package in any class on any method
//	with 0 to many arguments of any type
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	// apply point cut declaration on this method
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalaytics(){
		System.out.println("\n===> Performing API Analytics");
	}
}








