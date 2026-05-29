# Interview Prep Progress

## Summary
_No data yet. Complete a few problems to start seeing patterns._

---

## Session Log

## Daily Temperatures (LeetCode 739) — 2026-05-30
- **Outcome:** Solved with hints
- **Time:** ~30 min
- **What went well:** Once pointed to a stack, independently derived the push/pop logic, the store-indices decision, and the `current - popped` distance formula. Strong debugging — traced own code and fixed every bug when directed to the right spot. Nailed the follow-up (previous-warmer-day) by recognizing the fix is reversing traversal direction, not just flipping the comparison, and adjusted the distance formula correctly.
- **Mistakes / Weak spots:**
  - Could not reach the monotonic-stack pattern independently; asked for hints early and needed to be walked to "stack" on a medium problem.
  - Pushed value instead of index on the push line (inconsistent with the empty-stack branch).
  - Cleanup loop counted down from the array end instead of popping actual leftover indices — silently clobbered a correct answer; only surfaced via the `[5,3,4]` test trace.
  - Did not initially know Java zero-initializes `int[]`, so wrote a redundant final loop.
- **Pattern tags:** wrong data structure (slow pattern recognition — monotonic stack), index vs. value confusion, off-by-one / wrong-index in cleanup loop, didn't test before declaring done
