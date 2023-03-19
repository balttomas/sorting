package com.homework.sorting.service;

import static java.util.stream.Collectors.toMap;

import com.homework.sorting.domain.SorterType;
import com.homework.sorting.sorter.Sorting;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortersContainer {

  private final Map<SorterType, Sorting> sortersByType;

  @Autowired
  public SortersContainer(List<Sorting> availableSorters) {
    sortersByType = availableSorters.stream().collect(toMap(Sorting::type, sorting -> sorting));
  }

  public Sorting findSorter(SorterType sorterType){
    return sortersByType.get(sorterType);
  }

  public Set<SorterType> findSupportedSorters() {
    return sortersByType.keySet();
  }
}
