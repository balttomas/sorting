package com.homework.sorting.sorter;

import com.homework.sorting.domain.Student;

/**
 * A public API to sort students by performance.
 */
public interface Sorting {

  Student[] sort(Student[] students);

}
