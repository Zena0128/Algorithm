import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] meta = br.readLine().split(" ");
        int p = Integer.parseInt(meta[0]);
        int m = Integer.parseInt(meta[1]);

        List<LinkedHashMap<String, Integer>> rooms = new ArrayList<>();
        
        for (int i=0;i<p;i++) {
            String[] temp = br.readLine().split(" ");
            int l = Integer.parseInt(temp[0]);
            String n = temp[1];

            boolean ok = false;
            for (int j=0;j<rooms.size();j++) {
                LinkedHashMap<String, Integer> nowRoom = rooms.get(j);
                if (levelAvailable(l, nowRoom.values().iterator().next())) {
                    if (nowRoom.size() < m) {
                        nowRoom.put(n, l);
                        ok = true;
                        break;
                    }
                };
            }

            if (!ok) {
                rooms.add(new LinkedHashMap<>());
                rooms.get(rooms.size()-1).put(n, l);
            }
        }

        for (int i=0;i<rooms.size();i++) {
            LinkedHashMap<String, Integer> nowRoom = rooms.get(i);
            if (nowRoom.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            nowRoom.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getValue() + " " + entry.getKey()));
        }
    }

    static boolean levelAvailable(int player, int room) {
        return player <= room+10 && player >= room-10;
    }

}
