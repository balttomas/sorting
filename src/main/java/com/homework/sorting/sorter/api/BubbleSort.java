package com.homework.sorting.sorter.api;

import com.homework.sorting.domain.Student;

public class BubbleSort implements Sorting {

  @Override
  public Student[] sort(Student[] students) {
    int i = 0;
    int studentsAmount = students.length;
    boolean swapNeeded = true;

    while (i < studentsAmount - 1 && swapNeeded) {
      swapNeeded = false;
      for (int j = 1; j < studentsAmount - i; j++) {
        if (students[j - 1].grade() > students[j].grade()) {
          Student temp = students[j - 1];
          students[j - 1] = students[j];
          students[j] = temp;
          swapNeeded = true;
        }
      }
      if(!swapNeeded) {
        break;
      }
      i++;
    }

    return students;
  }

}
