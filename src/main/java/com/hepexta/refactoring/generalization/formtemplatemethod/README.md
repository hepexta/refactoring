FORM TEMPLATE METHOD

Two methods in subclasses perform similar steps
in the same order, yet the steps are different.

`Generalize the methods by extracting their steps
into methods with identical signatures, then pull up
the generalized methods to form a Template Method.`

Template Methods _“implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary”_

A Template Method’s invariant behavior consists of the following:

•  Methods called and the ordering of those methods

•  Abstract methods that subclasses must override

•  Hook methods (i.e., concrete methods) that subclasses may override 

**Benefits and Liabilities**

+  Removes duplicated code in subclasses by moving invariant behavior to a superclass.

+  Simplifies and effectively communicates the steps of a general algorithm.

+  Allows subclasses to easily customize an algorithm.

–  Complicates a design when subclasses must implement many methods to flesh out the algorithm.

[Example](https://github.com/gunya/refactoring/pull/13/files)
