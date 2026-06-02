package magisterzuo.disciplina;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Disciplina27 {
    /*
     * leetcode  2208
     * Time: O(n log n)
     * Space: O(n)
     * Tier2 solution
     */
    public int halveArray(int[] arr) {
        // satelles
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 1;
        }
        // comes
        var maxH = new PriorityQueue<Double>(Comparator.reverseOrder());
        double sum = 0;
        var times = 0;
        // rex
        for (int it : arr) {
            maxH.offer((double) it);
            sum += it;
        }
        var curSum = sum;
        sum /= 2;
        while (curSum > sum) {
            var c = maxH.poll();
            curSum -= c / 2;
            maxH.offer(c / 2);
            times++;
        }
        return times;
    }

    /*
     * leetcode  2208
     * Time: O(n + k log n)
     * Space: O(n)
     * Tier1 solution
     */
    public int halveArray2(int[] arr) {
        // satelles
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 1;
        }
        // comes
        var heap = new long[arr.length];
        var sum = 0L;
        var times = 0;
        // rex
        for (int i = 0; i < arr.length; i++) {
            var h = (long) arr[i] << 20;
            sum += h;
            heap[i] = h;
        }
        var size = heap.length;
        for (int i = (size - 2) / 2; i > -1; i--) {
            heapify(heap, i, size);
        }
        sum >>= 1;
        var minus = 0L;
        while (minus < sum) {
            heap[0] >>= 1;
            minus += heap[0];
            heapify(heap, 0, size);
            times++;
        }
        return times;
    }

    private static void heapify(long[] arr, int i, int size) {
        var l = (i << 1) + 1;
        while (l < size) {
            var r = l + 1;
            var er = r < size && arr[r] > arr[l] ? r : l;
            var est = arr[er] > arr[i] ? er : i;
            if (est == i) {
                break;
            }
            swap(arr, i, est);
            i = est;
            l = (est << 1) + 1;
        }
    }

    private static void swap(long[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }
}
