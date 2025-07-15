public class FileRenaming {

    public static void backtrack(String newName, String oldName, int count[], StringBuilder curr, int st) {
        if (curr.length() == newName.length()) {
            System.out.println("Current: " + curr);
            if (curr.toString().equals(newName)) {
                System.out.println("Count: " + count);
                count[0] += 1;
            }
            return;
        }

        for (int i = st; i < oldName.length(); i++) {
            curr.append(oldName.charAt(i));
            backtrack(newName, oldName, count, curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

    public static int renameFile(String newName, String oldName) {
        int count[] = new int[1];

        backtrack(newName, oldName, count, new StringBuilder(), 0);

        return count[0];

    }

    public static void main(String[] args) {
        String oldName = "ababa";
        String newName = "aba";

        int count = renameFile(newName, oldName);
        System.out.println(count);

    }
}