package lab4;

public class School implements Comparable<School> { // ca sa fie comparable
	private String nume;
	private int capacitate;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getCapacitate() {
		return capacitate;
	}

	public void setCapacitate(int capacitate) {
		this.capacitate = capacitate;
	}

	public School(String a) {
		nume = a;
	}

	@Override
	public int compareTo(School o) {

		return nume.compareTo(o.getNume());
	}

	@Override
	public String toString() {
		return "School [nume=" + nume + ", capacitate=" + capacitate + "]";
	}

}
