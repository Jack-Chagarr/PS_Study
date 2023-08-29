import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        nm(1, 0);
        System.out.println(sb);

        return;
    }
    static void nm(int at, int depth) throws IOException{
        if (depth == M) {

            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;

        }else{
            for(int i = at; i <= N ; i++){
                arr[depth] = i;
                nm(i + 1, depth + 1);
            }
        }
    }
}
