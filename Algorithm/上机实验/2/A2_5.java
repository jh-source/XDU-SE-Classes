import java.util.Arrays;

public class A2_5 {
    public static int max = 1000;
    public int shotest_path(int len, int[][] graph, int[][] path){
        int[] cost = new int[len+1];
        cost[len] = 0;
        for(int i=len-1; i>=0; i--){
            cost[i] = max;
            for(int j=i; j<=len; j++){
                if(graph[i][j] == max){
                    continue;
                }else {
                    if (cost[i] > graph[i][j] + cost[j]){
                        cost[i] = graph[i][j] + cost[j];
                        path[i][len] = j;
                    }
                }
            }
        }
        int i=0;
        System.out.print("最短路径为：0->");
        while (path[i][len] != len){
            System.out.print(path[i][len]+"->");
            i = path[i][len];
        }
        System.out.println("15");
        System.out.print("最短路径长度为");
        return cost[0];

    }
    public static void main(String[] args) {
        int len = 15;
        int[][] graph = new int[len+1][len+1];
        int[][] path = new int[len+1][len+1];
        for(int i=0; i<=len; i++){
            for (int j=0; j<=len; j++){
                if(i == j){
                    graph[i][j] = 0;
                }else{
                    graph[i][j] = max;
                }

            }
        }
        graph[0][1]=5;graph[0][2]=3;
        graph[1][3]=1;graph[1][4]=3;graph[1][5]=6;
        graph[2][4]=8;graph[2][5]=7;graph[2][6]=6;
        graph[3][7]=6;graph[3][8]=8;
        graph[4][7]=3;graph[4][8]=5;
        graph[5][8]=3;graph[5][9]=3;
        graph[6][8]=8;graph[6][9]=4;
        graph[7][10]=2;graph[7][11]=2;
        graph[8][11]=1;graph[8][12]=2;
        graph[9][11]=3;graph[9][12]=3;
        graph[10][13]=3;graph[10][14]=5;
        graph[11][13]=5;graph[11][14]=2;
        graph[12][13]=6;graph[12][14]=6;
        graph[13][15]=4;
        graph[14][15]=3;
        System.out.println("输入邻接矩阵为：");
        for(int i=0; i<len; i++){

            System.out.println(Arrays.toString(graph[i]));

        }

        System.out.println((new A2_5()).shotest_path(len,graph,path));


    }
}
