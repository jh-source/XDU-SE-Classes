

public class A3_1 {

	public static void Packet_01(int[] weight,int[] value,int cap,int num) {

		int[][] array=new int[num+1][cap+1];

		for(int i=0;i<num+1;i++) {
			for(int j=0;j<cap+1;j++){
				array[i][j]=0;
			}
		}

		for(int i=1;i<=num;i++) {
			for(int j=1;j<=cap;j++) {
				if(j>=weight[i-1]) {
					array[i][j] = Math.max(array[i-1][j],array[i-1][j-weight[i-1]]+value[i-1]);
				}else {
					array[i][j]=array[i-1][j];
				}
			}
		}
		System.out.println("最高总价值为:"+array[num][cap]);
	}

	public static void Kn_packet(int[] weight,int[] value,int cap) {
		double[] rate = new double[weight.length];
		for (int i=0; i<weight.length; i++){
			rate[i] = ((double)value[i])/((double)weight[i]);
		}

		int size=weight.length;

		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(rate[j]<rate[j+1]) {
					double temp=rate[j];
					rate[j]=rate[j+1];
					rate[j+1]=temp;

					swap(weight,j,j+1);
					swap(value,j,j+1);
				}
			}
		}
		int newcap=cap,i=0,max=0;

		while(newcap>0&&i<size) {
			if(weight[i]<=newcap) {
				newcap=newcap-weight[i];
				max+=value[i];
			}else {
				max+=(newcap*rate[i]);
				newcap=0;
			}
			i++;
		}
		System.out.println("最高总价值为："+max);

	}

	public static void swap(int[] nums, int i, int j){
		int x = nums[i];
		nums[i] = nums[j];
		nums[j] = x;
	}

	public static void main(String[] args) {
		int[] Weight= {10,20,30,40,50};
		int[] Value= {20,30,65,40,60};
		System.out.println("0/1背包问题：");
		Packet_01(Weight, Value, 100, Weight.length);
		System.out.println("分数背包问题：");
		Kn_packet(Weight, Value, 100);
	}
}
