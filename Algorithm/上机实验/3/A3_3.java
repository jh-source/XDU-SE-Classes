public class A3_3 {
    private final static int N=10000;

    public static void Bellmanford(Edge[] s, int[] dist, int[] pre) {
        for(int i=1;i<dist.length;i++) {
            for(int j=0;j<s.length;j++) {
                if( dist[s[j].get_end()] > dist[s[j].get_start()]+s[j].get_weight() ) {
                    dist[s[j].get_end()] = dist[s[j].get_start()]+s[j].get_weight();
                    pre[s[j].get_end()] = s[j].get_start();
                }
            }
        }
        for(int j=0;j<s.length;j++) {
            if( dist[s[j].get_end()] > dist[s[j].get_start()]+s[j].get_weight() ) {
                System.out.println("有负环！无解决方案，现在退出！");
                System.exit(0);
            }
        }
        for (int i = 1; i < dist.length; i++) {
            System.out.println("源结点到"+i+"的最短距离为："+dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix= {
                {N,-1,3,N,N},
                {N,N,3,2,2},
                {N,N,N,N,N},
                {N,1,5,N,N},
                {N,N,N,-3,N}
        };
        Edge[] e={
                new Edge(0,1,-1),
                new Edge(0,2,3),
                new Edge(1,4,2),
                new Edge(1,3,2),
                new Edge(1,2,3),
                new Edge(3,1,1),
                new Edge(3,2,5),
                new Edge(4,3,-3)
        };
        int[] dist=new int[matrix.length];
        int[] p=new int[matrix.length];
        dist[0] = 0;

        for (int i = 1; i < matrix.length; i++) {
            dist[i] = N;
            p[i] = 0;
        }
        A3_3.Bellmanford(e, dist, p);
    }
}



class Edge{
    private int start;
    private int end;
    private int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int get_start() {

        return start;
    }

    public int get_end() {

        return end;
    }

    public int get_weight() {
        return weight;
    }




}


