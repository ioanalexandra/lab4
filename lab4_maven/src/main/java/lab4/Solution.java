package lab4;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<Student> listaStudenti;
	private List<School> listaScoli;

	public Solution() {
		listaStudenti = new LinkedList<>();
		listaScoli = new LinkedList<>();
	}

	public void addPair(Student s, School h) {
		listaStudenti.add(s);
		listaScoli.add(h);
	}

	// am afisat solutia in forma friendly
	@Override
	public String toString() {
		String aux = "[";
		for (int i = 0; i < listaStudenti.size(); ++i) {
			aux += listaStudenti.get(i);
			aux += ":";
			aux += listaScoli.get(i);
			aux += ", ";
		}
		aux += "]\n";
		return aux;
	}

	public void addSchool(School sc) {
		listaScoli.add(sc);
	}

	public void addAllStud(List<Student> l) {
		listaStudenti.addAll(l);
	}

	public List<Student> getStud() {
		return listaStudenti;
	}

	public List<School> getSch() {
		return listaScoli;
	}
}
