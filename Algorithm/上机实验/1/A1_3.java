import java.util.Arrays;
import java.util.Random;

public class A1_3 {
    private static Random random = new Random(System.currentTimeMillis());
    public static int cnt = 0;
    public void quicksort(int[] nums, int left, int right){
        if(left>right)    return;
        if(right>left){
            int randomindex = random.nextInt(right-left)+left+1;
            swap(nums,left,randomindex);
        }
        int pivot = nums[left];
        int j = left;

        for(int i=left+1; i<=right; i++){
            if(nums[i]<pivot){
                j++;
                swap(nums,i,j);
            }
            cnt++;

        }
        swap(nums,left,j);

        quicksort(nums,left,j-1);
        quicksort(nums,j+1,right);
    }

    public void swap(int[] nums, int left, int right){
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,1,1,1,1,1,1};
        int[] nums2 = new int[]{9,8,7,6,5,4,3,2,1};
        int[] nums3 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] nums4 = new int[]{5,1,9,3,7,4,8,6,2};
        int[] nums5 = new int[]{1,11,2,31,0,100,19,91,30};





        System.out.println("排序前数组为："+Arrays.toString(nums1));
        (new A1_3()).quicksort(nums1,0, nums1.length-1);
        System.out.println("排序后数组为："+Arrays.toString(nums1));
        System.out.println("比较次数为： "+cnt);

        cnt = 0;
        System.out.println("排序前数组为："+Arrays.toString(nums2));
        (new A1_3()).quicksort(nums2,0, nums2.length-1);
        System.out.println("排序后数组为："+Arrays.toString(nums2));
        System.out.println("比较次数为： "+cnt);

        cnt = 0;
        System.out.println("排序前数组为："+Arrays.toString(nums3));
        (new A1_3()).quicksort(nums3,0, nums3.length-1);
        System.out.println("排序后数组为："+Arrays.toString(nums3));
        System.out.println("比较次数为： "+cnt);

        cnt = 0;
        System.out.println("排序前数组为："+Arrays.toString(nums4));
        (new A1_3()).quicksort(nums4,0, nums4.length-1);
        System.out.println("排序后数组为："+Arrays.toString(nums4));
        System.out.println("比较次数为： "+cnt);

        cnt = 0;
        System.out.println("排序前数组为："+Arrays.toString(nums5));
        (new A1_3()).quicksort(nums4,0, nums4.length-1);
        System.out.println("排序后数组为："+Arrays.toString(nums5));
        System.out.println("比较次数为： "+cnt);
    }

}
