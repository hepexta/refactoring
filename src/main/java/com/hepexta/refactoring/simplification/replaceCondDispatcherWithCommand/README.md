# Replace Conditional Dispatcher with Command

Conditional logic is used to dispatch requests and execute actions.

`Create a Command for each action. Store the Commands in a collection and replace the conditional logic with code to fetch and execute Commands.`

The Command pattern provides an excellent solution to such problems. 
To implement it, you simply place each piece of request-handling logic 
in a separate “command” class that has a common method, like execute() 
or run(), for executing its encapsulated handler logic. Once you have a 
family of such commands, you can use a collection to store and retrieve 
instances of them; add, remove, or change instances; and execute 
instances by invoking their execution methods.

[Example](https://github.com/gunya/refactoring/commit/ace832dc9b52a280d7919225f8f1690257a12284)
