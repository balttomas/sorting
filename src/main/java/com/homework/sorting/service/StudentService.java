package com.homework.sorting.service;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import com.homework.sorting.domain.StudentResult;
import java.util.Set;

public interface StudentService {

  Set<SorterType> supportedTypes();

  StudentResult sort(Student[] students, SorterType sorterType);

  StudentResult sortWithBubble(Student[] students);

  StudentResult sortWithHeap(Student[] students);

  StudentResult sortWithMerge(Student[] students);

  Student[] randomizeStudents(int amountOfStudents);

}
