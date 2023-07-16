package BitManipulation;

public class AddTwoNumbers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b);
            a = a ^ b;
            b = tmp << 1;
        }
        return a;
    }
}
