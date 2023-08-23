import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("push")){
                int element = Integer.parseInt(input[1]);
                queue.offer(element);
                //bw.write(element + "\n");
            }else if(input[0].equals("pop")){
                if(!queue.isEmpty()){
                    int element = queue.peek();
                    bw.write(element + "\n");
                    queue.poll();
                }else bw.write(-1 + "\n");

            }else if(input[0].equals("front")){
                if(!queue.isEmpty()) bw.write(queue.peek() + "\n");
                else bw.write(-1 + "\n");
            }else if(input[0].equals("back")){
                if(!queue.isEmpty()){
                    int element = queue.getLast();
                    bw.write(element + "\n");
                }else bw.write(-1 + "\n");

            }else if(input[0].equals("empty")){
                if(queue.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }else if(input[0].equals("size")) {
                bw.write(queue.size() + "\n");
            }
        }
        bw.flush();
        bw.close();
        return;




    }
}
