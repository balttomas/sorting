package com.homework.sorting.service;

import static java.util.stream.Collectors.toMap;

import com.homework.sorting.domain.BenchmarkResult;
import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import com.homework.sorting.domain.StudentResult;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SortingBenchmark {

  private final StudentService studentService;

  public Map<Integer, List<BenchmarkResult>> runAllSupportedSorterTypes(int amountOfStudents, int amountOfIterations) {
    Student[] unsorted = studentService.randomizeStudents(amountOfStudents);
    return IntStream.rangeClosed(1, amountOfIterations)
        .boxed()
        .collect(toMap(key -> key, value -> measureDuration(unsorted)));
  }

  private List<BenchmarkResult> measureDuration(Student[] unsorted) {
    return studentService.supportedTypes()
        .stream()
        .map(sorterType -> sortWithDuration(unsorted, sorterType))
        .toList();
  }

  private BenchmarkResult sortWithDuration(Student[] unsorted, SorterType sorterType) {
    StudentResult result = studentService.sort(unsorted, sorterType);
    return new BenchmarkResult(result.sortDurationMillis(), sorterType);
  }

}
