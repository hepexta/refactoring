LIMIT INSTANTIATION WITH SINGLETON

Your code creates multiple instances of an object, and
that uses too much memory or slows system performance.

`Replace the multiple instances with a Singleton.`

scenarios:

•  Users of your system are complaining about system performance.

•  Your profiler tells you that you can improve performance 
by not instantiating certain objects over and over again.

•  The objects you want to share have no state or contain state that is sharable.

At that point, you should run the profiler to check how memory usage and performance have been affected. 
Hopefully, things have improved. If not, you may decide to undo these steps

[Example](https://github.com/gunya/refactoring/pull/22/files)
