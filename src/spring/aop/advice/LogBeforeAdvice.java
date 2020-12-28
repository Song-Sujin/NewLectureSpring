package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice
{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable
	{
		System.out.println("앞에서 실행될 로직");
		// 현재 호출되고 있는 함수의 이름을 뽑아내고 싶거나,
		// 그 함수가 가지고 있는 파라미터 값을 얻으려면 method 매개변수 사용하면 됨
		// target에 대한 객체를 이용하고 싶으면 target 매개변수 사용
		
		// 주 업무가 호출 될 필요 없음
	}

}
