import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] numArr;
    static int N;
    static int M;
    static HashMap<Integer, Integer> hashMap= new HashMap<>();
    static HashMap<Integer, Integer> sameNumHashMap= new HashMap<>();
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
        for(int i = 0; i < N-1; i++){
            if(numArr[i] == numArr[i+1]){
                if(!sameNumHashMap.containsKey(numArr[i])) sameNumHashMap.put(numArr[i], 2);
                else sameNumHashMap.replace(numArr[i], sameNumHashMap.get(numArr[i]) + 1);
            }
        }
        //System.out.println(sameNumHashMap.toString());
        NM8(0, 0);
        System.out.println(sb);
        return;

    }
    static void NM8(int at, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }else{
            for(int i = 0; i < N; i++){
                if(i > 0 && numArr[i] == numArr[i-1]) continue;
                if(hashMap.containsKey(numArr[i]) && !sameNumHashMap.containsKey(numArr[i])) continue;
                arr[depth] = numArr[i];
                if(sameNumHashMap.containsKey(numArr[i]) && hashMap.containsKey(numArr[i])) {
                    if (hashMap.get(numArr[i]) < sameNumHashMap.get(numArr[i]))
                        hashMap.replace(numArr[i], hashMap.get(numArr[i]) + 1);
                    else continue;
                } else hashMap.put(numArr[i],1);
                NM8(i + 1 , depth + 1);
                if(sameNumHashMap.containsKey(numArr[i])){
                    hashMap.replace(numArr[i], hashMap.get(numArr[i]) - 1);
                }else hashMap.remove(numArr[i]);

            }
        }

    }
}



