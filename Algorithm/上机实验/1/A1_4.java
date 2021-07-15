import java.util.Arrays;

public class A1_4 {
    public int find(int[] a, int[] b, int al, int ar, int bl, int br, int k){
        if(a.length == 0)   return b[k-1];
        if(b.length == 0)   return a[k-1];
        int am = (al+ar)/2;
        int bm = (bl+br)/2;
        if(al > ar){
            return b[bl+k-1];
        }
        if(bl > br){
            return a[al+k-1];
        }


        if(k <= (am-al) + (bm-bl) + 1){
            if(a[am] <= b[bm]){
                return find(a,b,al,ar,bl,bm-1,k);
            }else {
                return find(a,b,al,am-1,bl,br,k);
            }
        }else {
            if(a[am] <= b[bm]){
                return find(a,b,am+1,ar,bl,br,k-(am-al)-1);
            }else {
                return find(a,b,al,ar,bm+1,br,k-(bm-bl)-1);
            }
        }


    }

    public static void main(String[] args) {
        int[] a = new int[]{1,50,300,500,700,900};
        int[] b = new int[]{2,100,200,500,600,800};
        int k = 7;
        System.out.println("有序数组A："+ Arrays.toString(a));
        System.out.println("有序数组B："+ Arrays.toString(b));
        int res = (new A1_4()).find(a,b,0,a.length-1,0,b.length-1,a.length+b.length-k+1);
        System.out.println("数组A和数组B的第"+k+"大元素为："+res);
    }
}