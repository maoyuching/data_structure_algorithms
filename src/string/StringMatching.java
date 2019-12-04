package string;

import java.util.HashSet;
import java.util.Set;

public class StringMatching {


    public static char[] stringSet(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        char[] ans = new char[set.size()];
        Object[] temp = set.toArray();
        for (int i = 0; i < temp.length; i++) {
            ans[i] =  (char) temp[i];
        }
        return ans;
    }

    public static int finiteAutomataMatcher(String Ts, String ps) {
        char[] T = Ts.toCharArray();
        char[] M = stringSet(Ts);
        char[] p = ps.toCharArray();

        return -1;

    }


    public static int simpleMatch(String T, String p) {
        for (int i = 0; i < T.length() - (p.length() - 1); i++) {
            int j = 0;
            while (j < p.length()) {
                if (p.charAt(j) != T.charAt(i+j)) break;
                j++;
            }
            if (j == p.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] c = stringSet("helloworld");

        System.out.println(simpleMatch("hello", "llo"));
    }
}
