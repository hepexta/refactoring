**REPLACE HARD-CODED NOTIFICATIONS WITH OBSERVER**

Subclasses are hard-coded to notify a single
instance of another class.

`Remove the subclasses by making their superclass
capable of notifying one or more instances of any class
that implements an Observer interface.`

**Benefits and Liabilities**

+  Loosely couples a subject with its observers.

+  Supports one or many observers.

–  Complicates a design when a hard-coded notification will suffice.

–  Complicates a design when you have cascading notifications.

–  May cause memory leaks when observers aren’t removed from their subjects.

[Example](https://github.com/gunya/refactoring/pull/19/files)
