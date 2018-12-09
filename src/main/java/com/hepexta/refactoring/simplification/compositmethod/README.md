COMPOSE METHOD

You can’t rapidly understand a method’s logic.

`Transform the logic into a small number of
intention-revealing steps at the same level of detail.`

Benefits and Liabilities

+  Efficiently communicates what a method does and how it does what it does.

+  Simplifies a method by breaking it up into well-named chunks of behavior at the same level of detail.

–  _Can lead to an overabundance of small methods._

–  _Can make debugging difficult because logic is spread out across many small methods._

•    **Think small**: Composed Methods are rarely more than ten lines of code and are usually about five lines.

•    **Remove duplication and dead code**: Reduce the amount of code in the method by getting rid of blatant and/or subtle code duplication or code that isn’t being used.

•    **Communicate intention**: Name your variables, methods, and parameters clearly so they communicate their purposes (e.g., public void addChildTo(Node parent)).

•    **Simplify**: Transform your code so it’s as simple as possible. Do this by questioning how you’ve coded something and by experimenting with alternatives.

•    **Use the same level of detail**: When you break up one method into chunks of behavior, make the chunks operate at similar levels of detail. For example, if you have a piece of detailed conditional logic mixed in with some high-level method calls, you have code at different levels of detail. Push the detail down into a well-named method, at the same level of detail as the other methods in the Composed Method.