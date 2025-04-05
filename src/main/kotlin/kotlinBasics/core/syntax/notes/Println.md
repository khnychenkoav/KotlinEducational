<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/Println.png">
    <img alt="Gradle Logo" src="../../../../../../../images/Println.png">
  </picture>
</div>


# 🖨️ Printing Output in Kotlin: `println()`, String Interpolation, and Immutability

Displaying text on the screen is one of the most fundamental actions in any program. In Kotlin, this is done using the `println()` function — but behind this simple line lies a set of powerful language features that shape how your programs communicate, debug, and log.

---

## 🧠 What You Will Learn

- How `print()` and `println()` behave
- What string interpolation is and how it works
- The difference between `String` literals and expressions
- Why strings are **immutable** and how it affects your code
- What happens "under the hood" when printing in Kotlin

---

## 📤 The Basics: `print()` vs `println()`

Kotlin offers two primary functions for printing:

```kotlin
print("Hello, ")
println("world!")
```

Output:
```
Hello, world!
```

| Function   | Behavior                         |
|------------|----------------------------------|
| `print()`  | Prints text *without* a newline  |
| `println()`| Prints text *with* a newline     |

> Under the hood, both functions are wrappers around `System.out.print()` and `System.out.println()` from the Java standard library. So when Kotlin code is compiled to JVM bytecode, it uses standard Java I/O operations.

---

## 💬 String Interpolation

String interpolation allows embedding values directly inside string literals:

```kotlin
val name = "Charlie"
println("Hello, $name!") // → Hello, Charlie!
```

You can also embed expressions using `${}`:

```kotlin
val a = 5
val b = 3
println("Sum: ${a + b}") // → Sum: 8
```

📌 **Note**: Inside `${}`, you can put any valid expression, including function calls.

> Kotlin compiles interpolated strings into a series of calls to `StringBuilder.append()` — this is efficient and avoids creating unnecessary intermediate strings.

---

## 📦 Behind the Scenes: Compilation to Bytecode

Let's take this example:

```kotlin
val user = "Alice"
println("User: $user")
```

When compiled to JVM bytecode, Kotlin transforms it roughly into:

```java
String user = "Alice";
System.out.println("User: " + user);
```

But if you're interpolating multiple variables:

```kotlin
println("A + B = ${a + b}")
```

This becomes something like:

```java
System.out.println(new StringBuilder()
    .append("A + B = ")
    .append(a + b)
    .toString());
```

This is both performant and concise. Kotlin hides the boilerplate, but still produces optimized code.

---

## 🔒 Strings Are Immutable

Like in Java, **Kotlin strings are immutable**.

```kotlin
val message = "Hello"
message += " World" // Compilation error — reassignment is not allowed if 'val'
```

What this means:
- You **cannot change** the contents of a string once it is created.
- When you use `+`, Kotlin creates a **new string** behind the scenes.
- Mutations like `.toUpperCase()` return a new string, they don't modify the original.

Why it matters:
- Safer: prevents unintended side effects.
- Predictable: you know your strings won't be altered elsewhere.
- Efficient: immutable objects are easier to optimize and share across threads.

> ✅ Tip: For heavy string manipulation (e.g. inside loops), use `StringBuilder` for better performance.

---

## 🔠 Multiline Strings and Formatting

Kotlin supports **multiline strings** using triple quotes:

```kotlin
val banner = """
    Welcome to Kotlin!
    Let's write clean code ✨
""".trimIndent()

println(banner)
```

This outputs:

```
Welcome to Kotlin!
Let's write clean code ✨
```

Use `trimIndent()` to clean up indentation. It’s particularly useful in command-line tools or logging.

---

## 🎯 Common Mistakes

| Mistake | Problem | Fix |
|--------|---------|-----|
| `"Sum: $a + $b"` | This prints `"Sum: 5 + 3"` — as text | Use `"Sum: ${a + b}"` to compute |
| `"Hello, " + name` | Works, but verbose | Prefer `"Hello, $name"` |
| `"Line1\nLine2"` | Escaped newlines make string harder to read | Use multiline strings if possible |

---

## ⚙️ Special Characters in Strings

| Escape | Meaning           |
|--------|--------------------|
| `\n`   | New line            |
| `\t`   | Tab character       |
| `\"`   | Double quote inside string |
| `\\`   | Backslash           |

Example:

```kotlin
println("First line\nSecond line")
```

Output:
```
First line
Second line
```

---

## 💬 String Templates vs Concatenation

Avoid writing:

```kotlin
println("Hello, " + name + ". You are " + age + " years old.")
```

Instead, prefer:

```kotlin
println("Hello, $name. You are $age years old.")
```

It’s more readable, less error-prone, and idiomatic in Kotlin.

---

## 🤔 Reflect and Explore

- Why does Kotlin prefer immutability for strings?
- What would happen if strings were mutable?
- How do string templates make your code safer and more readable?

---

## 🎓 Summary

- `println()` adds a newline; `print()` does not
- String interpolation lets you embed values and expressions inside strings
- Kotlin compiles string templates into efficient `StringBuilder` operations
- Strings are immutable — any "modification" creates a new string
- Multiline strings, formatting, and escape characters give full control over output

---

## ✅ What’s Next

Try modifying some print statements:
- Use variables and expressions in output
- Practice formatting text using `\n`, `\t`, and `trimIndent()`
- Use string templates in your own functions

📦 Continue with examples in `examples/printExample`  
✍️ Solve the task in `exercises/printTask`

Let's keep going — **next up: Comments!**
