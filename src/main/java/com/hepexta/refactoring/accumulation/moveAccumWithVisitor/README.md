**MOVE ACCUMULATION TO VISITOR**

A method accumulates information from
heterogeneous classes.

`Move the accumulation task to a Visitor that can
visit each class to accumulate the information.`

`a visitee`, a class from which the visitor will accumulate data

**Benefits and Liabilities**

+  Accommodates numerous algorithms for the same heterogeneous object structure.

+  Visits classes in the same or different hierarchies.

+  Calls type-specific methods on heterogeneous classes without type-casting.

–  Complicates a design when a common interface can make heterogeneous classes homogeneous.

–  A new visitable class requires a new accept method along with a new visit method on each Visitor.

–  May break encapsulation of visited classes.

[Example](https://github.com/gunya/refactoring/pull/24)  