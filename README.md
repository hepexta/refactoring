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

* Subclasses in a hierarchy implement the same Composite.
[Extract Composite](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/extractcomposite)
* Two methods in subclasses perform similar steps in the same order, yet the steps are different.
[Form Template Method](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/formtemplatemethod)
* A class processes single and multiple objects using separate pieces of code.
[Replace Distinctions With Composite](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/replaceDistinctionsWithComposite)
* Subclasses are hard-coded to notify a single instance of another class.
[Replace Hard-coded Notifications With Observer](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/replaceHardcodedNtfWithObserver)
* Clients interact with two classes, one of which has a preferred interface.
[Unify Interfaces With Adapter](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/unifyinterfacewithadapter)
* One class adapts multiple versions of a component, library, API, or other entity.
[Extract Adapter](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/generalization/extractadapter)

# Protection

A refactoring that improves the protection of existing code must do so in a way that doesn’t alter the behavior of the existing code. All three refactorings in this section do just that. Your motivation for applying them may be to improve protection or it may be a standard refactoring motivation, such as to reduce duplication or to simplify or clarify code.

* A field’s type (e.g., a String or int) fails to protect it from unsafe assignments and invalid equality comparisons
[Replace Type Code with Class](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/protection/replaceTypeWithClass)
* Your code creates multiple instances of an object, and that uses too much memory or slows system performance.
[Limit Instantiation With Singleton](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/protection/limitInstantiationWithSingleton)

# Accumulation

A good deal of code in software systems accumulates information. The refactorings in this section target the improvement of code that accumulates information within an object or across several objects.

* You have a single bulky method that accumulates information to a local variable. 
[Move Accumulation to Collecting Parameter](https://github.com/gunya/refactoring/tree/master/src/main/java/com/hepexta/refactoring/accumulation/moveAccumWithCollectParam)
