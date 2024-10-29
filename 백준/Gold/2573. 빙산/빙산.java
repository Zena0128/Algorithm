import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static List<int[]> ice = new ArrayList<>();
    private static int n;
    private static int m;
    private static int ans = 0;
    private static int group;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) ice.add(new int[]{i, j});
            }
        }
        sc.close();

        while (!ice.isEmpty()) {
            visited = new int[n][m];
            List<int[]> melted = new ArrayList<>();
            group = 0;

            for (int[] arr : ice) {
                int x = arr[0];
                int y = arr[1];
                if (visited[x][y] == 0) {
                    if (map[x][y] != 0) {
                        bfs(x, y);
                        group ++;
                    }
                }
                if (map[x][y] == 0) melted.add(new int[]{x, y});
            }
            if (group > 1) {
                System.out.println(ans);
                break;
            }
            ice.removeIf(arrA -> melted.stream().anyMatch(arrB -> Arrays.equals(arrA, arrB)));
            ans++;
        }
        if (group < 2) System.out.println(0);

    }

    public static boolean check(int nowx, int nowy) {
        return nowx >= 0 && nowx < n && nowy >= 0 && nowy < m;
    }

    public static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        List<int[]> toMelt = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] temp = q.removeFirst();
            int tx = temp[0];
            int ty = temp[1];
            int sea = 0;

            for (int i=0;i<4;i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (check(nx, ny)) {
                    if (map[nx][ny] == 0) sea++;
                    else if (map[nx][ny] != 0 && visited[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        
            if (sea > 0) toMelt.add(new int[]{tx, ty, sea});
        }

        for (int[] meltable : toMelt) {
            int mx = meltable[0];
            int my = meltable[1];
            int num = meltable[2];
            map[mx][my] = Math.max(0, map[mx][my] - num);
        }
    }
}