# Lecture 11
> See Lecture 10 for the implementation of array stacks

Stack-based algorithms are used for *syntactical analysis* (parsing)

Example: `1 + 2 * 3 - 4`

Each operation is put into the stack and computed individually

Reading mathematical expressions from left to right returns an incorrect result

## Reverse Polish Notation (RPN)
The expression `9/(2 * 4 - 5)` is translated into `9 2 4 * 5 - /` where `9 2 4 * 5 - /` is in the reverse polish notation.

> Example

```
9 2 4 * 5 - /
9 8 5 - /
9 3 /
3
```

## Algorithmically Evaluating an RPN Expression

Until the end of the expression has been reached:

1. From left to right until the first operator;
2. Apply the operator to the two preceding operands;
3. Replace the operator and its operands by the result

This algo can be easily implemented using stacks

```java
int r = stack.pop();
int l = stack.pop();

stack.push(eval(op, r, l));
```
