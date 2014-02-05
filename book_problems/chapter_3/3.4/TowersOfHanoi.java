// TowersOfHanoi.java

// Description: Write an algorithm that solves the famous towers of hanoi
// problem using three stacks.
// Author: Ian Zapolsky (10/25/13)

public class TowersOfHanoi {
    
    public Stack left, center, right;
    public int n;
    
    public TowersOfHanoi(int init_n) {
        n = init_n;
        left = new Stack(n, "left");
        center = new Stack(n, "center");
        right = new Stack(n, "right");
        
        // fill the left stack with n disks
        for (int i = n; i > 0; i--)
            left.push(i);
    
    }

    public void solve() {
        left.moveDisks(n, right, center);
    }

    public String toString() {
        String result = "left:"+left+"\ncenter:"+center+"\nright:"+right;
        return result;    
    }

}

