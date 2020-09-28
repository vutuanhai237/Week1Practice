package model;

public class Student {
	private String name;
	private double mathScore;
	private double englishScore;
	private double physicalScore;
	@SuppressWarnings("unused")
	private double GPA;

	public Student() {
		this.name = "";
		this.mathScore = 0.0;
		this.englishScore = 0.0;
		this.physicalScore = 0.0;
		this.GPA = 0.0;
	}

	public Student(String name, Double mathScore, Double englishScore, Double physicalScore) {
		this.name = name;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.physicalScore = physicalScore;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMathScore() {
		return mathScore;
	}

	public void setMathScore(Double mathScore) {
		this.mathScore = mathScore;
	}

	public double getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(Double englishScore) {
		this.englishScore = englishScore;
	}

	public double getPhysicalScore() {
		return physicalScore;
	}

	public void setPhysicalScore(Double physicalScore) {
		this.physicalScore = physicalScore;
	}

	public double getGPA() {
		return (double) Math.round((this.mathScore + this.englishScore + this.physicalScore) / 3);
	}

	public void setGPA(Double GPA) {
		this.GPA = GPA;
	}
}
