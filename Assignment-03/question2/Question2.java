import java.util.*;

public class Question2 {

    
    static int maxLearningPoints(int[] points, int i, int[] dp) {

        // Base case, if the index is greater than the size of array
        if (i >= points.length) {
            return 0;
        }

        // If already calculated, return the calculated value
        if (dp[i] != -1) {
            return dp[i];
        }

        // If you pick the current element
        int pick = points[i] + maxLearningPoints(points, i + 2, dp);

        // If don't pick the Current Element
        int notPick = maxLearningPoints(points, i + 1, dp);

        // Calculate the maximum after picking and not picking
        dp[i] = Math.max(pick, notPick);

        return dp[i];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No of Topics:-");
        int n = sc.nextInt();

        int[] points = new int[n];

        System.out.println("Enter the 'N' no of Learning Points:-");
        
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int answer = maxLearningPoints(points, 0, dp);

        System.out.println("Max Learning Points without selecting two consecutive topics:-");
        System.out.println(answer);

        sc.close();
    }
}

 