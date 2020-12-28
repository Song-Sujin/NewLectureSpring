package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

/*
xml 파일 자체를 java파일로 변경함
이 클래스는 설정을 위한 java클래스라는것을 표시하기 위해 @Configuration Annotation 추가
*/
@ComponentScan("spring.di.ui")	// <context:component-scan base-package="spring.di.ui" />
@Configuration					// 스캔할 패키지가 여러개일 경우 {"", ""} 배열 형태로 작성
public class NewlecDIConfig
{
	// 객체를 직접 생성하는 과정을 통해서 Bean이라는 Annotation을 달았음
	// 어떤것을 지시하는게 아니라 내가 직접하는 것이라서 설정이 아닌가? 할수 있지만
	// Bean이라는 Annotation의 역할은 IoC컨테이너(프로그램에 쓸수있는 객체를 모아둔곳)에
	// 생성만한다고 담기는게 아니라 Bean Annotation을 달아주면 IoC컨테이너에 담아주는 것
	@Bean
	public Exam exam()	// 메소드는 일반적으로 동사형태이지만, 이건 그냥 명사
	{					// id값! 컨테이너에 담겼을때 그 이름으로 부여
		return new NewlecExam();
	}

}
