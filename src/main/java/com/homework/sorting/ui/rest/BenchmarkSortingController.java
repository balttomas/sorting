package com.homework.sorting.ui.rest;

import com.homework.sorting.domain.BenchmarkResult;
import com.homework.sorting.service.SortingBenchmark;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benchmark")
@RequiredArgsConstructor
public class BenchmarkSortingController {

  private final SortingBenchmark sortingBenchmark;

  @GetMapping("/sorting/students")
  public SortedMap<Integer, List<BenchmarkResult>> executeAllSupportedSortings(
      @RequestParam(value = "amount", defaultValue = "10000") int amount,
      @RequestParam(value = "iterations", defaultValue = "2") int iterations
  ) {
    return new TreeMap<>(sortingBenchmark.runAllSupportedSorterTypes(amount, iterations));
  }

}
