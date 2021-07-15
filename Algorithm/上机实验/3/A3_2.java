public class A3_2 {
    public static void Scheudle(int[] s) {
        for (int i=0; i<s.length - 1; i++){
            for (int j=0; j<s.length - 1; j++){
                if (s[j] > s[j+1]){
                    int tmp = s[j];
                    s[j]    = s[j+1];
                    s[j+1]  = tmp;
                }
            }
        }

        int c=0;
        int sum = 0;
        for(int i=0;i<s.length;i++) {
            System.out.print(s[i]+" ");
            c       = c + s[i];
            sum     = c + sum;
        }
        double avg=((double)sum)/((double)s.length);
        System.out.println("最小平均完成时间为："+avg);

    }

    public static void main(String[] args) {
        int[] arrays= {15,8,3,10};
        System.out.print("进程运行顺序为：");
        Scheudle(arrays);
    }

}
