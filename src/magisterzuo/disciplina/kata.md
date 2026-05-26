# KataList

## global binary search, find lower bound

Find the smallest (leftmost) index where the element is greater than or equal to the target value t. Uses an auxiliary
variable to decouple the logic of "recording a feasible solution" and "shrinking the search interval", avoiding complex
boundary checks on pointer states after the loop ends.

```java
public static int gbs_lower(int[] arr, int t) {
    return -1;
}

```

## global binary search, find upper bound

Find the largest (rightmost) index where the element is less than or equal to the target value t. This mirrors the logic
for finding the left bound, also utilizing an auxiliary variable to manage the control flow of "recording a valid
solution" and "approaching from the right".

```java
public static int gbs_upper(int[] arr, int t) {
    return -1;
}

```

## global binary search, find peak value

Find the index of any peak (local maximum) in an unsorted "mountain" array. Determines the search direction by comparing
the local trend (slope) between the midpoint and its adjacent elements, climbing towards higher ground as boundaries are
compressed.

```java
public static int findPeak(int[] arr) {
    return -1;
}

```

## recursive merge sort

Classic top-down divide-and-conquer merge sort. Recursively splits the interval into halves, and during backtracking,
merges the sorted halves using a pre-initialized auxiliary array for a single-pass scan, then writes the result back to
the original array.

```java
public static void ms(int[] arr) {
}

```

## iterative merge sort

Bottom-up non‑recursive merge sort. Uses an iteratively doubling step size to replace the recursive call stack.
Incorporates midpoint overflow protection and a "reservoir ruler zeroing" mechanism to improve cache‑friendliness.

```java
public static void ms_iter(int[] arr) {
}

```

## small sum problem

Small Sum problem. Uses the merge‑sort divide‑and‑conquer approach: while merging two sorted sub‑arrays, performs a
single‑pass linear scan to count how many elements in the right sub‑array are greater than the current left element,
thereby calculating and accumulating the contribution of the left element to cross‑interval "small sums".

```java
public static int smallSum(int[] arr) {
    return 0;
}

```

## random quick sort, lomuto partition

Randomized Quick Sort (one‑way Lomuto partition). Pre‑swaps a randomly chosen pivot to the end of the interval to anchor
it, then uses fast‑and‑slow pointers (a scout and a boundary guard) sliding in the same direction within the loop to
restructure the partition.

```java
public static void rqs_lomuto(int[] arr) {
}

```

## random quick sort, 3-way partition

Randomized Quick Sort (three‑way partition / Dutch National Flag model). Employs three pointers to simultaneously
maintain boundaries for the less‑than, equal‑to, and greater‑than regions. This places all elements equal to the pivot
into their final positions within the current recursion level, optimizing time complexity to O(N) for arrays with many
duplicates.

```java
public static void rqs_3way(int[] arr) {
}

```

## iterative preorder traversal

Non‑recursive preorder traversal of a binary tree. Uses a stack’s LIFO property to simulate the system call stack. At
each node, immediately "visits" it, then pushes the right child followed by the left child to explore depth‑first in the
correct order.

```java
public static void preorder(TreeNode head) {
}

```

## iterative inorder traversal

Non‑recursive inorder traversal of a binary tree. Introduces a dual‑state control flow: persistently pushes the current
node onto the stack while moving left (as a future waypoint), triggers a backtrack when head == null, then pops the
waypoint, visits it, and turns to the right subtree.

```java
public static void inorder(TreeNode head) {
}

```

## iterative postorder traversal, double stack

Non‑recursive postorder traversal using two stacks. The first stack records nodes in a "root‑right‑left" mirrored order;
when popped, they are pushed onto the second stack. Finally, popping from the second stack restores the physical "
left‑right‑root" visitation order.

```java
public static void postorder_double(TreeNode head) {
}

```

## iterative postorder traversal, single stack

Non‑recursive postorder traversal using a single stack. Introduces an auxiliary pointer that acts as a "footprint
phosphor" to track the last node that was popped and processed. This cleanly decouples the three deterministic
state‑machine phases: "initial descent / prioritize left", "return from left / turn to right", and "no way forward /
visit current node".

```java
public static void postorder_single(TreeNode head) {
}

```