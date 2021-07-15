public class A2_1 {
    public static void Matrix_Chain_Order(int[] p){
        int n = p.length-1;
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1];
        int i,j,k,t;

        for (i=0;i<=n;i++)
            m[i][i] = 0;
        for (i=0;i<=n;i++)
            s[i][i] = 0;
        for(t=2; t<=n; t++)
        {
            for(i=1;i<=n-t+1;i++)
            {
                j = i+t-1;
                m[i][j] = Integer.MAX_VALUE;
                for(k=i;k<=j-1;k++)
                {
                    int tmp = m[i][k]+m[k+1][j] + p[i-1]*p[k]*p[j];
                    if(tmp < m[i][j])
                    {
                        m[i][j] = tmp;
                        s[i][j] = k;
                    }
                }
            }
        }
//        System.out.println("一个最优解为：");

        System.out.print("最小代价为：");
        System.out.println(m[1][n]);
        Display(s,1,n);
    }
    public static void Display(int[][] s,int i,int j)
    {
        if( i == j)
        {
            System.out.print('A');
            System.out.print(i);
        }
        else
        {
            System.out.print('(');
            Display(s,i,s[i][j]);
            Display(s,s[i][j]+1,j);
            System.out.print(')');
        }


    }

    public static void main(String[] args)
    {
        int[] a={3, 5, 2, 1, 10};
        int[] b={2, 7, 3, 6, 10};
        int[] c={10, 3, 15, 12, 7, 2};
        int[] d={7, 2, 4, 15, 20, 5};

        System.out.println("<3, 5, 2, 1,10>");
        Matrix_Chain_Order(a);
        System.out.println("");
        System.out.println("<2, 7, 3, 6, 10>");
        Matrix_Chain_Order(b);
        System.out.println("");
        System.out.println("<10, 3, 15, 12, 7, 2>");
        Matrix_Chain_Order(c);
        System.out.println("");
        System.out.println("<7, 2, 4, 15, 20, 5>");
        Matrix_Chain_Order(d);
        System.out.println("");


    }



}
