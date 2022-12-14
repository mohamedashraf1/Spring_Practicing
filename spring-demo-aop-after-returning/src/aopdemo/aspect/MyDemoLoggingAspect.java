package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n====>>> result is: " + result);
		
		// post-process the data
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n====>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for(Account tempAccount : result) {
			// get upper case version of name
			String theUpperCase = tempAccount.getName().toUpperCase();
			// update the name on the account
			tempAccount.setName(theUpperCase);
		}		
	}

	// apply point cut declaration on this method
	@Before("aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n===> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("method: " + methodSig);
		
		// display method arguments
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
		
	}
	
}

