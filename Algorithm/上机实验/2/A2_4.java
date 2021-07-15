import java.util.Arrays;

public class A2_4 {
    public int maxSum(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{-2,11,-4,13,-5,-2};
        System.out.println("序列为："+ Arrays.toString(arr));
        System.out.println("最大字序和为："+(new A2_4()).maxSum(arr));
    }
}
