package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    public static String lengthToBytes(String x){
        int length = x.length();
        StringBuilder bytes = new StringBuilder();
        for(int i=0; i<4; i++){
            bytes.append((char)(length >> (i*8)));
        }

        return bytes.reverse().toString();


    }

    public static int bytesToLength(String bytesString){
        int result = 0;
        for(char c: bytesString.toCharArray()){
            result = result * 256 + c;
        }
        return result;
    }

    public static String encode(List<String> strings){
        StringBuilder encodedString = new StringBuilder();
        for(String x: strings){
            encodedString.append(lengthToBytes(x)).append(x);
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str){
        int i = 0;
        List<String> decodedString = new ArrayList<String>();
        while(i < str.length()){
            int length = bytesToLength(str.substring(i, i + 4));
            i += 4;
            decodedString.add(str.substring(i, i + length));
            i += length;
        }
        return decodedString;
    }

    public static void printEncodedString(String str){
        StringBuilder finalStr = new StringBuilder();
        int i = 0;

        while(i < str.length()){
            for(char c: str.substring(i, i + 4).toCharArray()){
                finalStr.append((int) c);
            }
            int length = bytesToLength(str.substring(i, i+4));
            i += 4;
            finalStr.append(str.substring(i, i+length));
            i += length;
        }

        System.out.println(finalStr.toString());
    }


}
