# Lecure 23 

## Overview of Recursion
1. The solution to a given problem can be obtained by combining the solution of sub-problems
2. The sub-problems are of the same type (i.e. the same strategy applies)
3. The sub-problems are always smaller (they converge)
4. There is a size of problem that can be solved trivially (no recursive calls)

## Recursive Summation

```java
private static int sum(int[] t, int k) {
    int s, result, length = t.length - k;

    if (length == 1) {
        result = t[k];
    } else {
        int k1 = k+1;
        s = sum(t, k1);
        result = t[k] + s;
    }

    return result;
}
```

## Remarks
It's important that the size of the problems gets smaller with each successive call , otherwise this create infinate recursion (similar to infinite loops).

Base cases should be checked first so as to stop the recursion

## Recursive Pattern

Pseudo-code:
```java
type method(parameters) {
    type result;
    
    if (test parameters for base case) { // base case
        // calculate the result without recusion. the recusive process stops here
    } else { // general case
        // pre-processing: partitioning the data for example 
        result = method(sub-set of the data);
        // post-processing: combining the results for example
    }
}
```

## Recursive Problem Solving Approach
Before you reach for the keyboard, write things down and convince yourself that the recursive algo works. 