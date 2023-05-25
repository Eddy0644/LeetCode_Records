import java.util.Arrays;

public class wiggleSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 1, 2, 3};
        Solution.wiggleSort(a);
        System.out.println(Arrays.toString(a));
        System.out.print("Run successful.");
    }
}

class Solution {
    public static void wiggleSort(int[] nums) {
        /*
        * 从局部谷-峰-谷 到 全局谷-峰-谷
简单来说即先确认数组的形式：
峰-谷-峰
谷-峰-谷
本例采用后者。
现有数组[3,5,2,1,6,4]：
先维护一个局部谷-峰-谷，初始为[3]，接着从左往右遍历数据，将新元素加入局部谷-峰-谷的最右侧。
将5加入局部谷-峰-谷，得到[3 < 5]，无需调整。
将2加入局部谷-峰-谷，得到[3 < 5 > 2]，无需调整。
将1加入局部谷-峰-谷，得到[3 < 5 > 2 > 1]，此时存在5 > 2 > 1，需要调整。
已知1的位置应当是峰，但出现了2 > 1；
又已知加入新元素前的子数组[3 < 5 > 2]是局部谷-峰-谷，即5 > 2是隐含条件。
既然5 > 2成立，5 > 1也必然成立；同时2 > 1，因此将5 > 2 > 1变成5 > 1 < 2即可。
调整完毕后的局部谷-峰-谷为[3 < 5 > 1 < 2]。
将6加入局部谷-峰-谷，得到[3 < 5 > 1 < 2 < 6]，此时存在1 < 2 < 6，需要调整。
已知6的位置应当是谷，但出现了2 < 6；
又已知加入新元素前的子数组[3 < 5 > 1 < 2]是局部谷-峰-谷，即1 < 2是隐含条件。
既然1 < 2成立，1 < 6也必然成立；同时6 > 2，因此将1 < 2 < 6变成1 < 6 > 2即可。
调整完毕后的局部谷-峰-谷为[3 < 5 > 1 < 6 > 2]。
将4加入局部谷-峰-谷，得到[3 < 5 > 1 < 6 > 2 < 4]，无需调整。
总结：当出现问题时，要么是出现了a < b < c，要么是出现了a > b > c。
最终只要调整为a < c > b或a > c < b即可。
讲的比较啰嗦，见谅。
思想可以类比排序，从局部有序到最终的全局有序。
作者：gfu
链接：https://leetcode.cn/problems/peaks-and-valleys-lcci/solution/bi-jiao-zhi-guan-de-xiang-fa-xian-pai-xu-by-gfu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
        int n=nums.length;
        for (int i = 1; i < n; i++) {
            if(((i&1)==1)?(nums[i]<nums[i-1]):(nums[i]>nums[i-1])){
                nums[i]^=nums[i-1];
                nums[i-1]^=nums[i];
                nums[i]^=nums[i-1];
            }
        }
    }
    public static void wiggleSort_sec1(int[] nums) {
        int idx = 0, len = nums.length;
        if (len < 3) return;
        int low = 0, high = len - 1;
        int[] sorted = Arrays.copyOf(nums, len);
        Arrays.sort(sorted);
        while (low < high) {
            nums[idx++] = sorted[high--];
            nums[idx++] = sorted[low++];
        }
        if (len % 2 > 0)
            nums[idx] = sorted[low];
    }
}