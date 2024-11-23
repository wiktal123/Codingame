import java.util.*;

public class MovesInMaze {

    static int[] dx = {0, 0, -1, 1}; // Left, Right, Up, Down
    static int[] dy = {-1, 1, 0, 0};

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char moveCountToChar(int count) {
        if (count < 10) return (char) ('0' + count);  // 0-9
        return (char) ('A' + count - 10);            // A-Z
    }

    static void bfs(List<StringBuilder> maze, int w, int h, int startX, int startY) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] dist = new int[h][w];
        for (int[] row : dist) Arrays.fill(row, -1); // Initialize distances to -1

        queue.add(new Pair(startX, startY));
        dist[startY][startX] = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int currentDist = dist[p.y][p.x];

            for (int i = 0; i < 4; i++) {
                int newX = (p.x + dx[i] + w) % w; // Wrap horizontally
                int newY = (p.y + dy[i] + h) % h; // Wrap vertically

                // Check if it's a valid move
                if (maze.get(newY).charAt(newX) == '.' && dist[newY][newX] == -1) {
                    dist[newY][newX] = currentDist + 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }

        // Update the maze with distances
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (maze.get(y).charAt(x) == '.') {
                    if (dist[y][x] == -1) {
                        maze.get(y).setCharAt(x, '.'); // Unreachable point
                    } else {
                        maze.get(y).setCharAt(x, moveCountToChar(dist[y][x]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine(); // Consume the newline
        }

        List<StringBuilder> maze = new ArrayList<>();
        int startX = 0, startY = 0;

        for (int i = 0; i < h; i++) {
            String row = in.nextLine();
            if (row.contains("S")) {
                startX = row.indexOf("S");
                startY = i;
                row = row.replace('S', '.'); // Replace start position with free space
            }
            maze.add(new StringBuilder(row));
        }

        bfs(maze, w, h, startX, startY);

        for (StringBuilder row : maze) {
            System.out.println(row);
        }
    }
}
