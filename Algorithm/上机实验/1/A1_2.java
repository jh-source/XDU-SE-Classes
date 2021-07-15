import java.util.Arrays;

public class A1_2{

    private final Integer[] queue;
    private int N;

    @SuppressWarnings("unchecked")
    public A1_2(int capacity) {
        queue = new Integer[capacity+1];
    }


    public void Insert(int t) {
        queue[++N] = t;
        swim(N);
        System.out.println("优先队列插入"+t+"后为"+Arrays.toString(queue));
    }

    public int Extract_MAX() {
        int max = queue[1];
        System.out.println("已取出优先队列最大值"+max);
        swap(1, N);
        queue[N] = null;
        N = N - 1;
        sink(1);
        return max;
    }

    public int Maximum(){
        System.out.println("此时优先队列最大值为："+queue[1]);
        return queue[1];
    }

    public void Increase_key(int key,int x){
        int p=0;
        for (int i=1; i<N; i++){
            if (queue[i] == x);
            p = i;
        }
        System.out.println("将"+x+"增加"+key);
        queue[p] = queue[p] + key;
        while (p>1 && queue[p/2]<queue[p]){
            swap(p,p/2);
            p = p/2;
        }

    }

    public int size() {
        return N;
    }

    public void sink(int k) {
       while(2*k <= N){
           int j = 2 * k;
           if(j<N && queue[j]<queue[j+1]){
               j++;
           }
           if (queue[k] >= queue[j]){
               break;
           }
           else
               swap(k,j);
           k = j;
       }
    }

    public void swim(int k) {
        while (k>1 && queue[k]>queue[k/2]){
            swap(k,k/2);
            k = k / 2;
        }
    }

    public void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }



    public static void main(String[] args) {
        A1_2 queue = new A1_2(5);
        int[] nums = new int[]{9,5,1,8,10};
        for(int i=0; i<nums.length; i++){
            queue.Insert(nums[i]);
            queue.Maximum();
        }
        queue.Increase_key(100,5);
        queue.Maximum();
        for (int i=0; i<nums.length; i++){
            queue.Extract_MAX();
        }



    }
}





