package com.homework.sorting.service;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import com.homework.sorting.domain.StudentResult;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

  private final SortersContainer sortersContainer;
  private final StudentRepository studentRepository;

  @Override
  public Set<SorterType> supportedTypes() {
    return sortersContainer.findSupportedSorters();
  }

  @Override
  public StudentResult sort(Student[] students, SorterType sorterType) {
    return evaluateSortingResult(students, sorterType);
  }

  @Override
  public StudentResult sortWithBubble(Student[] students) {
    return evaluateSortingResult(students, SorterType.BUBBLE);
  }

  @Override
  public StudentResult sortWithHeap(Student[] students) {
    return evaluateSortingResult(students, SorterType.HEAP);
  }

  @Override
  public StudentResult sortWithMerge(Student[] students) {
    return evaluateSortingResult(students, SorterType.MERGE);
  }

  @Override
  public Student[] randomizeStudents(int amountOfStudents) {
    return studentRepository.randomize(amountOfStudents);
  }

  private StudentResult evaluateSortingResult(Student[] unsortedStudents, SorterType sorterType) {
    Student[] students = unsortedStudents.clone();
    Instant start = Instant.now();
    Student[] result = sortersContainer.pickSorter(sorterType).sort(students);
    Instant finish = Instant.now();
    long duration = Duration.between(start, finish).toMillis();
    log.info("Sorted {} students with {} in {} ms", students.length, sorterType, duration);
    return new StudentResult(duration, result);
  }

}
