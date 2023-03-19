package com.homework.sorting.sorter;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class BubbleSort implements Sorting {

  @Override
  public SorterType type() {
    return SorterType.BUBBLE;
  }

  @Override
  public Student[] sort(Student[] students) {
    if (students.length < 2) {
      return students;
    }

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
