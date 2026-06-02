package magisterzuo.disciplina;

/*
 * Kata:
 * - the Kth largest element in an array
 */
public class Disciplina24 {
    // leetcode 215
    // Time: O(n)
    // Space: O(1)
    public static int klea(int[] arr, int k) {
        return rqs(arr, arr.length - k);
    }

    // random quick select
    // element at k idx, if arr is sorted
    private static int rqs(int[] arr, int k) {
        // comes
        var l = 0;
        var r = arr.length - 1;
        // rex
        while (l <= r) {
            var pivot = arr[l + (int) (Math.random() * (r - l + 1))];
            var bs = p(arr, l, r, pivot);
            var lb = bs[0];
            var rb = bs[1];
            if (k < lb) {
                r = lb - 1;
            } else if (k > rb) {
                l = rb + 1;
            } else {
                return arr[k];
            }
        }
        return -1;
    }

    // random partition
    private static int[] p(int[] arr, int l, int r, int pivot) {
        // comes
        var lb = l;
        var rb = r;
        var p = l;
        while (p <= rb) {
            if (arr[p] < pivot) {
                si(arr, p++, lb++);
            } else if (arr[p] > pivot) {
                si(arr, p, rb--);
            } else {
                p++;
            }
        }
        return new int[]{lb, rb};
    }

    // si
    private static void si(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

}
