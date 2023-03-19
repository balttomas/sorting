package com.homework.sorting.sorter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.homework.sorting.domain.Student;
import org.junit.jupiter.api.Test;

public class HeapSortTest {

  private final Sorting sorter = new HeapSort();

  @Test
  void shouldSortByDefaultAscending() {
    Student student1 = new Student("Jan Peterson", 8.7);
    Student student2 = new Student("Jessie Peterson", 9.7);
    Student student3 = new Student("Jolanta Smailyte", 7.73);

    Student[] result = sorter.sort(new Student[]{student1, student2, student3});

    assertNotNull(result);
    assertArrayEquals(new Student[]{student3, student1, student2}, result);
  }

}
