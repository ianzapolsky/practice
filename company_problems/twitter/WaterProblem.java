// WaterProblem.java

// Description: Twitter water problem: 
//              http://qandwhat.apps.runkite.com/i-failed-a-twitter-interview/
// Author: Ian Zapolsky (10/30/13)

public class WaterProblem {

    public static void main(String[] args) {
        int[] landscape = {3,7,1,2,3,4,5,2,4};
        System.out.println(assessFlood(landscape));
        System.out.println(assessFloodOnePass(landscape));
    }

    // These pair of methods implement what is a sliiightly better version of
    // a two-pass attempt at this problem. I say slightly better because it
    // will only travese twice the parts of the array that are possible
    // puddles. Still O(n^2) though...
    public static int assessFlood(int[] landscape) {

        int fillableBlocks = 0;
        for (int i = 0; i < landscape.length-1; i++) {
            int cur = i+1;
            if (landscape[cur] >= landscape[i]) {
                /* do nothing */;
            }
            else {
                int puddleBlocks = 0;
                int waterLevel = findWaterLevel(landscape, i);
                for (;;) {
                    if (cur == landscape.length) {
                        puddleBlocks = 0;
                        i = landscape.length-1;
                        break;
                    }
                    if (landscape[cur] >= waterLevel) {
                        i = cur-1; 
                        break;
                    }
                    else {
                        puddleBlocks += (waterLevel - landscape[cur]);
                        cur += 1;
                    }
                }
                fillableBlocks += puddleBlocks;
            }
        }
        return fillableBlocks;
    }

    public static int findWaterLevel(int[] landscape, int i) {
        int front = i+1;
        while (front < landscape.length-1) {
            if (landscape[front] == landscape[front+1] || 
                landscape[front] > landscape[front+1]) {
                break;
            }
            if (landscape[front] < landscape[i])
                front++;
            else
                break;
        }
        if (front == landscape.length)
            return landscape[i];
        else
            return Math.min(landscape[i], landscape[front]);
    }


    public static int assessFloodOnePass(int[] landscape) {
        int left = 0;
        int right = landscape.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int fillableBlocks = 0;

        while (left < right) {
            if (landscape[left] > leftMax)
                leftMax = landscape[left];
            if (landscape[right] > rightMax)
                rightMax = landscape[right];
            if (leftMax >= rightMax) {
                fillableBlocks += rightMax - landscape[right];
                right -= 1;
            } else {
                fillableBlocks += leftMax - landscape[left];
                left += 1;
            }
        }
        return fillableBlocks;
    }

}
    
    
