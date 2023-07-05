package SlowAndFastPointers;

public class HappyNumber {
    public static int sumOfSquaredDigits(int number){
        int totalSum = 0;
        while(number != 0){
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));

        }
        return totalSum;
    }

    public static boolean isHappyNumber(int number){
        int slow = number;
        int fast = sumOfSquaredDigits(number);
        while(fast != 1 && slow != fast){
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }
}
