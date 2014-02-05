
import java.util.ArrayList;

public class VectorCase {

    private ArrayList<Integer> vector1;
    private ArrayList<Integer> vector2;
    public int minimumScalarProduct;

    public VectorCase(int[] init_vector1, int[] init_vector2) {
        vector1 = new ArrayList<Integer>();
        vector2 = new ArrayList<Integer>();
        for (int i : init_vector1)
            vector1.add(i);
        for (int i : init_vector2)
            vector2.add(i);
        findMinimumScalarProduct();
    }

    private void findMinimumScalarProduct() {
      
        minimumScalarProduct = 0;
        int initialSize = vector1.size();
        for (int i = 0; i < initialSize; i++) 
            minimumScalarProduct += (getMin(vector1)*getMax(vector2));
    }

    private int getMin(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i < min)
                min = i;
        }
        list.remove(list.indexOf(min));
        return min;
    }
             
    private int getMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer i : list) {
            if (i > max)
                max = i;
        }
        list.remove(list.indexOf(max));
        return max;
    }

}
