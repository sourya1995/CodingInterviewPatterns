package Greedy;

import java.util.Arrays;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) {
            return -1;
        }

        int currentGas = 0;
        int startingIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }

        return startingIndex;
    }
}
