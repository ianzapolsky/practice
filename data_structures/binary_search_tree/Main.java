// Main.java

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertRecursively(5);
        bst.insertRecursively(3);
        bst.insertRecursively(2);
        bst.insertRecursively(4);
        bst.insertRecursively(6);

        System.out.println(bst.printInOrder());
        bst.remove(3);
        System.out.println(bst.printInOrder());
        System.out.println(bst.DepthFirstSearch(6).data);
        System.out.println(bst.BreadthFirstSearch(6).data);

    }

    public static boolean sameTreeStupid(BinarySearchTree a, BinarySearchTree b) {
        if (a.printInOrder().equals(b.printInOrder()))
            return true;
        else  
            return false;
    }

    public static boolean sameTree(BinarySearchTree a, BinarySearchTree b) {
        return (sameTreeRecurse(a.root, b.root));
    }
    public static boolean sameTreeRecurse(Node a, Node b) {
        if ( (a == null && b != null) || (a != null && b == null) )
            return false;
        if (a == null && b == null)
            return true;
        if (a.data != b.data)
            return false;
        else if (sameTreeRecurse(a.left, b.left) == true &&
                 sameTreeRecurse(a.right, b.right) == true)
            return true;
        else
            return false;
    }

}
