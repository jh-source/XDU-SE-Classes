import java.util.Arrays;

public class A1_1 {
    public boolean twoSum(int[] S, int x){
        int[] tmp = new int[S.length];
        System.out.println("数组排序前："+Arrays.toString(S));
        merge_sort(S,tmp,0,S.length-1);
        System.out.println("数组排序后："+Arrays.toString(S));
        for(int i=0; i<S.length-1; i++){
            if(binary_search(S,x,i+1,S.length-1)){
                System.out.println("数组S中是否存在两元素之和为"+x+": exist");
                return true;
            }
        }
        System.out.println("数组S中是否存在两元素之和为"+x+": no exist");
        return false;
    }

    public void merge_sort(int[] S, int[] tmp, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            merge_sort(S,tmp,left,mid);
            merge_sort(S,tmp,mid+1,right);
            merge(S,tmp,left,mid+1,right);
        }
    }

    public void merge(int[] S, int[] tmp, int l, int m, int r){
        int leftend = m - 1;
        int index = l;
        int nums = r - l + 1;
        while(l<=leftend && m<= r){
            if(S[l]<=S[m]){
                tmp[index++] = S[l++];
            }else{
                tmp[index++] = S[m++];
            }
        }
        while(l <= leftend){
            tmp[index++] = S[l++];
        }
        while(m <= r){
            tmp[index++] = S[m++];
        }
        for(int i=0; i<nums; i++,r--){
            S[r] = tmp[r];
        }
    }

    public boolean binary_search(int[] S, int target, int left, int right){
        while(left <= right){
            int mid = (left + right)  / 2;
            if(S[mid] == target){
                return true;
            }else if(S[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{9,8,7,6,5,4,3,2,1};
        int[] nums2 = new int[]{99,11,22,88,33,77,55,66,100};
        int x1 = 8;
        int x2 = 97;
        (new A1_1()).twoSum(nums1,x1);
        (new A1_1()).twoSum(nums2,x2);




    }
}
