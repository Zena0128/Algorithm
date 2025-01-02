import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<LinkedHashMap<String, Integer>> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            boolean ok = false;
            for (int j = 0; j < rooms.size(); j++) {
                LinkedHashMap<String, Integer> nowRoom = rooms.get(j);
                if (levelAvailable(l, nowRoom.values().iterator().next())) {
                    if (nowRoom.size() < m) {
                        nowRoom.put(n, l);
                        ok = true;
                        break;
                    }
                }
            }

            if (!ok) {
                rooms.add(new LinkedHashMap<>());
                rooms.get(rooms.size() - 1).put(n, l);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            LinkedHashMap<String, Integer> nowRoom = rooms.get(i);
            if (nowRoom.size() == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            nowRoom.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    try {
                        bw.write(entry.getValue() + " " + entry.getKey() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        }

        bw.flush();
        bw.close();
    }

    static boolean levelAvailable(int player, int room) {
        return player <= room + 10 && player >= room - 10;
    }
}