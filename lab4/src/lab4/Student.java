package lab4;

public class Student {
	private String nume;

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
		return "Student [nume=" + nume + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student && ((Student) obj).getNume().equals(nume)) {
			return true;
		} else
			return false;
	}

}
