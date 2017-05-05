package io.test001;

import java.io.Serializable;

class Student implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9184684484871255116L;
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}