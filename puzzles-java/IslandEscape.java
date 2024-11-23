import java.util.*;

class IslandEscape {

    public static boolean dfs(int node, List<Integer>[] graph, int[] map, int[] visited){
        visited[node] = 1;
        for(int neighbor : graph[node]){
            if(visited[neighbor] == 0 ){
                if(map[neighbor] == 0) return true;
                if(dfs(neighbor, graph, map, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int idx = 0;
        int[] map = new int[N * N];
        List<Integer>[] graph = new ArrayList[N * N];
        int[] visited = new int[N * N];
        
        for(int i = 0; i < N * N; i++) {
            visited[i] = 0;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int elevation = in.nextInt();
                map[idx++] = elevation;
            }
        }

        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int current = i * N + j;
                if(i > 0 && Math.abs(map[current] - map[(i - 1) * N + j]) <= 1) graph[current].add((i - 1) * N + j);
                if(i < N - 1 && Math.abs(map[current] - map[(i + 1) * N + j]) <= 1) graph[current].add((i + 1) * N + j);
                if(j > 0 && Math.abs(map[current] - map[i * N + j - 1]) <= 1) graph[current].add(i * N + j - 1);
                if(j < N - 1 && Math.abs(map[current] - map[i * N + j + 1]) <= 1) graph[current].add(i * N + j + 1);
            }
        }

        System.out.println((dfs(N * N / 2, graph, map, visited)) ? "yes" : "no");
    }
}