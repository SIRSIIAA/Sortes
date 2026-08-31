package magisterzuo.disciplina;

import java.util.Arrays;

/*
 * Kata:
 * - radix sort, prefix based partition
 */
public class Disciplina28 {
    // radix sort
    // prefix based partition
    public static void rs(int[] arr, int BASE) {
        // satelles
        if (arr == null || arr.length <= 1) {
            return;
        }
        // comes
        var buckets = new int[BASE];
        // Space: O(n)
        var nums = new long[arr.length];
        var temp = new long[arr.length];
        var min = 0;
        var max = 0L;
        // Time: O(n)
        for (int it : arr) {
            min = Math.min(it, min);
        }
        // Time: O(n)
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                nums[i] = arr[i] - min;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                nums[i] = arr[i];
            }
        }
        for (long it : nums) {
            max = Math.max(it, max);
        }
        // rex
        var bits = getBits(max, BASE);
        // Time: O(d (n + b))
        for (int i = 0, offset = 1; i < bits; i++, offset *= BASE) {
            Arrays.fill(buckets, 0);
            for (long num : nums) {
                buckets[(int) ((num / offset) % BASE)]++;
            }
            for (int j = 1; j < buckets.length; j++) {
                buckets[j] += buckets[j - 1];
            }
            for (int j = nums.length - 1; j > -1; j--) {
                var idx = (int) ((nums[j] / offset) % BASE);
                temp[--buckets[idx]] = nums[j];
            }
            System.arraycopy(temp, 0, nums, 0, temp.length);
        }
        // comes
        if (min < 0) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] += min;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i] = (int) temp[i];
        }
    }

    private static int getBits(long i, int BASE) {
        var bits = 0;
        while (i > 0) {
            i /= BASE;
            bits++;
        }
        return bits;
    }
}