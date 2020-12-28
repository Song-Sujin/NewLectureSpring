package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program
{

	public static void main(String[] args)
	{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");	// xml방식을 사용한 config 설정
				//new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		Exam exam = (Exam) context.getBean("exam");
		
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("avg is %f\n", exam.avg());
		
		/* 순수 자바로 구현
		Exam exam = new NewlecExam(1,1,1,1);
		
		// exam과 똑같이 보이는 가짜 exam
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class},
				new InvocationHandler()
				{
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
					{
						long start = System.currentTimeMillis();
						
						// 여기서 주업무가 실행되어야 함
						Object result = method.invoke(exam, args);
						
						long end = System.currentTimeMillis();
						String message = (end - start) + "ms 시간이 걸렸습니다.";
						System.out.println(message);
						
						return result;
					}
				});
		*/

	}

}
