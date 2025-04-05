<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/Comments.png">
    <img alt="Gradle Logo" src="../../../../../../../images/Comments.png">
  </picture>
</div>

# 💬 Writing Clear Code: Comments in Kotlin

Comments are an essential part of writing clean, maintainable, and collaborative code. They help **communicate your intent**, explain complex logic, and leave useful notes for yourself or others.

While Kotlin emphasizes **expressive and self-documenting code**, comments still play a vital role — especially in teams and real-world projects.

---

## 🧠 What You Will Learn

- The different types of comments in Kotlin
- How to write idiomatic and helpful comments
- When (and when not) to comment
- How comments behave during compilation
- Best practices from Kotlin style guides

---

## ✍️ Types of Comments in Kotlin

Kotlin supports three main types of comments:

### 1. 🧵 Single-line comments

```kotlin
// This is a single-line comment
val name = "Kotlin"
```

Starts with `//` and continues to the end of the line.  
Used for short notes, context, or disabling a single line.

---

### 2. 📜 Multi-line comments

```kotlin
/*
  This is a multi-line comment.
  It can span multiple lines.
*/
val version = "1.9"
```

Starts with `/*` and ends with `*/`.  
Use it to describe blocks of logic or provide summaries.

✅ Kotlin also supports **nested** multi-line comments — unlike Java:

```kotlin
/* Outer comment
    /* Inner comment */
    Still part of outer
*/
```

This is useful during debugging or when commenting out larger blocks of code.

---

### 3. 📘 KDoc comments (for documentation)

KDoc is Kotlin's official documentation format (inspired by Javadoc and Markdown).

```kotlin
/**
 * Greets a user with their name.
 *
 * @param name The user's name
 * @return Greeting message
 */
fun greet(name: String): String {
    return "Hello, $name!"
}
```

These comments appear in IDEs like IntelliJ and are used by tools like [Dokka](https://kotlinlang.org/docs/kotlin-doc.html) to generate API docs.

---

## 🛠 What Happens at Compile Time?

- Comments are **completely ignored** by the Kotlin compiler.
- They **do not** affect bytecode, performance, or output.
- Even nested block comments are **stripped** before parsing.

> Under the hood, the Kotlin lexer removes comments during the tokenization phase, so they never reach semantic analysis or code generation.

---

## 📦 Comments vs Code

A good rule of thumb:

> 💡 "Code should explain **what**. Comments should explain **why**."

Bad:
```kotlin
// Add 1 to count
count += 1
```

Better:
```kotlin
// Account for zero-based indexing
count += 1
```

Best:
- Make code so clear that the comment is optional:
```kotlin
val userIndex = position + 1 // shift to 1-based index for UI
```

---

## 🧼 Commenting Out Code

During testing or debugging, you might temporarily disable code using `//` or `/* */`:

```kotlin
// println("Debug info: $data")

/*
fetchData()
processData()
*/
```

But avoid **leaving commented-out code** in production — it's confusing and clutters the file.

---

## ✅ Best Practices

✔ Use comments to explain **intent, edge cases, or non-obvious reasons**  
✔ Prefer **self-documenting code** with good names and structure  
✔ Use **KDoc** for public APIs and libraries  
✔ Keep comments **up-to-date** with code  
✔ Avoid redundant or obvious comments

---

## ❌ Anti-patterns

| Pattern | Why it's bad |
|--------|---------------|
| `// increment i` | Too obvious |
| `// TODO remove this` (left for months) | Adds technical debt |
| `// Don't touch this` | Adds fear without explanation |
| Leaving commented-out code | Creates clutter |

---

## 🧠 Reflect and Discuss

- Can you write code so clear that it needs no comment?
- Have you ever read a misleading or outdated comment?
- What should you document: *what it does*, *how it works*, or *why it's there*?

---

## 🎓 Summary

- Kotlin supports `//`, `/* */`, and `/** */` for comments
- Comments are removed before compilation and do not impact runtime
- Use comments to explain **why**, not just what
- Write clean code first — comment where extra context is needed
- Adopt KDoc for structured documentation

---

## ✅ What’s Next

Try adding comments to a simple program:
- Use all three types
- Explain tricky logic
- Try KDoc on a function

🔍 Continue in:
- `examples/comments`
- `exercises/comments`

Let’s move on — your code is about to become cleaner and smarter!

<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/EndingLow.png">
    <img alt="Gradle Logo" src="../../../../../../../images/EndingLow.png">
  </picture>
</div>