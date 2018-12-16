EXTRACT COMPOSITE

Subclasses in a hierarchy implement the same Composite.

`Extract a superclass that implements the Composite.`

If you have two or more classes with similar features, it makes sense to move the common features to a superclass. This refactoring is similar: it addresses the case when the similar feature is a Composite that would be better off in a superclass.
 
Benefits and Liabilities

+  Eliminates duplicated child-storage and child-handling logic.

+  Effectively communicates that child-handling logic may be inherited. 