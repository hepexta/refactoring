REPLACE ONE/MANY DISTINCTIONS WITH COMPOSITE

A class processes single and multiple objects using separate pieces of code.

`Use a Composite to produce one piece of code capable of handling single or multiple objects.`

When a class has a method for processing one object and a nearly identical method for processing a collection of the objects, a one/many distinction exists. Such a distinction can result in problems such as the following.

Benefits and Liabilities

+  Removes duplicate code associated with handling one or many objects.

+  Provides a uniform way to process one or many objects.

+  Supports richer ways to process many objects (e.g., an OR expression).

–  May require runtime checks for type safety during construction of the Composite.