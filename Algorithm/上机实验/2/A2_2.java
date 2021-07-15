public class A2_2 {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "xzyzzyx";
        String s2 = "zxyyzxz";
        System.out.println("序列A为："+s1);
        System.out.println("序列B为："+s2);
        System.out.println("最长公共子序列长度为："+(new A2_2()).longestCommonSubsequence(s1, s2));

        String s3 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        String s4 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
        System.out.println("序列A为："+s3);
        System.out.println("序列B为："+s4);
        System.out.println("最长公共子序列长度为："+(new A2_2()).longestCommonSubsequence(s3, s4));
    }
}
