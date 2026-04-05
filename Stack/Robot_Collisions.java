import java.util.*;

public class Robot_Collisions {

    public static void main(String[] args) {
        int[] positions = { 13, 3 }, healths = { 17, 2 };
        String directions = "LR";

        int n = positions.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));
        Stack<Integer> stack = new Stack<>();

        for (int i : indices) {
            char ch = directions.charAt(i);
            int health = healths[i];
            
            if (ch == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    if (healths[stack.peek()] == health) {
                        healths[i] = 0;
                        healths[stack.pop()] = 0;
                        break;
                    } else if(healths[stack.peek()] > health) {
                        healths[stack.peek()]--;
                        healths[i] = 0;
                        break;
                    } else {
                        healths[i]--;
                        healths[stack.pop()] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                ans.add(healths[i]);
            }
        }
        

        System.out.println(ans);

        return;

    }
}