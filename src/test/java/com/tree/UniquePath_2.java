package com.tree;

public class UniquePath_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length, n= obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            } else {
                dp[0][i] =1;
            }
        }
        // m rows
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            else{
                dp[i][0] =1;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] =0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }



        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath_2 solution = new UniquePath_2();

        // Test Case
        int[][] grid = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int result = solution.uniquePathsWithObstacles(grid);
        System.out.println("Test Result: " + result);  // Expected: 2
    }
}
