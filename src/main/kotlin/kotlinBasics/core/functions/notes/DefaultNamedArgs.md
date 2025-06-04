<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/MainFunction.png">
    <img alt="Arguments" src="../../../../../../../images/MainFunction.png">
  </picture>
</div>

# 🧩 Default and Named Arguments

Kotlin lets you assign **default values** to parameters. You can also use **named arguments** when calling a function for clarity.

```kotlin
fun printMessage(msg: String, prefix: String = "Info") {
    println("[$prefix] $msg")
}

printMessage("Started")
printMessage("Failed", prefix = "Error")
```

Named arguments make calls self-documenting, especially when a function has multiple parameters of the same type.

<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="../../../../../../../images/EndingLow.png">
    <img alt="End" src="../../../../../../../images/EndingLow.png">
  </picture>
</div>
