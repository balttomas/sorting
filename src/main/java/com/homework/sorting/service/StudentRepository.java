package com.homework.sorting.service;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;
import com.homework.sorting.domain.Student;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class StudentRepository {

  Student[] randomize(int amountOfStudents) {
    Name nameGenerator = Faker.instance().name();
    Number gradeGenerator = Faker.instance().number();

    return IntStream.rangeClosed(1, amountOfStudents)
        .mapToObj(idx -> new Student(
            String.join(" ", nameGenerator.firstName(), nameGenerator.lastName()),
            gradeGenerator.randomDouble(2, 1, 10))
        ).toArray(Student[]::new);
  }

}
