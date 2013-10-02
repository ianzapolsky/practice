// Node.java
// by Ian Zapolsky (09/27/13)

public class Node<T> {
    public T value;
    public Node next;
    public Node prev;

    public Node(T initValue, Node initPrev, Node initNext) {
        value = initValue;
        next = initNext;
        prev = initPrev;
    }

}
