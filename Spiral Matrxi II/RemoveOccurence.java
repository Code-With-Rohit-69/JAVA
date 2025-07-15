public class RemoveOccurence {

    public static String removeOccurence(String s, String part) {
        int index = s.indexOf(part);

        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }

        return s;
    }
    
    public static void main(String[] args) {
        String str = "abdgusabdibadhishdn";
        String part = "abd";
        String result = removeOccurence(str, part);
        System.out.println(result);
    }
}
