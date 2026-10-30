package palindrome;

public class Palindrome {
    public static String generer(String mot) {
        int i = 0;
        StringBuilder sb = new StringBuilder(mot);
        while (!isPalindrome(sb.toString())) {
            sb.insert(sb.length() - i, mot.charAt(i));
            i++;
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String mot) {
        int gauche = 0;
        int droite = mot.length() - 1;

        while (gauche < droite) {
            if (mot.charAt(gauche) != mot.charAt(droite)) {
                return false;
            }
            gauche++;
            droite--;
        }
        return true;
    }
}
