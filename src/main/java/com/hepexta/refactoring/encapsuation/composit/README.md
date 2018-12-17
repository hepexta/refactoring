**ENCAPSULATE COMPOSITE WITH BUILDER**

Building a Composite is repetitive, complicated,
or error-prone.

`Simplify the build by letting a Builder handle the details.`

--------------------------------------------------

**Builders** often encapsulate **Composites** because the construction of Composites can frequently be repetitive, complicated, or error-prone. For example, to add a child node to a parent node, a client must do the following:

•  Instantiate a new node

•  Initialize the new node

•  Correctly add the new node to the right parent node

This process is error-prone because you can either forget to add a new node to a parent or you can add the new node to the wrong parent. The process is repetitive because it requires performing the same batch of construction steps over and over again. It’s well worth refactoring to any Builder that can reduce errors or minimize and simplify creation steps.

-------------------------------------------
**Benefits and Liabilities**

+  `Reduces the repetitive and error-prone nature of Composite creation.`

+  `Creates a loose coupling between client and Composite.`

+  `Allows for different representations of the encapsulated Composite or complex object.`

 –  _`May not have the most intention-revealing interface.`_
 
 **Steps:**
 
 1.  Create a builder, a new class that will become a Builder by the end of this refactoring. Make it possible for your builder to produce a one-node Composite. Add a method to the builder to obtain the result of its build.
   _Compile and test._
 
 2.  Make the builder capable of building children. This often involves creating multiple methods for allowing clients to easily direct the creation and positioning of children.
 _Compile and test._
 
 3.  If the Composite-construction code you’re replacing sets attributes or values on nodes, make the builder capable of setting those attributes and values.
_Compile and test._
 
 4.  Reflect on how simple your builder is for clients to use, and then make it simpler.
 
 5.  Refactor your Composite-construction code to use the new builder. This involves making your client code what is known in Design Patterns as a Builder: Client and Builder: Director.
     _Compile and test._