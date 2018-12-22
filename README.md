# Refactoring by Patterns

# Creation

While every object-oriented system creates objects or object structures, the creation code is not always free of duplication, simple, intuitive, or as loosely coupled to client code as it could be.
* [Replace Constructors with Creation Methods](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/loanrisk/objectcreation)
* [Move Creation Knowledge To Factory](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/creational/htmlparser)
* [Encapsulate Composite With Builder](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/encapsuation/composit)
* [Encapsulate Classes With Factory](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/encapsuation/descriptors)

# Simplification

Much of the code we write doesn’t start out being simple. To make it simple, we must reflect on what isn’t simple about it and continually ask, “`How could it be simpler?`” We can often simplify code by considering a completely different solution. The refactorings in this chapter present different solutions for simplifying methods, state transitions, and tree structures.

* [Move Embellishment to Decorator](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/embelishmenttodecorator)
* [Composite Method](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/compositmethod)
* [Replace Conditional Dispatcher With Command](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/replaceCondDispatcherWithCommand)
* [Replace Conditional Logic With Strategy](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/replaceconditwithstrategy)
* [Replace Implicit Tree With Composite](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/replaceImplicitTreeWithComposite)
* [Replace State-Altering Conditionals With State](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/simplification/replacestatealteredwithstate)

# Generalization

Generalization is the transformation of specific code into general-purpose code. The production of generalized code frequently occurs as a result of refactoring. All seven refactorings in this chapter yield generalized code. The most common motivation for applying them is to remove duplicated code. A secondary motivation is to simplify or clarify code.

* [Extract Composite](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/extractcomposite)
* [Form Template Method](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/formtemplatemethod)
