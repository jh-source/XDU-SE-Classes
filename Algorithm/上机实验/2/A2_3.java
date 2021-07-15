public class A2_3 {
    public int getLongestCommonSubstring(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int max = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(max < dp[i][j])
                        max = dp[i][j];
                }else {
                    dp[i][j] = 0;
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s1 = "xzyzzyx";
        String s2 = "zxyyzxz";
        System.out.println("序列A为："+s1);
        System.out.println("序列B为："+s2);
        System.out.println("最长公共子串长度为："+(new A2_3()).getLongestCommonSubstring(s1,s2));

        String s3 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        String s4 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
        System.out.println("序列A为："+s3);
        System.out.println("序列B为："+s4);
        System.out.println("最长公共子串长度为："+(new A2_3()).getLongestCommonSubstring(s3,s4));
    }
}
