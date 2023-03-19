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
@RequestMapping("/students")
public class StudentSortingController {

  private final StudentService studentService;

  @Autowired
  public StudentSortingController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/sorting/types")
  public Set<SorterType> availableTypes() {
    return studentService.supportedTypes();
  }

  @GetMapping()
  public Student[] findStudents(
      @RequestParam(value = "amount", defaultValue = "20") int amount) {
    return studentService.randomizeStudents(amount);
  }

  @PostMapping()
  public Student[] sortWithBubble(@RequestBody Student[] students,
      @RequestParam(value = "type", defaultValue = "MERGE") SorterType type) {
    return studentService.sort(students, type);
  }

  @PostMapping("/sorting/bubble")
  public Student[] sortWithBubble(@RequestBody Student[] students) {
    return studentService.sortWithBubble(students);
  }

  @PostMapping("/sorting/heap")
  public Student[] sortWithHeap(@RequestBody Student[] students) {
    return studentService.sortWithHeap(students);
  }

  @PostMapping("/sorting/merge")
  public Student[] sortWithMerge(@RequestBody Student[] students) {
    return studentService.sortWithMerge(students);
  }

}
