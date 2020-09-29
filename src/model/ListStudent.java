package model;

import java.util.ArrayList;

public class ListStudent {
	private ArrayList<Student> students;
	private Student stupidStudent;
	private Student smartestStudent;

	public ListStudent() {
		this.students = null;
		this.smartestStudent = null;
		this.stupidStudent = null;
	}

	public void add(Student student) {
		if (this.students == null) {
			this.students = new ArrayList<Student>();
		}
		this.students.add(student);
		this.smartestStudent = this.getSmartestStudent();
		this.stupidStudent = this.getStupidStudent();
		System.out.print(this.stupidStudent.getName());
	}

	public ListStudent(ArrayList<Student> students) {
		this.students = students;
		// this.smartestStudent = this.getSmartestStudent();
		// this.stupidStudent = this.getStupidStudent();
	}

	public Student getSmartestStudent() {
		this.smartestStudent = this.students.get(0);
		for (int i = 0; i < this.students.size(); i++) {
			if (students.get(i).getGPA() > this.smartestStudent.getGPA()) {
				this.smartestStudent = this.students.get(i);
			}

		}
		return smartestStudent;
	}

	public void setSmartestStudent(Student smartestStudent) {
		this.smartestStudent = smartestStudent;
	}

	public Student getStupidStudent() {
		this.stupidStudent = this.students.get(0);
		for (int i = 0; i < this.students.size(); i++) {
			if (this.students.get(i).getGPA() < stupidStudent.getGPA()) {
				this.stupidStudent = this.students.get(i);
			}
		}

		return this.stupidStudent;
	}

	public void setStupidStudent(Student stupidStudent) {
		this.stupidStudent = stupidStudent;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String getString() {
		return String.valueOf(this.students.size());
	}
}
