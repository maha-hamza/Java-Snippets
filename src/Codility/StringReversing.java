package Codility;

public class StringReversing {

    public static void main(String[] args) {
        char[] stringToReverse = {' ',' ',' ','h','i',' ','y','o','u',' ',' ',' ','H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', ' ', 'I', 'T', 'S', ' ', 'M', 'A', 'H', 'A',' ',' ',' ',' '};
       System.out.println(reverseStringPhrase(stringToReverse));

    }

    private static char[] reverseStringPhrase(char[] stringToReverse){
        String reversed="";
        String s = "";
        for (int i = stringToReverse.length-1; i >= 0; i--) {
            if (stringToReverse[i] != ' ' ) {
                s += stringToReverse[i]+"";
            }
            if(stringToReverse[i] == ' '|| i==0) {
                reversed += reverseString(s);
            }
            if(stringToReverse[i] == ' ') {
                reversed += " ";
                s="";
            }

        }
        return reversed.toCharArray();
    }

    private static String reverseString(String s) {
        String toRev = "";
        for (int i = s.length() - 1; i >= 0; i--)
            toRev += s.charAt(i);
        return toRev;
    }

}

