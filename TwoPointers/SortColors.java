public class SortColors {
    public static int[] sortColors(int[] colors){
        int red = 0;
        int white = 0;
        int blue = colors.length - 1;

        while(white <= blue){
            if(colors[white] == 0){
                if(colors[red] != 0){
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }
                white++;
                red++;
            }

            else if(colors[white] == 1){
                white++;
            }

            else{
                if(colors[blue] != 2){
                    int temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }
                blue--;
            }
        }
        return colors;
    }
}
