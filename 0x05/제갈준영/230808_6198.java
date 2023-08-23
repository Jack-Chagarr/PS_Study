import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 값의 범위가 21억 이상이면 int가 아닌 long type을 선언해야 한다.
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        long answer = 0;
        while(i < n){
            int newBuildingHeight = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && stack.peek() <= newBuildingHeight){

                while(!stack.isEmpty() && stack.peek() <= newBuildingHeight){
                    stack.pop();
                    answer += stack.size();
                }

            }
            stack.push(newBuildingHeight);
            i++;
        }
        answer += stack.size() * (stack.size() - 1) / 2;

        System.out.println(answer);



        }
}
