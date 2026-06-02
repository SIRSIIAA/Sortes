package magisterzuo.disciplina;

/*
 * Kata:
 * - heap insert, max heap
 * - heapify, max heap
 * - heap sort, top-down heap construction heapsort
 * - heap sort, down-top heap construction heapsort
 */
public class Disciplina25 {
    // heap insert
    // Time: O(n log n)
    // Space: O(1)
    public static void hi(int[] arr, int i) {
//        while (arr[i] > arr[(i - 1) >> 1] && i > 0) { // incorrect bitwise operation
//        while (i > 0 && arr[i] > arr[(i - 1) >> 1]) { // correct bitwise operation, -1 >> 1 != -1 / 2; -1 >> 1 -> -1, while -1 / 2 = 0
        while (arr[i] > arr[(i - 1) / 2]) { //  bitwise differs from integer division
            var pre = (i - 1) / 2; // same reason as above
            si(arr, i, pre);
            i = pre;
        }
    }

    // heapify
    public static void hfy(int[] arr, int i, int size) {
        var l = (i << 1) + 1;
        while (l < size) {
            var r = l + 1;
            var er = r < size && arr[r] > arr[l] ? r : l;
            var est = arr[i] >= arr[er] ? i : er;
            if (est == i) {
                break;
            }
            si(arr, i, est);
            i = est;
            l = (i << 1) + 1;
        }
    }

    // swap int
    private static void si(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    // heap sort, top-down
    public static void hp1(int[] arr) {
        // satelles
        if (arr == null || arr.length <= 1) {
            return;
        }
        // comes
        var size = 0;
        // rex
        // Time: O(n log n)
        for (int i = 0; i < arr.length; i++) {
            hi(arr, i); // log1 + log2 + ... + log n < n log n
            size++;
        }
        // Time: O(n log n)
        while (size > 1) {
            si(arr, 0, --size);
            hfy(arr, 0, size); // log n + log n-1 + log n-2 + ... + log1 < n log n
        }
    }

    // heap sort, down-top
    public static void hp2(int[] arr) {
        // satelles
        if (arr == null || arr.length <= 1) {
            return;
        }
        // comes
        var size = arr.length;
        // rex
        // Time: O(n)
//        for (int i = size - 1; i > -1; i--) {
        for (int i = (size - 2) / 2; i > -1; i--) { // Optimize the starting index of the loop to the last non-leaf node.
            hfy(arr, i, size);
        }
        // Time: O(n log n)
        while (size > 1) {
            si(arr, 0, --size);
            hfy(arr, 0, size);
        }
    }
}