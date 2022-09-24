package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is were we add all of our related advises for logging
	
	// this will be called to any addAccount method in any class
	//	@Before("execution(public void addAccount())")
	
	// but this will call it for specific method: aopdemo.dao.AccountDAO.addAccount()
	// @Before("execution(public void aopdemo.dao.AccountDAO.addAccount())")
	
	// this will be called on any method start with add
	// @Before("execution(public void add*())")
	
	// this will match on any modifier(optional) and any return type
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>>>> Executing @Before advice on addAccount()");
	}
}
