package baekjoon.solution;

import java.util.Arrays;
import java.util.Scanner;

public class KorEngMath {
	public static Scanner scanner = new Scanner(System.in);
	
	public void solution(int num) {
		Student[] students = new Student[num];
		
		for (int i=0; i<num; i++) {
			Student student = new Student();
			
			student.setName(scanner.next());
			student.setKorean(scanner.nextInt());
			student.setEng(scanner.nextInt());
			student.setMath(scanner.nextInt());
			
			students[i] = student;
		}
		
		Arrays.sort(students);
		
		for (int i=0; i<num; i++) {
			System.out.println(students[i].getName());
		}
	}
	
	public static void main(String[] args) {
		KorEngMath korEngMath = new KorEngMath();
		int num = scanner.nextInt();
		
		korEngMath.solution(num);
	}
}

class Student implements Comparable<Student> {
	private String name;
	private int korean;
	private int eng;
	private int math;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
        return this.name;
    }
	@Override
	public int compareTo(Student o) {
		if (this.korean == o.korean && this.eng == o.eng
				&& this.math == o.math) {
			return this.name.compareTo(o.name);
		}
		
		if (this.korean == o.korean && this.eng == o.eng) {
			return o.math - this.math;
		}
		
		if (this.korean == o.korean) {
			return this.eng - o.eng;
		}
		
		return o.korean - this.korean;
	}	
	@Override
	public String toString() {
		return "Student [name=" + name + ", korean=" + korean + ", eng=" + eng + ", math=" + math + "]";
	}
}

