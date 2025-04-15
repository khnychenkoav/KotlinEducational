# 🔁 Kotlin Loops: for, while, and do-while

Loops are fundamental constructs in programming that allow us to repeat actions multiple times. Instead of writing the same code again and again, we wrap it in a loop — letting the program handle repetition for us. Kotlin, like most modern languages, supports several types of loops: `for`, `while`, and `do..while`. Each serves a slightly different purpose but shares the same core goal: **execute a block of code repeatedly** under some condition.

Kotlin's approach to loops is clean and expressive, often providing safer and more concise alternatives to traditional Java-style syntax. In this chapter, we’ll explore how loops work in Kotlin, how they compare to other languages, and how to use them effectively and idiomatically.

---

## 🧠 What You Will Learn

- What loops are and why they’re used
- The difference between `for`, `while`, and `do..while`
- How to iterate over ranges, collections, and indices
- Idiomatic Kotlin features like `withIndex()`, `step`, `downTo`, and `repeat()`
- The internals of how Kotlin compiles loops
- Comparison with other languages
- Performance considerations and loop overhead
- Using non-Int ranges (e.g., Char, Long)
- How to define custom iterable types
- Common pitfalls and best practices

---

## 🔁 What is a `for` loop?

A `for` loop in Kotlin is typically used to iterate over a **known range or collection**. It's the go-to tool when you know how many times something should repeat, or when you're looping through items like a list of names or numbers.

### Basic syntax:
```kotlin
for (i in 1..5) {
    println(i)
}
```
✅ Prints numbers 1 to 5 (inclusive).

This is internally translated to an iterator over an `IntProgression`, similar to how `for i in range(1, 6)` works in Python.

### Exclusive range:
```kotlin
for (i in 1 until 5) {
    println(i)
}
```
✅ Prints 1 to 4 — `until` excludes the upper bound.

Under the hood, `until` is an infix function that creates an `IntRange` from the start to `end - 1`.

### Step and reverse:
```kotlin
for (i in 10 downTo 1 step 2) {
    println(i)
}
```
✅ Prints 10, 8, 6, ..., 2

The chaining of `downTo` and `step` creates a reversed and stepped `IntProgression`. Kotlin's compiler generates efficient bytecode for this.

### Iterate over a collection:
```kotlin
val names = listOf("Alice", "Bob", "Charlie")
for (name in names) {
    println("Hello, $name!")
}
```

The compiler translates this into an `Iterator` loop (like Java's enhanced `for-each`), calling `hasNext()` and `next()` under the hood.

### With index:
```kotlin
for ((index, name) in names.withIndex()) {
    println("$index: $name")
}
```
This is more idiomatic than manually tracking an index, and avoids errors.

---

## 🔄 What is a `while` and `do..while` loop?

These loops are **condition-controlled**. Use them when you don’t know in advance how many times the loop should run — instead, the loop continues as long as some condition remains true.

### `while` loop:
```kotlin
var x = 5
while (x > 0) {
    println(x)
    x--
}
```
✅ Runs while `x > 0`. As soon as the condition becomes false, it exits.

### `do..while` loop:
```kotlin
var input: String?
do {
    input = readLine()
    println("You entered: $input")
} while (input != "exit")
```
✅ The block runs at least once — even if the condition is initially false.

---

## 🔂 break and continue

```kotlin
for (i in 1..10) {
    if (i == 6) break    // exit loop
    if (i % 2 == 0) continue // skip even
    println(i)
}
```

Both keywords behave as expected, but Kotlin also allows **labeled breaks and continues**:

```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) continue@outer
        println("i=$i j=$j")
    }
}
```
➡️ This is a clean alternative to nested loop escape logic in Java or C++.

---

## 💡 Idiomatic Kotlin Tips

### Prefer `repeat()` for fixed repetitions:
```kotlin
repeat(3) {
    println("This prints 3 times")
}
```
This is cleaner than writing `for (i in 0..2)` when index isn’t needed.

### Prefer higher-order functions:
```kotlin
names.forEach { name ->
    println("Hi, $name")
}
```
Or:
```kotlin
names.filter { it.startsWith("A") }.forEach { println(it) }
```
This approach promotes **functional, expressive code** and avoids stateful iteration.

---

## 🚀 Performance Considerations

While Kotlin’s loops are designed to be both expressive and efficient, some idioms carry subtle performance implications:

- **Classic `for (i in 0 until n)`** compiles to an optimized indexed loop. It’s the fastest and best choice when performance and index access matter.
- **`forEach {}`** creates a lambda object under the hood. While negligible for most applications, in tight loops or performance-critical code, it may be slightly slower than a regular loop.
- **`withIndex()`** also introduces an intermediate `IndexedValue` object per iteration.

📌 **Tip:** Use idiomatic constructs for clarity, but benchmark if performance is critical.

---

## 🔣 Beyond Int: Other Ranges

Kotlin ranges aren’t just for integers:

### CharRange:
```kotlin
for (ch in 'a'..'f') {
    println(ch)
}
```
✅ Outputs: a b c d e f

### LongRange:
```kotlin
for (i in 1L..5L) {
    println(i)
}
```
✅ Supports long iteration, internally uses `LongProgression`

### UIntRange, ULongRange (experimental):
Unsigned ranges are available for special cases:
```kotlin
for (u in 1u..5u) {
    println(u)
}
```
Note: unsigned types have limited use in typical Android/JVM projects.

---

## 🛠️ Custom Iteration with `iterator()`

Kotlin’s `for` loop relies on calling `iterator()` on the object. You can define your own iterable types by implementing this function.

### Custom Iterable Example:
```kotlin
class Countdown(val start: Int) {
    operator fun iterator(): Iterator<Int> = object : Iterator<Int> {
        private var current = start
        override fun hasNext() = current >= 0
        override fun next() = current--
    }
}

for (i in Countdown(3)) {
    println(i)
}
```
✅ Outputs: 3, 2, 1, 0

This demonstrates how Kotlin’s loop syntax can be extended to any custom sequence-like behavior.

You can even build lazy iterators or stateful data streams this way.

---

## 🧬 Under the Hood

Kotlin loops are **compiled to standard JVM bytecode**:

- `for (i in 1..5)` → uses an `IntIterator`
- `for (item in list)` → compiles to `list.iterator()`
- `withIndex()` creates a wrapper over the collection to provide `IndexedValue`

Unlike Java, you don’t need to use verbose `Iterator` classes manually — the compiler handles this cleanly.

---

## ⚠️ Common Pitfalls

| Mistake | Why it’s wrong | Fix |
|--------|----------------|-----|
| Using `1..list.size` | Includes out-of-bounds index | Use `0 until list.size` or `indices` |
| Manual index tracking | Error-prone and verbose | Use `withIndex()` or higher-order functions |
| Forgetting `step` in reverse | Infinite loop risk | Always check bounds with `downTo`/`step` |
| Complex nested loops | Hard to manage exit | Use `labels` with `break@label` or refactor |

---

## 🤝 Comparison with Java

| Feature              | Java                            | Kotlin                          |
|----------------------|----------------------------------|----------------------------------|
| Basic for-loop       | `for (int i=0; i<10; i++)`       | `for (i in 0 until 10)`          |
| foreach loop         | `for (String s : list)`          | `for (s in list)`                |
| Indexed iteration    | `for (int i=0; i<list.size(); i++)` | `for ((i, v) in list.withIndex())` |
| Labeled break        | Not idiomatic                    | Built-in via `@label`           |
| `repeat()` loop      | Not available                    | ✅ Available                     |

---

## 🎓 Summary

- Loops let you repeat blocks of code efficiently
- Use `for` with ranges and collections
- Use `while` for condition-controlled logic
- Use `do..while` when the body must run at least once
- Add `step`, `downTo`, `until` to customize iteration
- Use `repeat()` for fixed counts
- Use `forEach`, `filter`, `map` to write expressive code
- Prefer `withIndex()` over manual index tracking
- Use labeled breaks for nested loops
- Understand custom iteration with `iterator()`
- Choose idiomatic vs. performant constructs wisely

---

## ✅ What’s Next

- Practice in `examples/loops`
- Try challenges in `exercises/loops`
- Reflect on: "Can I rewrite this `for` as a `map`, `filter`, or `repeat()`?"

Happy looping! 🚴‍♂️

