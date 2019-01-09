**MOVE ACCUMULATION TO COLLECTING PARAMETER**

You have a single bulky method
that accumulates information to a local variable.

`Accumulate results to a Collecting Parameter
that gets passed to extracted methods.`

--------------------------------------------------

A Collecting Parameter is an object that you pass to methods 
in order to collect information from those methods. 
This pattern is often coupled with Composed Method.

Collecting Parameters are programmed to accumulate data from 
specific classes with specific interfaces. They don’t work so 
well when they must accumulate data from classes that hold 
diverse data and have diverse interfaces for accessing that data. 
For that case, a Visitor may be a better approach
-------------------------------------------
**Benefits and Liabilities**

+  Helps transform bulky methods into smaller, simpler, z methods.

+  Can make resulting code run faster.
 
 **Steps:**
 
 1.  Identify an accumulation method, a method that accumulates information into a result. The result, a local variable, will become a Collecting Parameter.
 
 2.  In the accumulation method, find an information accumulation step and apply Extract Method to extract it into a private method. Make sure the method’s return type is void, and pass the result to it as a parameter.
 
 3.  Repeat step 2 for every accumulation step, until the original code has been replaced with calls to extracted methods that accept and write to the result
 
 4.  Reflect on how simple your builder is for clients to use, and then make it simpler.
 
 5.  Refactor your Composite-construction code to use the new builder. This involves making your client code what is known in Design Patterns as a Builder: Client and Builder: Director.
     _Compile and test._