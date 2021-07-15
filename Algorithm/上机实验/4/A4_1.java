public class A4_1 {
    private static int cap=100;
    private static int cw = 0;
    private static int cv = 0;
    private static int bestValue;
    private static int[] Weight= {10,20,30,40,50};
    private static int[] Value= {20,30,65,40,60};
    private static int[] flag= {0,0,0,0,0};

    public static void main(String[] args) {
        mysort();
        BACKTRACK(0);
    }

    public static double[] getRate(int[] weight,int[] value) {
        double [] rate=new double[weight.length];
        for(int i=0; i<weight.length; i++) {
            rate[i]=((double)value[i])/((double)weight[i]);
        }
        return rate;
    }

    public static void BACKTRACK(int i) {
        if(i==Weight.length) {
            bestValue=cv;
            System.out.println("最优解为："+bestValue+"\n是否取该物品：");

            for(int x=0;x<flag.length;x++) {
                if(flag[x] == 1){
                    System.out.print(Value[x]+"\t"+Weight[x]+"\t");
                    System.out.println("取\t");
                }
                if (flag[x] == 0){
                    System.out.print(Value[x]+"\t"+Weight[x]+"\t");
                    System.out.println("不取\t");
                }
            }
            return;
        }
        if(cw + Weight[i] <= cap) {
            cw += Weight[i];
            cv += Value[i];
            flag[i]=1;
            BACKTRACK(i+1);
            cw -= Weight[i];
            cv -= Value[i];
            flag[i]=0;
        }
        if(BOUND(i+1)>bestValue) {
            BACKTRACK(i+1);
        }
    }

    public static int BOUND(int i) {
        int cleft=cap-cw;
        int bound=cv;
        while( i<Weight.length && cleft>Value[i] ) {
            cleft-=Weight[i];
            bound+=Value[i];
            i++;
            flag[i]=1;
        }
        return bound;

    }

    public static void swap(int[] nums, int i, int j){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }

    public static void mysort() {
        double[] rate=getRate(Weight,Value);
        for(int i=0;i<Weight.length;i++) {
            for(int j=0;j<Weight.length-i-1;j++) {
                if(rate[j]<rate[j+1]) {
                    double temp=rate[j];
                    rate[j]=rate[j+1];
                    rate[j+1]=temp;

                    swap(Weight,j,j+1);
                    swap(Value,j,j+1);

                }
            }
        }
    }
}

