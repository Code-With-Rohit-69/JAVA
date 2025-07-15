public class LengthOfLastWord {
    
    public static int lengthOfLastWord(String s) {
        String stringArray[] = s.split("\\s+");

        String str = stringArray[stringArray.length-1];

        return str.length();
    }
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int result = lengthOfLastWord(s);
        System.out.println(result);
    }
}

