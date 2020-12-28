package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole
{
	// 이 위치에 해도 잘 된다
	// 이 위치는 기본 생성자를 호출하면서 injection이 이루어짐
	// 따라서 기본 생성자 없으면 에러남. 꼭 있어야 함
	// 아니면 사용자정의 생성자도 없어야함 (없으면 기본생성자는 자동으로 만들어지기 때문)
	@Autowired	// required = false 처리를 하면 null이여도 처리 가능
	//@Qualifier("exam2")
	private Exam exam;

	public InlineExamConsole()
	{
		System.out.println("constructor");
	}

	// 이 위치에 해야한다면 매개변수가 여러개 올 수도 있기 때문에
	// Qualifier는 각각 파라미터에 설정해야 함
	//@Autowired
	/*public InlineExamConsole(
			@Qualifier("exam2")Exam exam1, 
			@Qualifier("exam2")Exam exam2)*/
	//public InlineExamConsole(@Qualifier("exam2")Exam exam)
	public InlineExamConsole(Exam exam)
	{
		System.out.println("overloaded constructor");
		this.exam = exam;
	}

	@Override
	public void print()
	{
		if(exam == null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}

	// <property name="exam" ref="exam" /> 이 내용을 대신 한다
	// Exam 이라는 객체를 자동으로 찾아서 세팅하라
	// 이 위치는 setter함수가 호출되면서 injection이 이루어짐
	//@Autowired
	//@Qualifier("exam2")
	@Override
	public void setExam(Exam exam)
	{
		System.out.println("setter");
		this.exam = exam;

	}

}
