package students.student;
import java.util.*;
public class Student{
	private int studentId = 0;
	private String studentName = null;
	private int age = 0;

	public Student(String name,int age){
		this.studentName = name;
		this.age = age;
	}

	public String getName(){
		return this.studentName;
	}

	public int getAge(){
		return this.age;
	}
}