package HashMap;

import java.util.HashMap;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        if (numerator == 0) {
            return "0";
        }

        if (numerator < 0 ^ denominator < 0) {
            result.append('-');
        }

        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        long quotient = num / denom;
        long remainder = (num % denom) * 10;
        result.append(quotient);

        if (remainder == 0) {
            return result.toString();
        } else {
            result.append(".");
            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    int beginning = remainderMap.get(remainder);
                    result.insert(beginning, "(");
                    result.append(")");
                    return result.toString();
                } else {
                    remainderMap.put(remainder, result.length());
                    quotient = remainder / denom;
                    result.append(quotient);
                    remainder = (remainder % denom) * 10;
                }
            }
            return result.toString();
        }

    }
}
