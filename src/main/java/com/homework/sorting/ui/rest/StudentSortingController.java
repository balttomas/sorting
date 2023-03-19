package com.homework.sorting.ui.rest;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.domain.Student;
import com.homework.sorting.service.StudentService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/sorting")
public class StudentSortingController {

  private final StudentService sorterService;

  @Autowired
  public StudentSortingController(StudentService sorterService) {
    this.sorterService = sorterService;
  }

  @GetMapping()
  public Student[] test() {
    Student student1 = new Student("Jan Peterson", 8.7);
    Student student2 = new Student("Jessie Peterson", 9.7);
    Student student3 = new Student("Jolanta Smailyte", 7.73);

    return new Student[]{student1, student2, student3};
  }

  @GetMapping("/types")
  public Set<SorterType> availableTypes() {
    return sorterService.supportedTypes();
  }

  @PostMapping()
  public Student[] sortWithBubble(@RequestBody Student[] students,
      @RequestParam(value = "type", defaultValue = "MERGE") SorterType type) {
    return sorterService.sort(students, type);
  }

  @PostMapping("/bubble")
  public Student[] sortWithBubble(@RequestBody Student[] students) {
    return sorterService.sortWithBubble(students);
  }

  @PostMapping("/heap")
  public Student[] sortWithHeap(@RequestBody Student[] students) {
    return sorterService.sortWithHeap(students);
  }

  @PostMapping("/merge")
  public Student[] sortWithMerge(@RequestBody Student[] students) {
    return sorterService.sortWithMerge(students);
  }

}
