import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            //System.out.println(i);
            String func = br.readLine();
            //System.out.println(func);
            char[] funcArr = func.toCharArray();
            int p = Integer.parseInt(br.readLine());
            //System.out.println(p);
            String num = br.readLine();
            if(num.equals("[]")){
                num = "";
            }else{
                num = num.replace("[", "").replace("]","");
            }

            LinkedList<Integer> deque = new LinkedList<>();
            if (num != "") {
                String[] numArr = num.split(",");
                for(int j = 0; j < numArr.length; j++){
                    deque.offerLast(Integer.parseInt(numArr[j]));
                }
            }
            //System.out.println("hi");
            int reverse = 0;
            int error = 0;
            for(char f : funcArr){
                //System.out.println(f);
                if(f == 'R'){
                    reverse = (reverse + 1)%2;
                }else if(f == 'D'){
                    if(deque.isEmpty()){
                        System.out.println("error");
                        error = 1;
                        break;
                    }else{
                        if(reverse == 0) deque.pollFirst();
                        else deque.pollLast();
                    }
                }

            }
            if(error == 0){
                bw.write("[");
                if(reverse == 0){
                    while(!deque.isEmpty()){
                        bw.write(deque.pollFirst().toString());
                        if(!deque.isEmpty()) bw.write(",");
                    }
                }else{
                    while(!deque.isEmpty()){
                        bw.write(deque.pollLast().toString());
                        if(!deque.isEmpty()) bw.write(",");
                    }
                }
                bw.write("]\n");
                bw.flush();
            }

        }
        bw.close();

        return;

    }

}
