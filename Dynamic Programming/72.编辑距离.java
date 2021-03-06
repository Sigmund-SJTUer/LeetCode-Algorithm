/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[] dp=new int[n+1];
        for(int i=0;i<=m;++i){
            int pre=i-1;              //base case
            dp[0]=i;
            for(int j=1;j<=n;++j){
                if(i==0){
                    dp[j]=j;
                    continue;
                }
                int temp=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[j]=pre;
                }else{
                    dp[j]=Math.min(
                        dp[j],
                        Math.min(
                            dp[j-1],
                            pre
                        )
                    )+1;
                }
                pre=temp;
            }
        }
        return dp[n];
    }
}
/*
//version 1
int m=word1.length(),n=word2.length();
int[][] dp=new int[m+1][n+1];
for(int i=0;i<=m;++i){
    for(int j=0;j<=n;++j){
        if(i==0||j==0){
            dp[i][j]=(i==0)?j:i;
            continue;
        }
        if(word1.charAt(i-1)==word2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1];
        }else{
            dp[i][j]=Math.min(
                dp[i-1][j],
                Math.min(
                    dp[i][j-1],
                    dp[i-1][j-1]
                )
            )+1;
        }
    }
}
return dp[m][n];
*/
// @lc code=end

