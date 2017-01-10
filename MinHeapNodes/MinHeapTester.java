public class MinHeapTester {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(1, 9);
        heap.insert(3, 9);
        heap.insert(6, 9);
        heap.insert(5, 9);
        heap.insert(9, 9);
        heap.insert(8, 9);

        heap.print();

        heap.delete();
        
        heap.print();

        System.out.println(heap.peekNode());
    }
}