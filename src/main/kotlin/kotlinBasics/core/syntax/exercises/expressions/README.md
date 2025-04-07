# ✍️ Exercise: Expressions in Kotlin

## 🎯 Your Mission

Practice Kotlin’s expression-based approach by writing functions that use:
- `if` or `when` to return values
- `try` for parsing user input

### Your tasks:

1. **evaluateGrade(score: Int) → String**  
   Use `if` or `when` as an expression:
    - Score >= 90 → "A"
    - Score >= 80 → "B"
    - Score >= 70 → "C"
    - Otherwise → "F"

2. **main()**
    - Hardcode or read an integer
    - Print the grade by calling `evaluateGrade()`

3. **(Bonus)** `readIntOrNull()`
    - Use a `try` expression to parse input
    - Return `null` if parsing fails

4. **(Bonus)** If `readIntOrNull()` returns `null`, print a helpful error message.

---

## 🧠 Why It Matters

Mastering expressions in Kotlin:
- Allows shorter, more functional code
- Replaces legacy switch/ternary statements from other languages
- Encourages you to think in terms of "return a value" vs. "just do something"

---

## 💡 Tips

- `when (score) { ... }` or `if (score >= ...) ... else ...`
- Last expression in each branch is the branch’s result
- `try` can yield success or fallback value

---

Once you're done, run and test with different scores or inputs to ensure correctness.
