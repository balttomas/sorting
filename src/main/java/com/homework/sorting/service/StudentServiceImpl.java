package com.homework.sorting.service;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final SortersContainer sortersContainer;

  @Autowired
  public StudentServiceImpl(SortersContainer sortersContainer) {
    this.sortersContainer = sortersContainer;
  }

  @Override
  public Set<SorterType> supportedTypes() {
    return sortersContainer.findSupportedSorters();
  }

  @Override
  public Student[] sort(Student[] students, SorterType sorterType) {
    return sortersContainer.findSorter(sorterType).sort(students);
  }

  @Override
  public Student[] sortWithBubble(Student[] students) {
    return sortersContainer.findSorter(SorterType.BUBBLE).sort(students);
  }

  @Override
  public Student[] sortWithHeap(Student[] students) {
    return sortersContainer.findSorter(SorterType.HEAP).sort(students);
  }

  @Override
  public Student[] sortWithMerge(Student[] students) {
    return sortersContainer.findSorter(SorterType.MERGE).sort(students);
  }

}
