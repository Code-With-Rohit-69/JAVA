import java.util.*;

public class Classroom {

    static class HashMap<K, V> { // this is known as generic means we don't know the type of key and values so it
                                 // can be intialize to any datatype
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n = number of nodes
        private int N;
        private LinkedList<Node> buckets[]; // N = size of bucket or we can say size of the array of the linkedlist


        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode(); // here we are doing the hashing for particular key which can be any form
                                           // means it can be +ve, -ve but always give in numbers;
            return Math.abs(hashCode) % N; // finding the absolute value of generated hashcode and find making the
                                           // particular bucket index which is from 0 to size - 1;
        }

        private int searchLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex]; // finding the particular linked list

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);

                if (node.key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            N = 2 * N;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // add nodes back to new bucket

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key); // we are finding the bucket index for particular key
            int dataIndex = searchLL(key, bucketIndex); // here, we are finding the data index for the key in particular
                                                        // linked list which can be present or cannot;

            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            } else {
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            }

            double lambda = (double) (n / N);

            if (lambda > 2.0) {
                reHash();
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchLL(key, bucketIndex);

            if (dataIndex == -1) {
                return false;
            }

            return true;
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchLL(key, bucketIndex);

            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }

            return null;
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchLL(key, bucketIndex);

            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }

            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Nepal", 5);

        ArrayList<String> keys = map.keySet();
        for(String key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        System.out.println("Contains key: " + map.containsKey("india") + " => " + map.get("india"));

    }
}
