TrimObjectGraph
===============

Trims all Strings encountered within an Object graph recursively. 
This utility uses Java Reflection API to traverse through an object graph with disciplined syntax of getters and setters and recursively trims the String properties.

1. If the current level of `Property` is of type `String`
2. If its an `Object` Array of Properties
3. If its a `String` array
4. If its a type of Java `Collection` class
5. Separate placement for `Map` with special conditions to process its `keys` and `values`

**Next Steps**

1. Handle undisciplined syntax of properties (invalid getters/setters)
2. Handle chained Collections: for example, `List<List<Person>>`
3. `Guava` collection library support

