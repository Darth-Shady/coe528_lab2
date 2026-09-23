# Lab 2 — Procedural Abstraction

A small Java lab covering two standalone, side-effect-free methods: `reverseFactorial` and `isMatrixNice`.

## Package

```
lab2
```

## Methods

### `reverseFactorial(int x)`

**Effects:** Returns the smallest positive integer `n` such that `n! ≥ x`, for a positive integer `x`. Returns `1` for any `x ≤ 0`.

**Approach:** Starting from `1!`, the running factorial product is multiplied by successive integers until it meets or exceeds `x`. The number of multiplications performed is tracked and returned as `n`.

**Examples:**

| Input | Output | Why |
|---|---|---|
| `24` | `4` | `4! = 24 ≥ 24` |
| `119` | `5` | `4! = 24 < 119`, `5! = 120 ≥ 119` |
| `-3` | `1` | non-positive input, defaults to `1` |

### `isMatrixNice(int[][] arr)`

**Effects:** Checks whether a matrix has the "Nice" property. A matrix is Nice if:
1. It is square (every row has the same length as the number of rows).
2. Every row sum, every column sum, and both diagonal sums are equal.

If the matrix is Nice, the common sum is printed and the method returns `true`. Otherwise it returns `false` (including when the matrix is `null`, empty, or not square).

**Approach:**
1. Validate the matrix isn't `null`/empty and that every row's length matches the column count.
2. Compute a reference sum from the first row (`key_sum`).
3. Check every row sum, then every column sum, then the forward diagonal, then the backward diagonal against `key_sum`, returning `false` on the first mismatch.
4. If all checks pass, print `key_sum` and return `true`.

## Running

The `main` method runs a few sample cases for both methods:

```
javac lab2/ProceduralAbstraction.java
java lab2.ProceduralAbstraction
```

**Expected output:**
```
4
5
1
the key sum is:   15
true
false
```

## Notes / Known Limitations

- `isMatrixNice` assumes a square matrix (`rows == columns`) for the diagonal checks; a rectangular but "row-length-consistent" matrix would fail the squareness check as intended.
- Row/column sum accumulators (`row_sum`, `col_sum`, `fwd_diag_sum`, `bkd_diag_sum`) are reused across iterations and reset manually — worth double-checking if the matrix size changes between calls in a test harness.
