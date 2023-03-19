# Benchmarking sorting algorithms

### Supported algorithms:
* BUBBLE
* HEAP
* MERGE

### REST endpoint samples
* Set of supported sorting algorithms - GET localhost:8080/students/sorting/types
* Generate sample data - GET localhost:8080/students?amount=1000 
* Benchmark with generated sample data - GET localhost:8080/benchmark/sorting/students?amount=20000&iterations=2


Sorting with provided students in body: 
* POST localhost:8080/students/sorting?type=HEAP
* POST localhost:8080/students/sorting/bubble
* POST localhost:8080/students/sorting/heap
* POST localhost:8080/students/sorting/merge
