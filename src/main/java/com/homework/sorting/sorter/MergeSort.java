package com.homework.sorting.sorter;

import static java.lang.System.arraycopy;

import com.homework.sorting.domain.Student;

public class MergeSort implements Sorting {

  @Override
  public Student[] sort(Student[] students) {
    if (students.length < 2) {
      return students;
    }
    mergeSort(students, students.length);
    return students;
  }

  private void mergeSort(Student[] students, int totalAmount) {
    if (totalAmount < 2) {
      return;
    }
    int halfOfTotalAmount = totalAmount / 2;
    Student[] left = new Student[halfOfTotalAmount];
    Student[] right = new Student[totalAmount - halfOfTotalAmount];

    arraycopy(students, 0, left, 0, halfOfTotalAmount);
    for (int i = halfOfTotalAmount; i < totalAmount; i++) {
      right[i - halfOfTotalAmount] = students[i];
    }
    mergeSort(left, halfOfTotalAmount);
    mergeSort(right, totalAmount - halfOfTotalAmount);

    merge(students, left, right, halfOfTotalAmount, totalAmount - halfOfTotalAmount);
  }

  private void merge(
      Student[] students, Student[] left, Student[] right, int leftAmount, int rightAmount) {

    int leftIdx = 0, rightIdx = 0, resultIdx = 0;
    while (leftIdx < leftAmount && rightIdx < rightAmount) {
      if (left[leftIdx].grade() <= right[rightIdx].grade()) {
        students[resultIdx++] = left[leftIdx++];
      }
      else {
        students[resultIdx++] = right[rightIdx++];
      }
    }
    while (leftIdx < leftAmount) {
      students[resultIdx++] = left[leftIdx++];
    }
    while (rightIdx < rightAmount) {
      students[resultIdx++] = right[rightIdx++];
    }
  }
}
