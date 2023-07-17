import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuildingBridges {
    public static int maxBridgesCount(int[] north, int[] south){
        int n = north.length;
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            pairs.add(new ArrayList<>(Arrays.asList(north[i], south[i])));
        }
        Collections.sort(pairs, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2){
                return p1.get(0).compareTo(p2.get(0));
            }
            
        });

        List<Integer> memoNorth = new ArrayList<>();
        for(int i = 0; i < n; i++){
            memoNorth.add(pairs.get(i).get(1));
        }

        int[][]dp = new int[n+1][n+1];
        for(int curr = n- 1; curr > -1; curr--){
            for(int prev = curr - 1; prev > -2; prev--){
                int length = dp[curr + 1][prev + 1];
                if(prev < 0 || memoNorth.get(prev) < memoNorth.get(curr)){
                    length = Math.max(length, 1 + dp[curr + 1][curr + 1]);
                }
                dp[curr][prev + 1] = length;
            }
        }
        return dp[0][0];
    }
}
