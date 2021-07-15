
public class A3_4 {
    private final static int N=100000;
    public static void main(String[] args) {
        int[][] matrix= {
                {0,-1,3,N,N},
                {N,0,3,2,2},
                {N,N,0,N,N},
                {N,1,5,0,N},
                {N,N,N,-3,0}
        };
		/*int[][] matrix= {
				{N,N,N,N,-1,N},
				{1,N,N,2,N,N},
				{N,2,N,N,N,-8},
				{-4,N,N,N,3,N},
				{N,7,N,N,N,N},
				{N,5,10,N,N,N}
		};*/
        int[][] path=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                path[i][j]=i;
            }
        }
        FLOYD(matrix, path);
    }
    /**
     * Floyd算法
     * @param s matrix的邻接矩阵表示
     * @param path matrix的路径矩阵
     */
    public static void FLOYD(int[][] s,int[][] path) {
        /*-------------核心部分-------------*/
        for(int k=1;k<s.length;k++) {
            for(int i=0;i<s.length;i++) {
                for(int j=0;j<s.length;j++) {
                    if(s[i][k]!=N && s[k][j]!=N && s[i][j]>s[i][k]+s[k][j]) {
                        s[i][j]=s[i][k]+s[k][j];
                        path[i][j]=k;
                    }
                }
            }
        }
        /*-------------核心部分-------------*/
        System.out.println("*****结点对最短路径距离的矩阵*****");
        for(int i=0;i<s.length;i++) {
            for(int j=0;j<s.length;j++) {
                if(s[i][j]==N)
                    System.out.print("NULL\t");
                else
                    System.out.print(s[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\n**********路径path的矩阵**********");
        for(int i=0;i<s.length;i++) {
            for(int j=0;j<s.length;j++) {
                System.out.print(path[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<s.length;i++) {
//            System.out.println("-----源结点为"+i+"时：-----");
            for(int j=0;j<s.length;j++) {
                if(i==j) continue;
                else if(s[i][j]==N){
                    System.out.println(i+"到"+j+"之间不存在！");
                }else {
                    System.out.println(i+"到"+j+"之间的最短路径距离为："+s[i][j]);
                    System.out.print("其最短路径为：");
                    getPath(path,i,j);
                }
            }
            System.out.println();
        }
    }
    /**
     * 使用递归表示i到j之间的最短路径距离的路径(倒序)
     * @param path 路径矩阵
     * @param x 源节点
     * @param y 终节点
     */
    public static void getPath(int[][] path,int x,int y) {
        if(x==path[x][y]) {
            System.out.println(y+"<---"+x);
        }else {
            System.out.print(y+"<---");
            getPath(path,x,path[x][y]);
        }
    }
}
