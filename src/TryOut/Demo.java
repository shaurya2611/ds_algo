package TryOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

	
class Student{
	
	int phone=90;
	String name;
	float salary;
	int age;
	
	public int expericence(int age, int salary) {
		System.out.println("inside expericence");
		return age+salary;
	}
	

}



public class Demo{
	
	public void add(int a,int b) {
		System.out.println(a+b);
	}
	
	
	public static void main(String[] args) {
		
		Student s1 = new Student(); // s1-- object anme
		int x = s1.expericence(19, 23); 
		System.out.println(x);
		System.out.println(s1.phone);
		s1.phone=80;
		System.out.println(s1.phone);
		System.out.println("------------------");
		
		Student s2 = new Student();
		System.out.println(s2.phone); //10
		
		System.out.println("run ex");
		
}
	
}
