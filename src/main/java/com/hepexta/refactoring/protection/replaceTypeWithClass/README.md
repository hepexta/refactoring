REPLACE TYPE CODE WITH CLASS

A field’s type (e.g., a String or int) fails to protect it
from unsafe assignments and invalid equality comparisons.

`Constrain the assignments and equality comparisons
by making the type of the field a class.`

**Motivation**

A primary motivation for refactoring from a type code to a class 
is to make code type-safe. One way to do that is to constrain the 
possible values that may be assigned to or equated with a field or variable.