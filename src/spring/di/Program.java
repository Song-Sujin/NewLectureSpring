package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program
{

	public static void main(String[] args)
	{
		/* 스프링에게 지시하는 방법으로 코드를 변경
		//Exam exam = new NewlecExam();
		Exam exam = new NewlecExam(10,10,10,10);
		ExamConsole console = new GridExamConsole();
		
		console.setExam(exam);
		*/
		
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");	// xml방식을 사용한 config 설정
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);	// Annotation방식을 사용한 config 설정
				
		//Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		
		ExamConsole console = (ExamConsole) context.getBean("console");	// console 객체를 찾아라
		//ExamConsole console = context.getBean(ExamConsole.class);		// 이 interface에 부합되는 객체가 있으면 찾아라(형식으로 찾기)
		console.print();
		
		/*
		//-------- 콜렉션(ArrayList) 생성과 목록 DI -----------
		List<Exam> exams = (List<Exam>) context.getBean("exams");	//new ArrayList<>();
		
		// <!-- 컬렉션 리스트를 생성자에 넘기는 방식으로 ArrayList만들기 --!>
		// setting.xml에 있는 위의 내용이 존재한다면 아래의 문장은 없어도 됨
		//exams.add(new NewlecExam(1,1,1,1));
		
		for(Exam e : exams)
			System.out.println(e);
		*/
	}

}
