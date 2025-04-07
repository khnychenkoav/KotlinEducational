# 📦 Examples: Expressions in Kotlin

This folder showcases how Kotlin treats **many control structures as expressions**, allowing you to write more expressive and concise code.

---

## 🧪 What’s Inside

| File             | What it shows                                                |
|------------------|--------------------------------------------------------------|
| `IfExpression.kt`    | `if` as an expression returning a value                    |
| `WhenExpression.kt`  | Pattern matching using `when`, both with and without argument |
| `TryExpression.kt`   | `try` as an expression that returns a value or fallback     |

---

## 🧠 Why It Matters

In Kotlin, constructs like `if`, `when`, and `try` can be used not just to control flow — but to **return values** directly.

This enables:
- ✅ Cleaner code (no need to declare temp variables separately)
- ✅ Functional composition
- ✅ Fewer bugs related to branching logic

---

## 💡 Try This!

- ✍️ Rewrite a function with `if`/`when` that **returns** directly from the expression.
- 🧪 Use a `try` expression to safely parse user input and provide a default value.
- 🔄 Nest an `if` or `when` expression inside another expression (e.g., inside a return or assignment).

Example:

```kotlin
fun feedback(score: Int): String =
    if (score >= 90) "Excellent"
    else if (score >= 70) "Good"
    else "Needs improvement"
```

---

## 📚 Learn More

- See theory in: [`notes/Expressions.md`](../../notes/Expressions.md)
- Try tasks in: [`exercises/expressions`](../../exercises/expressions)

Keep going — you're writing **idiomatic Kotlin** now ✨
