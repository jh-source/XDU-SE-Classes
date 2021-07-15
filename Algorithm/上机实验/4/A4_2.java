import java.util.Arrays;

public class A4_2 {
    private static int[] nums = new int[8];
    private static int count=0;

    public static void QUEEN(int k) {
        if(k==8) {
            count++;
            System.out.println(count+":" + Arrays.toString(nums));
            return;
        }else {
            for(int i=0;i<8;i++) {
                nums[k]=i;
                if(check(k)) {
                    QUEEN(k+1);
                }
            }
        }
    }

    public static boolean check(int k) {
        for(int j=0;j<k;j++) {
            if((Math.abs(k - j)) == (Math.abs(nums[j]-nums[k])) || (nums[j] == nums[k]) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        QUEEN(0);
        System.out.println("共有"+count+"种解决方案");
    }

}

