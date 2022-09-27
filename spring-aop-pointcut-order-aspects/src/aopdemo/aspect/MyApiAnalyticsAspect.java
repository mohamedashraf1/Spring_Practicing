package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {	
	
	@Before("aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalaytics(){
		System.out.println("\n===> Performing API Analytics");
	}
	
}
