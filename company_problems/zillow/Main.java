// Main.java

public class Main {

    public static void main(String[] args) {
    
        TrinaryTree t = new TrinaryTree();
        t.insert(5);
        t.insert(4);
        t.insert(5);
        t.insert(7);
        t.insert(4);
        t.insert(5);
        t.insert(7);
        t.insert(4);
        t.insert(5);
        t.insert(7);

        System.out.println(t.printInorder());
    }
}
