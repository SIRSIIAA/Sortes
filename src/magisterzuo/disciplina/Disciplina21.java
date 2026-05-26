package magisterzuo.disciplina;

// merge sort
public class Disciplina21 {
    private static int[] comes;

    public static void msrs(int[] arr) {
        // satelles princeps
        if (arr == null || arr.length <= 1) {
            return;
        }
        comes = new int[arr.length];
        msr(arr, 0, arr.length - 1);
    }

    // merge sort recursion
    public static void msr(int[] arr, int l, int r) {
        // satelles
        // base case
        if (l == r) {
            return;
        }
        // comes
        var mid = l + ((r - l) >> 1);
        // rex
        msr(arr, l, mid);
        msr(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // merge sort iterative
    public static void msi(int[] arr) {

    }

    // merge
    private static void merge(int[] arr, int l, int mid, int r) {
        // comes
        var len = r - l + 1;
        var pl = l;
        var pr = mid + 1;
        var p = l;
        // rex
        while (pl <= mid && pr <= r) {
            comes[p++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }
        while (pl <= mid) {
            comes[p++] = arr[pl++];
        }
        while (pr <= r) {
            comes[p++] = arr[pr++];
        }
        System.arraycopy(comes, l, arr, l, len);
    }
}
