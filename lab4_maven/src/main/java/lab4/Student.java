package lab4;

public class Student {
	private String nume;
	private float score;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public Student(String a) {
		nume = a;
	}

	@Override
	public String toString() {
		return nume;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student && ((Student) obj).getNume().equals(nume)) {
			return true;
		} else
			return false;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
