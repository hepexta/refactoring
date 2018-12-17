REPLACE CONDITIONAL LOGIC WITH STRATEGY

Conditional logic in a method controls which
of several variants of a calculation are executed.

`Create a Strategy for each variant and make the method
delegate the calculation to a Strategy instance.`

----------------------------------------------------------------

_Replace Conditional Logic with Strategy_ involves object composition: you produce a family of classes for each variation of the algorithm and outfit the host class with one Strategy instance to which the host delegates at runtime. An inheritance-based solution can be achieved by applying _Replace Conditional with Polymorphism_

[Example](https://github.com/gunya/refactoring/pull/6/files)

