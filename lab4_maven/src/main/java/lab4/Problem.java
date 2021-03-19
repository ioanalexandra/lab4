package lab4;

import java.util.List;
import java.util.Map;

public class Problem {
	private Map<Student, List<School>> preferinteStudenti;
	private Map<School, List<Student>> preferinteScoli;

	public Map<Student, List<School>> getPreferinteStudenti() {
		return preferinteStudenti;
	}

	public void setPreferinteStudenti(Map<Student, List<School>> preferinteStudenti) {
		this.preferinteStudenti = preferinteStudenti;
	}

	public Map<School, List<Student>> getPreferinteScoli() {
		return preferinteScoli;
	}

	public void setPreferinteScoli(Map<School, List<Student>> preferinteScoli) {
		this.preferinteScoli = preferinteScoli;
	}

	public Problem(Map<Student, List<School>> m1, Map<School, List<Student>> m2) {
		preferinteStudenti = m1;
		preferinteScoli = m2;
	}
}
