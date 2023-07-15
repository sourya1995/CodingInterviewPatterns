class RibbonCut{
    public static int countRibbonPieces(int n, int[] sizes){
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++)
            dp[i] = -1;

        dp[0]= 0;
        for(int i = 1; i < n+1; i++){
            for(int c = 0; c < sizes.length; c++){
                if(i - sizes[c] >= 0 && dp[i - sizes[c]] != -1){
                    dp[i] = Math.max(dp[i], 1 + dp[i - sizes[c]]);
                }
            }
        }

        if(dp[n] != -1){
            return dp[n];
        } else{
            return -1;
        }



    }
}