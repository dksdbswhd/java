package com.jcp.day7;

public class ForEachTest {

	public static void main(String[] args) {
		Student[] stus = new Student[5];
		
		stus[0] = new Student("사나", new int[] {78,56,98});
		stus[1] = new Student("다현", new int[] {68,76,83});
		stus[2] = new Student("모모", new int[] {78,56,98});
		stus[3] = new Student("미나", new int[] {85,91,67});
		stus[4] = new Student("정연", new int[] {88,77,66});
		
		//기존의 for
		for(int i=0;i<stus.length;i++) {
			Student stu = stus[i];		//인덱스 i번째의 참조값을 stu 변수에 대입합니다.
			stu.print();
		}
		
		System.out.println(":::::::::::::::");
		//foreach
		for( Student stu : stus)
			stu.print();
		
		
	}

}
