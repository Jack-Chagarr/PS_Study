import java.io.*;
import java.util.Stack;

// String을 자주 변경할 경우 StringBuilber/StringBuffer를 사용 https://ifuwanna.tistory.com/221

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int number = 1;
        int i = 0;
        while(i < n){
            if(!stack.isEmpty() && arr[i] == stack.peek()){
                stack.pop();
                i++;
                answer.append('-').append('\n');
                //System.out.println(answer);
            }else if(arr[i] >= number){
                stack.push(number);
                number++;
                answer.append('+').append('\n');
                //System.out.println(answer);
            }else {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }
        //answer.deleteCharAt(-1);
        System.out.println(answer);


        return;

    }
}
