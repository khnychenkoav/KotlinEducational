<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/MainFunction.png">
    <img alt="Functions" src="../../../../../../../images/MainFunction.png">
  </picture>
</div>

# 📝 Function Basics

Functions are declared with the `fun` keyword. They can take parameters and optionally return a value.

```kotlin
fun greet(name: String): String {
    return "Hello, $name!"
}
```

You can also omit the explicit return type when it can be inferred:

```kotlin
fun add(a: Int, b: Int) = a + b
```

Functions help you structure code into reusable blocks. Kotlin encourages **small, single-purpose functions** for readability and testing.

---

## ✅ Key Points

- Use `fun` to declare a function
- Parameters follow the syntax `name: Type`
- Use `=` for expression bodies when the function is a single expression

<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/EndingLow.png">
    <img alt="End" src="../../../../../../../images/EndingLow.png">
  </picture>
</div>
