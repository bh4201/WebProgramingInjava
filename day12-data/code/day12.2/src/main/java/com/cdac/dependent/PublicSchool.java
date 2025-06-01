package com.cdac.dependent;

import com.cdac.dependency.Teacher;

//dependent - PublicSchool
public class PublicSchool implements School {
	// dependency - Teacher
	private Teacher subjectTeacher;

	//constructor based D.I (dependency injection) 
	//most recommended from Spring - it enforces mandatory dependency
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass()+subjectTeacher);//not null sc never inject nul dependency
	}

	//core Bussincess logic
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		//dependent(public school) is using dependency  teach
		subjectTeacher.teach();
	}

	// init method
	public void myInit() {
		System.out.println("in init");
	}

	// destroy method
	public void myDestroy() {
		System.out.println("in destroy");
	}

}
