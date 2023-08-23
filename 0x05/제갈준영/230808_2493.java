import java.io.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Stack;

public class Main {
    static class KeyValue{
        int key = 0;
        int value = 0;
        KeyValue(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] answerArr = new int[n];
        int i = n-1;
        Stack<KeyValue> stack = new Stack<>();
        stack.push(new KeyValue(i, Integer.parseInt(arr[i])));
        i--;

        while(i >= 0){
            while(!stack.isEmpty() && stack.peek().value < Integer.parseInt(arr[i])){
                KeyValue keyValue = stack.pop();
                answerArr[keyValue.key] = i+1;
            }
            stack.push(new KeyValue(i, Integer.parseInt(arr[i])));
            i--;

        }
        for(int k = 0; k < n; k++){
            sb.append(answerArr[k]).append(" ");
        }
        System.out.println(sb);
        return;

    }
}
