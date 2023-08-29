import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] numArr;
    static int N;
    static int M;
    static HashSet<Integer> hashSet = new HashSet<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[M];
        numArr = new int[N];
        for(int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);
        NM5(0, 0);
        System.out.println(sb);
        return;

    }
    static void NM5(int at, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }else{
            for(int i = 0; i < N; i++){
                if(hashSet.contains(numArr[i])) continue;
                arr[depth] = numArr[i];
                hashSet.add(numArr[i]);
                NM5(i + 1, depth + 1);
                hashSet.remove(numArr[i]);

            }
        }

    }
}


