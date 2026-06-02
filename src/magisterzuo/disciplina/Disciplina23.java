package magisterzuo.disciplina;

/*
 * Kata:
 * - random quick sort, lomuto partition
 * - random quick sort, 3-way partition
 * - swap int
 */
public class Disciplina23 {
    // random quick sort with 3-way partition
    public static void rqs_3wp(int[] arr) {
        // satelles
        if (arr == null || arr.length <= 1) {
            return;
        }
        // rex
        qs_3wp(arr, 0, arr.length - 1);
    }

    // quick sort, 3-way partition
    private static void qs_3wp(int[] arr, int l, int r) {
        // satelles
        if (l >= r) {
            return;
        }
        // rex
        var bs = triwp(arr, l, r);
        qs_3wp(arr, l, bs[0] - 1);
        qs_3wp(arr, bs[1] + 1, r);
    }

    // 3-way partition
    private static int[] triwp(int[] arr, int l, int r) {
        // comes
        var lb = l;
        var rb = r;
        var p = l;
        var seed = arr[l + (int) (Math.random() * (r - l + 1))];
        // rex
        while (p <= rb) {
            if (arr[p] == seed) {
                p++;
            } else if (arr[p] < seed) {
                si(arr, p++, lb++);
            } else {
                si(arr, p, rb--);
            }
        }
        return new int[]{lb, rb};
    }

    // lomuto partition
    private static int lp(int[] arr, int l, int r) {
        return -1;
    }


    // swap int
    private static void si(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
        // the code below may have a better performance on a modern CPU, which is counterintuitive
        // int t = arr[i]
        // ...
    }
}
