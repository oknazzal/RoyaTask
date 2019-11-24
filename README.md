# Roya task
This project demonstrate that
- Multi module project
- Dependency Injection using Dagger 2
- Clean code
- Custom Git hooks for force clean code
- MVVM arch
- Kotlin coroutines
- Unit test
- Using room for saving the data on the local database.
- Using of static analysis tools e.x. detekt
- Material design for UI/UX
- AndroidX

# Demo
<img src="images/screenshot1.png" data-canonical-src="images/screenshot1.png" width="32%" />

# Project structure
This project is using modular android application with Model-View-ViewModel architecture

# Documentation / comments
I believe that private projects doesn't need any documentation as long as the code is clean because the clean code should explain it self.

# Unit Testing
This project using a little of unit testing using Mockk and Junit 4 the project is not fully tested because of time, yeah it must be TDD but it was not.

# Why not Java
This because of time because I already have Kotlin architecture which I built before a week so for that I used the same architecture to build this application just to exploit time.

# Why I used Kotlin in previous architecture

#### Java Interoperability
Kotlin is 100% interoperable with Java. You can literally continue work on your old Java projects using Kotlin. All your favorite Java frameworks are still available, and whatever framework you’ll write in Kotlin is easily adopted by your stubborn Java loving friend.


#### Familiar Syntax
Kotlin isn’t some weird language born in academia. Its syntax is familiar to any programmer coming from the OOP domain and can be more or less understood from the get-go. There are of course some differences from Java such as the reworked constructors or the val var variable declarations. The snippet below presents most of the basics:
```kotlin
class Foo {

    val b: String = "b"     // val means unmodifiable
    var i: Int = 0          // var means modifiable

    fun hello() {
        val str = "Hello"
        print("$str World")
    }

    fun sum(x: Int, y: Int): Int {
        return x + y
    }

    fun maxOf(a: Float, b: Float) = if (a > b) a else b

}
```


#### String Interpolation
It’s as if a smarter and more readable version of Java’s String.format() was built into the language:
```kotlin
val x = 4
val y = 7
print("sum of $x and $y is ${x + y}")  // sum of 4 and 7 is 11
```


#### Type Inference
Kotlin will infer your types wherever you feel it will improve readability:
```kotlin
val a = "abc"                         // type inferred to String
val b = 4                             // type inferred to Int

val c: Double = 0.7                   // type declared explicitly
val d: List<String> = ArrayList()     // type declared explicitly
```


#### Smart Casts
The Kotlin compiler tracks your logic and auto-casts types if possible, which means no more instanceof checks followed by explicit casts:
```kotlin
if (obj is String) {
    print(obj.toUpperCase())     // obj is now known to be a String
}
```


#### Intuitive Equals
You can stop calling equals() explicitly because the == operator now checks for structural equality:
```kotlin
val john1 = Person("John")
val john2 = Person("John")
john1 == john2    // true  (structural equality)
john1 === john2   // false (referential equality)
```


#### Default Arguments
No need to define several similar methods with varying arguments:
```kotlin
fun build(title: String, width: Int = 800, height: Int = 600) {
    Frame(title, width, height)
}
```


#### Named Arguments
Combined with default arguments, named arguments eliminates the need for builders:
```kotlin
build("PacMan", 400, 300)                           
build(title = "PacMan", width = 400, height = 300)  
build(width = 400, height = 300, title = "PacMan")  
```

#### The When Expression
The switch case is replaced with the much more readable and flexible when expression:
```kotlin
when (x) {
    1 -> print("x is 1")
    2 -> print("x is 2")
    3, 4 -> print("x is 3 or 4")
    in 5..10 -> print("x is 5, 6, 7, 8, 9, or 10")
    else -> print("x is out of range")
}
```
It works both as an expression or a statement, and with or without an argument:
```kotlin
val res: Boolean = when {
    obj == null -> false
    obj is String -> true
    else -> throw IllegalStateException()
}
```


#### Properties
Custom set & get behavior can be added to public fields, which means we can stop bloating our code with mindless getters & setters.
```kotlin
class Frame {
    var width: Int = 800
    var height: Int = 600

    val pixels: Int
        get() = width * height
}
```


#### The Data Class
It’s a POJO complete with toString(), equals(), hashCode(), and copy(), and unlike in Java it won’t take up 100 lines of code:
```kotlin
data class Person(val name: String,
                  var email: String,
                  var age: Int)

val john = Person("John", "john@gmail.com", 112)
```


#### Operator Overloading
A predefined set of operators can be overloaded to improve readability:
```kotlin
data class Vec(val x: Float, val y: Float) {
    operator fun plus(v: Vec) = Vec(x + v.x, y + v.y)
}

val v = Vec(2f, 3f) + Vec(4f, 1f)
```


#### Destructuring Declarations
Some objects can be destructured, which is for example useful for iterating maps:
```kotlin
    for ((key, value) in map) {
        print("Key: $key")
        print("Value: $value")
    }
```


#### Ranges
For readability’s sake:
```kotlin
    for (i in 1..100) { /*...*/ } 
    for (i in 0 until 100) { /*...*/ }
    for (i in 2..10 step 2) { /*...*/ } 
    for (i in 10 downTo 1) { /*...*/ } 
    if (x in 1..10) { /*...*/ }
```


#### Extension Functions
Remember the first time you had to sort a List in Java? You couldn’t find a sort()function so you had to ask either your tutor or google to learn of Collections.sort(). And later when you had to capitalize a String, you ended up writing your own helper function because you didn’t know of StringUtils.capitalize().
If only there was a way to add new functions to old classes; that way your IDE could help you find the right function in code-completion. In Kotlin you can do exactly that:


#### Null Safety
Java is what we should call an almost statically typed language. In it, a variable of type String is not guaranteed to refer to a String— it might refer to null. Even though we are used to this, it negates the safety of static type checking, and as a result Java developers have to live in constant fear of NPEs.
Kotlin resolves this by distinguishing between non-null types and nullable types. Types are non-null by default, and can be made nullable by adding a ?like so:
```kotlin
var a: String = "abc"
a = null                // compile error

var b: String? = "xyz"
b = null                // no problem
```
Kotlin forces you to guard against NPEs whenever you access a nullable type:
```kotlin
val x = b.length        // compile error: b might be null
```
And while this might seem cumbersome, it’s really a breeze thanks to a few of its features. We still have smart casts, which casts nullable types to non-null wherever possible:
```kotlin
if (b == null) return
val x = b.length        // no problem
```
We could also use a safe call ?., which evaluates to null instead of throwing a NPE:
```kotlin
val x = b?.length       // type of x is nullable Int
```
Safe calls can be chained together to avoid those nested if-not-null checks we sometimes write in other languages, and if we want a default value other than null we can use the elvis operator ?::
```kotlin
val name = ship?.captain?.name ?: "unknown"
```
If none of that works for you, and you absolutely need an NPE, you will have to ask for it explicitly:
```kotlin
val x = b?.length ?: throw NullPointerException()  // same as below
val x = b!!.length                                 // same as above
```


#### Better Lambdas
Oh boy, is this a good lambda system — perfectly balanced between readability and terseness, thanks to some clever design choices. The syntax is first of all straight forward:
```kotlin
val sum = { x: Int, y: Int -> x + y }   // type: (Int, Int) -> Int
val res = sum(4,7)                      // res == 11
```
And here come the clever bits:
Method parentheses can be moved or omitted if the lambda is the last or the only argument of a method.
If we choose not to declare the argument of a single-argument-lambda it’ll be implicitly declared under the name it.
These facts combined make the following three lines equivalent:
```kotlin
numbers.filter({ x -> x.isPrime() })
numbers.filter { x -> x.isPrime() }
numbers.filter { it.isPrime() }
```
And this allows us to write concise functional code — just look at this beauty:
```kotlin
persons
    .filter { it.age >= 18 }
    .sortedBy { it.name }
    .map { it.email }
    .forEach { print(it) }
```
Kotlin’s lambda system combined with extension functions makes it ideal for DSL creation. Check out Anko for an example of a DSL that aims to enhance Android development:
```kotlin
verticalLayout {
    padding = dip(30)
    editText {
        hint = "Name"
        textSize = 24f
    }
    editText {
        hint = "Password"
        textSize = 24f
    }
    button("Login") {
        textSize = 26f
    }
}
```