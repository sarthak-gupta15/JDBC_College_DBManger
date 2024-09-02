package com.college.sarthak;

public class PojoClass {
	private int eno;
    private String name;
    private int div;
    private String gender;
    private int marks;
    
//	public PojoClass(int eno, String name, int div, String gender, double marks) {
//		super();
//		this.eno = eno;
//		this.name = name;
//		this.div = div;
//		this.gender = gender;
//		this.marks = marks;
//	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "PojoClass [eno=" + eno + ", name=" + name + ", div=" + div + ", gender=" + gender + ", marks=" + marks
				+ "]";
	}
    
}
