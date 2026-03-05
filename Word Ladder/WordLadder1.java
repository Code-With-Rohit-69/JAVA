import java.util.*;
import java.util.LinkedList;

public class WordLadder1 {

    public static int wordLadder1(String startWord, String targetWord, String[] wordList) {

        HashSet<String> set = new HashSet<>();

        for(String word : wordList) {
            set.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            String word = curr.word;
            int step = curr.step;

            if (word.equals(targetWord)) {
                return step;
            }

            char[] ch = word.toCharArray();

            for(int i = 0; i < ch.length; i++) {
                char currChar = ch[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String newString = new String(ch);
                    ch[i] = currChar;

                    if (set.contains(newString)) {
                        q.add(new Pair(newString, step + 1));
                        set.remove(newString);
                    }
                }

            }

        }

        return -1;
    }
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des","der","dfr","dgt","dfs"};

        System.out.println(wordLadder1(startWord, targetWord, wordList));
    }    
}

class Pair {
    String word;
    int step;

    public Pair(String w, int s) {
        this.word = w;
        this.step = s;
    }
}