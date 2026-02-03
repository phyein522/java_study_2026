package com.phi;

public class Main {
	public static void main(String[] args) {
		TransJson tj = new TransJson();
		Student stu = new Student("이순신", "mjc123", Major.Computer);
		String strStu = tj.toStringJson(stu);
		System.out.println(strStu);
		Student objStu = (Student)tj.toObjectJson(strStu, Student.class);
		if(objStu instanceof Student stu2) {
			System.out.println(stu2);
		}
		System.out.println(tj.hashCode());
		System.out.println(objStu.hashCode());
	}
}