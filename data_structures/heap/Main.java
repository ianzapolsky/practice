public class Main {

    public static void main(String[] args)
    {
        MinHeap m = new MinHeap(50);
        m.insert(4);
        m.insert(3); 
        m.insert(5);
        m.insert(1);
        m.insert(2);
        System.out.println(m.popMin());
        System.out.println(m.popMin());
    }
}
