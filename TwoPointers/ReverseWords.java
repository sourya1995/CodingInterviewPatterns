public class ReverseWords {
    public static String reverseWords(String s){
        char[] s1 = s.toCharArray();
        String s2 = cleanSpaces(s1, s1.length);
        StringBuilder sb = new StringBuilder(s2);

        strRev(sb, 0, sb.length() - 1);

        int n = sb.length();
        int start = 0, end = 0;
        while(start < n){
            while(end < n && sb.charAt(end) != ' ')
                ++end;
            strRev(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
        return sb.toString();
    }

    public static void strRev(StringBuilder sb, int startRev, int endRev) {
        while(startRev < endRev){
            char temp = sb.charAt(startRev);
            sb.setCharAt(startRev++, sb.charAt(endRev));
            sb.setCharAt(endRev--, temp);

        }
    }

    static String cleanSpaces(char[] a, int n){
        String str = new String(a, 0, n);
        str = str.replaceAll("\\s+", " ").trim();
        return str;
    }
}
