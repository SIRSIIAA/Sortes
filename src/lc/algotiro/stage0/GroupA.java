package lc.algotiro.stage0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/*
 * Stage0 GroupA
 */
public class GroupA {
    /*
     * leetcode 1
     * Time: O(n^2)
     * Space: O(n^2)
     * Tier3 solution
     */
    public int[] twoSum(int[] nums, int target) {
        // satelles
        int[] ret = new int[]{};
        if (nums == null || nums.length == 0) {
            return ret;
        }
        // rex
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    ret = new int[]{i, j};
                }
            }
        }
        return ret;
    }

    /*
     * leetcode 1
     * Time: O(n logn)
     * Space: O(n)
     * Tier2 solution
     * double pointer;
     */
    public int[] twoSum0(int[] nums, int target) {
        // satelles
        int[] ret = new int[]{};
        if (nums == null || nums.length == 0) {
            return ret;
        }

        // comes
        int[] ints = new int[nums.length]; // Space: O(n)
        System.arraycopy(nums, 0, ints, 0, nums.length);
        Arrays.sort(ints); // Space: O(n logn)

        var map = new HashMap<Integer, ArrayList<Integer>>();
        IntStream.range(0, nums.length).forEach(it -> {
            var key = nums[it];
            if (map.containsKey(key)) {
                var arr = map.get(key);
                arr.add(it);
            } else {
                var idxList = new ArrayList<Integer>();
                idxList.add(it);
                map.put(key, idxList);
            }
        });

        // rex
        int l = 0;
        int r = ints.length - 1;
        while (l < r) {
            int sum = ints[l] + ints[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                int vL = ints[l];
                int vR = ints[r];
                if (vL == vR) {
                    // comes
                    var idx = map.get(vL);
                    ret = new int[]{idx.get(0), idx.get(1)};
                } else {
                    // comes
                    var lIdx = map.get(vL);
                    var rIdx = map.get(vR);
                    // return instantly
                    return new int[]{lIdx.get(0), rIdx.get(0)};
                }
                break;
            }
        }
        return ret;
    }

    /*
     * leetcode 1
     * Time: O(n)
     * Space: O(n)
     * Tier1 solution
     * Hash; Linear Scan;
     */
    public int[] twoSum1(int[] nums, int target) {
        // satelles
        if (nums == null || nums.length == 0) {
            // Illegal arguments
            return new int[]{};
        }
        // rex
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int pair = target - num;
            if (!map.containsKey(pair)) {
                map.put(num, i);
            } else {
                return new int[]{map.get(pair), i};
            }
        }
        return new int[]{};
    }

    /*
     * leetcode 88
     * Time: O(n)
     * Space: O(n)
     * Tier2 solution
     * double pointer
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // satelles
        if (nums1 == null || nums2 == null || nums1.length < nums2.length
                || nums1.length != m + n || nums2.length != n) {
            throw new IllegalArgumentException("Illegal Input");
        }
        if (nums1.length == 0) {
            return;
        }
        // empty nums2 is allowed

        // rex
        int p1 = 0;
        int p2 = 0;
        int pr = 0;
        var ret = new int[m + n];
        while (p2 < n && p1 < m) {
            if (nums1[p1] <= nums2[p2]) {
                ret[pr++] = nums1[p1++];
            } else {
                ret[pr++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            ret[pr++] = nums1[p1++];
        }
        while (p2 < n) {
            ret[pr++] = nums2[p2++];
        }
        // comes
        System.arraycopy(ret, 0, nums1, 0, m + n);
    }

    /*
     * leetcode 88
     * Time: O(n)
     * Space: O(1)
     * Tier1 solution
     * double pointer
     */
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        // satelles
        if (nums1 == null || nums2 == null || nums1.length != m + n || nums2.length != n) {
            // illegal arguments
            return;
        }
        // rex
        int nR = nums2.length - 1;
        int mR = m - 1;
        int p = nums1.length - 1;
        while (nR >= 0 && mR >= 0) {
            if (nums1[mR] >= nums2[nR]) {
                nums1[p--] = nums1[mR--];
            } else {
                nums1[p--] = nums2[nR--];
            }
        }
        while (nR >= 0) {
            nums1[p--] = nums2[nR--];
        }
    }

    /*
     * leetcode 283
     * Time: O(n)
     * Space: O(1)
     * Tier1 solution
     * double pointer
     */
    public void moveZeroes(int[] nums) {
        // satelles
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Illegal Arguments");
        }
        // rex
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[r++] = nums[i];
            }
        }
        // comes
        Arrays.fill(nums, r, nums.length, 0);
    }
}
