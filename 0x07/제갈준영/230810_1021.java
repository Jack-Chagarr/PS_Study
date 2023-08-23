import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] targets = new int[m];
        for(int i = 0; i < m; i++){
            targets[i] = Integer.parseInt(input2[i]);
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 0; i < n; i++){
            deque.addLast(i+1);
        }
        //printQueue(deque);
        int i = 0;
        int count = 0;
        while(i < m){
            if(deque.indexOf(targets[i]) < (double)deque.size()/2){
                while(!deque.isEmpty() && deque.peek() != targets[i]){
                    deque.addLast(deque.pollFirst());
                    count++;
                }
                deque.pollFirst();
                i++;
            }else{
                while(!deque.isEmpty() && deque.peek() != targets[i]){
                    deque.addFirst(deque.pollLast());
                    count++;
                }
                deque.pollFirst();
                i++;
            }
        }
        System.out.println(count);
        return;
    }
    static void printQueue(Queue<Integer> queue){
        Iterator<Integer> iter = queue.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
