package BitManipulation;

public class InvertImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int rowCount = image.length;
        int mid = (rowCount + 1) / 2;
        for (int[] row : image) {
            for (int i = 0; i < mid; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[row.length - 1 - i] ^ 1;
                row[row.length - 1 - i] = temp;
            }
        }
        return image;
    }

}
