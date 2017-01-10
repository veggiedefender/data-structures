public class MinHeapTester {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(1);
        heap.insert(3);
        heap.insert(6);
        heap.insert(5);
        heap.insert(9);
        heap.insert(8);

        heap.print();

        heap.delete();
        
        heap.print();
    }
}