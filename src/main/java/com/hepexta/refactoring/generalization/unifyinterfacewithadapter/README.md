**UNIFY INTERFACES WITH ADAPTER**

Clients interact with two classes, one of which
has a preferred interface.

`Unify the interfaces with an Adapter.`

•  Two classes do the same thing or similar things and have different interfaces.

•  Client code could be simpler, more straightforward, and more succinct if the classes shared the same interface.

•  You can’t simply alter the interface of one of the classes because it’s part of a third-party library, or it’s part of a framework that many other clients already use, or you lack source code.

**Benefits and Liabilities**

+  Removes or reduces duplicated code by enabling clients to communicate with alternative classes via the same interface.

+  Simplifies client code by making it possible to communicate with objects via a common interace.

+  Unifies how clients interact with alternative classes.

–  Complicates a design when you can change the interface of a class rather than adapting it.

[Example](https://github.com/gunya/refactoring/pull/17/files)
