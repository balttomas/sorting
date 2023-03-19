package com.homework.sorting.sorter;

import com.homework.sorting.domain.Student;

public class HeapSort implements Sorting {

  @Override
  public Student[] sort(Student[] students){
    int size = students.length;
    Student swapper;

    //building max heap using heapify
    int index = (size/2) - 1;
    while(index >=0){
      heapify(students,size,index);
      index--;
    }

    //We will extract elements from heap one by one and reduce size of the heap (assuming part of students is sorted controlled by index)
    for(index = size -1; index > 0; index--){
      //largest resides on root in max-heap
      swapper = students[0];
      students[0] = students[index];
      students[index] = swapper;

      //call heapify on root of reduced heap
      heapify(students,index, 0);
    }

    return students;
  }

  void heapify(Student[] students, int size, int index){
    int  maximum = index;
    int leftChild = 2*index + 1;
    int rightChild = 2*index + 2;
    Student swapper;

    //now check if right and left child are greater than parent and the right and left child index are not out of bound.
    if(leftChild < size && students[leftChild].grade() > students[maximum].grade()){
      maximum = leftChild;
    }
    if(rightChild < size && students[rightChild].grade() > students[maximum].grade()){
      maximum = rightChild;
    }

    //if maximum is not equal to its initial declaration(root) then swap.
    if(maximum != index){
      swapper = students[index];
      students[index] = students[maximum];
      students[maximum] = swapper;

      //we will recursively heapify the affected sub-tree
      heapify(students,size,maximum);
    }
  }

}
