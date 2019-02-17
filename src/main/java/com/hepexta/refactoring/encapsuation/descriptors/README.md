# Encapsulate classes with factory

Clients directly instantiate classes that reside in one package and implement a common interface.

`Make the class constructors non-public and let clients create instances of them using a Factory.`

Make the class constructors non-public and let clients create instances of them using a Factory.

# Benefits

+  Simplifies the creation of kinds of instances by making the set available through intention-revealing methods.
+  Reduces the `conceptual weight` of a package by hiding classes that don’t need to be public.
+  Helps enforce the mantra `program to an interface, not an implementation`.

# Liabilities
+  Requires new/updated Creation Methods when new kinds of instances must be created.
+  Limits customization when clients can only access a Factory’s binary code, not its source code.

[Example](https://github.com/gunya/refactoring/pull/2/files)
