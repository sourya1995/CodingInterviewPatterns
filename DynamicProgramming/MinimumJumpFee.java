package DynamicProgramming;

public class MinimumJumpFee {
    public static int minFee(int[] fee, int n){
        int[] lookupArray = new int[n+1];
        for(int i = 0; i < lookupArray.length; i++){
            lookupArray[i] = 0;
        }

        lookupArray[0] = 0;
        lookupArray[1] = fee[0];
        lookupArray[2] = fee[1];

        for(int i =3; i < n+1; i++){
            int oneStep = fee[i - 1] + lookupArray[i - 1];
            int twoStep = fee[i- 2] + lookupArray[i - 2];
            int threeStep = fee[i - 3] + lookupArray[i - 3];
            lookupArray[i] = Math.min(Math.min(oneStep, twoStep), threeStep);
        }

        return lookupArray[n];
    }
}
