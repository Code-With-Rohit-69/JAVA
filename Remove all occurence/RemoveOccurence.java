public class RemoveOccurence {

    public static String subString(String str, int i, int j) {
        String subStr = "";
        for (int k = i; k <= j; k++) {
            subStr += str.charAt(k);
        }
        return subStr;
    }

    public static String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);

        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "axxxxyyyyb";
        String part = "xy";

        String result = removeOccurrences(s, part);
        System.out.println(result);
    }
}