package lab4;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Score extends Algorithm {
	private Map<Student, List<School>> preferinteStudenti;
	private List<Student> studList;

	public Score(Problem problem, List<Student> studList) {
		super(problem);
		this.preferinteStudenti = problem.getPreferinteStudenti();
		this.studList = studList;
	}

	@Override
	public Solution solve() {
		Solution s = new Solution();
		s.addAllStud(studList);
		// am sortat studentii dupa cel mai mare scor
		Collections.sort(s.getStud(), (s1, s2) -> {
			if (s1.getScore() < s2.getScore()) {
				return 1;
			} else if (s1.getScore() == s2.getScore()) {
				return 0;
			} else
				return -1;
		});
		// am ales studentii dupa cel mai mare scor si preferintele de scoli si am
		// adaugat in solutie dupa care am scazut capacitatea scolilor
		for (Student st : s.getStud()) {
			for (School sc : preferinteStudenti.get(st)) {
				if (sc.getCurrCapacity() > 0) {
					s.addSchool(sc);
					sc.decreaseCurrCapacity();
					break;
				}
			}
		}
		return s;
	}

}
