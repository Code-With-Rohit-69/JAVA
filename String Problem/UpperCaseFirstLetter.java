public class UpperCaseFirstLetter {

    public static String toUpperCaseFirstLetter(String str) {
        String newStr = "";

        newStr += Character.toUpperCase(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);

            if (currChar == ' ') {
                newStr += currChar;
                i++;
                newStr += Character.toUpperCase(str.charAt(i));
            } else {
                newStr += currChar;
            }

            
        }

        return newStr.trim();
    }

    public static void main(String[] args) {
        String str = "hi, my self rohit singh.";
        String result = toUpperCaseFirstLetter(str);
        System.out.println(result);
    }
}