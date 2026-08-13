import java.util.*;

class Graph {
    int n;
    LinkedList<Integer>[] graph;

    Graph(int n) {
        this.n = n;
        graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    int bfs(int D) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        // Start from City 1
        queue.add(1);
        distance[1] = 0;

        int count = 1;

        while (!queue.isEmpty()) {

            int current = queue.remove();

            for (int next : graph[current]) {

                if (distance[next] == -1) {

                    distance[next] = distance[current] + 1;
                    queue.add(next);

                    if (distance[next] <= D) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of N");
        int N = sc.nextInt();
        System.out.println("Enter the value of M");
        int M = sc.nextInt();
        System.out.println("Enter the value of D");
        int D = sc.nextInt();

        Graph g = new Graph(N);

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            g.addEdge(u, v);
        }
        System.out.println("The Graph is Generated");
        
        System.out.println("Total No of Efficiently Reachable Cities are: -");
        
        System.out.println(g.bfs(D));

        sc.close();
    }
}