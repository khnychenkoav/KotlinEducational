<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/MainFunction.png">
    <img alt="Lambda" src="../../../../../../../images/MainFunction.png">
  </picture>
</div>

# 🔥 Lambdas in Kotlin

Lambdas are anonymous functions that can be passed around as values. They are enclosed in curly braces:

```kotlin
val upper = { s: String -> s.uppercase() }
println(upper("kotlin"))
```

Functions that take other functions as parameters are called **higher-order functions**. Kotlin’s standard library uses them extensively — for example, `list.filter { it > 0 }`.

<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/EndingLow.png">
    <img alt="End" src="../../../../../../../images/EndingLow.png">
  </picture>
</div>
