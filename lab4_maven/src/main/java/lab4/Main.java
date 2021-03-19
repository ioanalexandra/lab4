package lab4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class Main {
	public static void main(String[] args) {
		// am creat studentii si scolile folosind streamuri
		var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
		var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);

		schools[0].setCapacitate(1);
		schools[1].setCapacitate(2);
		schools[2].setCapacitate(2);

		List<Student> studentList = new LinkedList<>();
		studentList.addAll(Arrays.asList(students));
		// am sortat folosind o functie lambda si un comparator
		Collections.sort(studentList, (s1, s2) -> s1.getNume().compareTo(s2.getNume()));
		Set<School> schoolSet = new TreeSet<>();
		schoolSet.addAll(Set.of(schools));
		// am creat mapuri pentru studenti si scoli si am adaugat datele din exemplu
		Map<Student, List<School>> preferinteStudenti = new HashMap<>();
		Map<School, List<Student>> preferinteScoli = new Hashtable<>();
		preferinteStudenti.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
		preferinteStudenti.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
		preferinteStudenti.put(students[2], Arrays.asList(schools[0], schools[1]));
		preferinteStudenti.put(students[3], Arrays.asList(schools[0], schools[2]));
		preferinteScoli.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
		preferinteScoli.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
		preferinteScoli.put(schools[2], Arrays.asList(students[0], students[2], students[3]));
		System.out.print(preferinteStudenti);
		System.out.print(preferinteScoli);
		// am facut querys din cerinta
		System.out.println("\nQueries");
		List<School> queryList = Arrays.asList(schools[1], schools[2]);
		studentList.stream().filter(s -> preferinteStudenti.get(s).containsAll(queryList)).forEach(System.out::print);
		System.out.println();
		Student queryStudent = students[0];
		// am filtrat scolile care au un anumit student ca top preference
		Stream.of(schools).filter(h -> preferinteScoli.get(h).get(0).equals(queryStudent)).forEach(System.out::print);
		/*
		 * Faker faker = new Faker(); for (int i = 0; i < studentList.size(); ++i) {
		 * studentList.get(i).setNume(faker.name().lastName()); } for (School s :
		 * schoolSet) { s.setNume(faker.name().lastName()); }
		 */

		System.out.println("\nLe afisez cu stream:");
		studentList.stream().forEach(System.out::print);
		System.out.println();
		schoolSet.stream().forEach(System.out::print);

		// solving algorithm

		students[1].setScore(10f);
		students[0].setScore(8.56f);
		students[2].setScore(6.34f);
		students[3].setScore(9.2f);

		System.out.println("\nSolution");
		Problem p = new Problem(preferinteStudenti, preferinteScoli);
		Algorithm a = new Score(p, studentList);
		Solution s = a.solve();
		System.out.print(s);
	}
}
