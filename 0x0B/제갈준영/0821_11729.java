import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        for(int i = 0; i < n; i++){
            count *= 2;
        }
        System.out.println(count - 1);
        hanoi(1, 2, 3, n);
        bw.flush();
        bw.close();

        return;
    }
    static void hanoi(int start, int pivot, int end, int n) throws IOException{

        if(n == 1){
            bw.write(start +" "+end + "\n");
            return;
        }
        hanoi(start, end, pivot, n - 1);
        bw.write(start + " " + end + "\n");

        hanoi(pivot, start, end, n - 1);
        return;
    }
}
