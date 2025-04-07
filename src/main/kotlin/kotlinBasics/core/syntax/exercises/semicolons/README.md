# ✍️ Exercise: Semicolon Cleanup

## 🎯 Task

You’re given a Kotlin program with unnecessary and misleading semicolons.

### Your goals:
- ✅ Remove **all redundant semicolons**
- ✅ Fix the logic bug caused by semicolon after `if`
- ✅ Format the code idiomatically

---

## 💡 Why It Matters

Semicolons can introduce subtle bugs — especially when transitioning from Java.

Writing clean, idiomatic Kotlin means **letting the compiler infer statement boundaries** without noise.

---

## 🤔 Bonus Challenge

Try writing your own example where a semicolon *breaks* control flow — and explain why.

---

## ✅ Success Criteria

- Program compiles with no semicolons
- `println()` executes **only if** version > 1.0
