package com.homework.sorting.domain;

import java.io.Serializable;

public record BenchmarkResult(long sortDurationMillis, SorterType sorterType) implements Serializable {
}
