import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        obj.addNum(0);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(8);
        System.out.println(obj.findMedian());
        obj.addNum(9);
        System.out.println(obj.findMedian());

        return;
    }
}

class MedianFinder {

    PriorityQueue<Integer> maxHeap; // its size is greater if total size is odd
    PriorityQueue<Integer> minHeap;
    int size;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        size = 0;
    }

    public void addNum(int num) {
        if (size == 0) {
            size++;
            maxHeap.add(num);

            return;
        }

        if (maxHeap.peek() <= num) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }

        size++;

    }

    public double findMedian() {
        if ((size & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }

        return (double) maxHeap.peek();
    }
}
