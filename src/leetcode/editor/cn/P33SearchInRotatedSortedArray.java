//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

public class P33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找，重点在于确定target属于哪个区间
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                //[0,mid]有序，target在右侧
                if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                    left = mid + 1;
                } else if (target > nums[mid] && target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return (left == right && nums[left] == target) ? left : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

