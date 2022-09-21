import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/9/6 14:56
 */
public class main001 {
    public static void main(String[] args) {
        sortArray(new int[]{1, 24, 0, 41, 23, 99});
    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static void quickSort(int[] nums, int low, int high) {
        int i = low, j = high;
        if (low < high) {
            int temp = nums[low];
            while (i < j && nums[j] >= temp) j--;
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] < temp) i++;
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }

            nums[i] = temp;
            quickSort(nums, low, i - 1);
            quickSort(nums, i + 1, high);
        }
    }
}
