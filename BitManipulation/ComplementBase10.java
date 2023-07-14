package BitManipulation;

public class ComplementBase10 {
    public static int findBitwiseComplement(int num){
        if(num == 0){
            return 1;
        }

        int bitCount = (int) Math.floor((int)(Math.log(num) / Math.log(2))) + 1;
        int allBitSet = (int) Math.pow(2, bitCount) - 1;
        return num ^ allBitSet;
    }
}
