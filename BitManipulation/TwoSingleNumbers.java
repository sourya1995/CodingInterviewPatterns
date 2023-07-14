package BitManipulation;

public class TwoSingleNumbers {
    public static int[] twoSingleNumbers(int[] arr){
        int bitwise = 0;
        for(int i: arr){
            bitwise ^= i;
        }

        int bitmask = bitwise & (-bitwise);
        int results = 0;
        for(int i: arr){
            if((bitmask & i) != 0){
                results = results ^ i;
            }
        }
        int[] res = new int[2];
        res[0] = results;
        res[1] = bitwise ^ results;
        return res;
    }
}
