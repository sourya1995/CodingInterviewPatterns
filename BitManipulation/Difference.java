package BitManipulation;

public class Difference {
    public static int extraCharacterIndex(String str1, String str2){
        int result = 0;
        int index = 0;
        int str1Length = str1.length();
        int str2Length = str2.length();

        for(int i = 0; i < str1Length; i++){
            result ^=str1.charAt(i);
        }

        for(int i = 0; i < str2Length; i++){
            result ^=str2.charAt(i);
        }

        if(str1.length() > str2.length()){
            index = str1.indexOf((char)(result));
            return index;
        }

        else {
            index = str2.indexOf((char)(result));
            return index;
        }
    }
}
