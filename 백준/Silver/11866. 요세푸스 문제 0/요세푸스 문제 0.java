import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        
        Circle list = new Circle();
        for (int i=1;i<=n;i++) {
            list.add(i);
        }

        bw.write("<");
        list.deleteKthNode(k, bw);
        bw.write(">");
        bw.flush();
        br.close();
        bw.close();
    }

    public static class Circle {
        private Node head;
        private Node tail;
        private Node current;

        private class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                tail.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
        }

        public void deleteKthNode(int k, BufferedWriter bw) throws IOException {
            if (isEmpty() || k <= 0) return;

            current = head;
            Node prev = tail;

            while (head != tail) {
                for (int i=1;i<k;i++) {
                    prev = current;
                    current = current.next;
                }
                bw.write(current.data + ", ");
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                current = current.next;
            }
            bw.write(current.data + "");
        }
    }
}
