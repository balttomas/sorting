package com.homework.sorting.service;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import java.util.Set;

public interface StudentService {

  Set<SorterType> supportedTypes();

  Student[] sort(Student[] students, SorterType sorterType);

  Student[] sortWithBubble(Student[] students);

  Student[] sortWithHeap(Student[] students);

  Student[] sortWithMerge(Student[] students);

  Student[] randomizeStudents(int amountOfStudents);

}
