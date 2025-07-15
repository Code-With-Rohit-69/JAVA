import java.util.ArrayList;

public class ArrayList2 {

    public static void print(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) { // we use here size() method
            System.out.print(list.get(i) + " "); // we use here get() method to get the element on particular element
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // adding elements

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(2, 3);

        print(list);

        // removing elements

        list.remove(4); // you have to pass the specified index to remove the element

        print(list);

        // set() method

        list.set(0, 100);

        print(list);
        
    }
}