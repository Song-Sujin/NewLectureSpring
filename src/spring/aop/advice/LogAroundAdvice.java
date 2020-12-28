package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor
{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed();	// invoke() 메소드가 proceed()메소드로 바뀜
		// 주업무를 가지고 있는 애를 호출하는 역할!
		
		long end = System.currentTimeMillis();
		String message = (end - start) + "ms 시간이 걸렸습니다.";
		System.out.println(message);
		
		return result;
	}

}
