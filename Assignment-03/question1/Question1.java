import java.util.*;

public class Question1 {

    // Function to find maximum number of students
    static int maxStudents(int[] scholarship, long budget) {

        // Sort scholarship amounts
        Arrays.sort(scholarship);

        int count = 0;

        // Select students requiring minimum amounts first
        for (int amount : scholarship) {
            if (amount <= budget) {
                budget -= amount;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No of Students:-");
        int n = sc.nextInt();
        System.out.println("Enter the Budget you have:-");

        long budget = sc.nextLong();

        int[] scholarship = new int[n];

        System.out.println("Enter Min. Scholarship Amount of N students:-");
        for (int i = 0; i < n; i++) {
            scholarship[i] = sc.nextInt();
        }

        // Function call
        int answer = maxStudents(scholarship, budget);
        System.out.println("The Maximum No of Students who can recieve Scholarship is :-");
        
        System.out.println(answer);

        sc.close();
    }
}