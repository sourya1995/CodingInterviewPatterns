package DynamicProgramming;

public class MatrixMultiplicationChain {
    public static long minMultiplications(int[] dims){
        long[][] dp = new long[dims.length][dims.length];
        for(int i = 0; i < dims.length; i++){
            for(int j = 0; j < dims.length; j++){
                dp[i][j] = 0;
            }
        }

        for(int l = 2; l < dims.length; l++){
            for(int i = 1; i < ((dims.length) - l + 1); i++){
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    long temp = dp[i][k] + dp[k+1][j] + dims[i - 1]* dims[k]* dims[j];
                    if(temp < dp[i][j]){
                        dp[i][j] = temp;
                    }
                }
            }
        }
        return dp[1][dp.length - 1]; 
    }
}
