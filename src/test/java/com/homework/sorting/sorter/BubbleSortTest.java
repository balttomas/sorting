package com.homework.sorting.sorter;

import com.homework.sorting.domain.Student;
import com.homework.sorting.sorter.api.BubbleSort;
import com.homework.sorting.sorter.api.Sorting;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

  private final Sorting sorter = new BubbleSort();

  @Test
  void shouldSortByDefaultAscending() {
    Student student1 = new Student("Jan Peterson", 8.7);
    Student student2 = new Student("Jessie Peterson", 9.7);
    Student student3 = new Student("Jolanta Smailyte", 7.73);

    Student[] result = sorter.sort(new Student[]{student1, student2, student3});


  }

}
