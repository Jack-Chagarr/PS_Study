import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num_testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < num_testcase; i++){
            String[] MNK = br.readLine().split(" ");
            int M = Integer.parseInt(MNK[0]);
            int N = Integer.parseInt(MNK[1]);
            int K = Integer.parseInt(MNK[2]);
            int[][] cabbageField = new int[M][N];
            int[][] visited = new int[M][N];
            pair[] pairs = new pair[K];
            int count = 0;
            for(int j = 0; j < K; j++){
                String[] mn = br.readLine().split(" ");
                pairs[j] = new pair(Integer.parseInt(mn[0]), Integer.parseInt(mn[1]));
                cabbageField[pairs[j].m][pairs[j].n] = 1;
            }
            LinkedList<pair> queue = new LinkedList();
            for(int k = 0; k < K; k++){
                if(visited[pairs[k].m][pairs[k].n] == 0){
                    queue.offerFirst(pairs[k]);
                    visited[pairs[k].m][pairs[k].n] = 1;
                }else continue;
                while(!queue.isEmpty()){
                    pair p = queue.pollLast();
                    if(p.m + 1 >= 0 && p.m + 1 < M && cabbageField[p.m + 1][p.n]== 1 && visited[p.m + 1][p.n] == 0 ){
                        queue.offerFirst(new pair(p.m + 1, p.n));
                        visited[p.m+1][p.n] = 1;
                    }
                    if(p.m -1 >= 0 && p.m - 1 < M && cabbageField[p.m - 1][p.n]== 1 && visited[p.m - 1][p.n] == 0 ){
                        queue.offerFirst(new pair(p.m - 1, p.n));
                        visited[p.m-1][p.n] = 1;
                    }
                    if(p.n + 1 >= 0 && p.n + 1 < N && cabbageField[p.m][p.n + 1]== 1 && visited[p.m][p.n + 1] == 0 ){
                        queue.offerFirst(new pair(p.m, p.n + 1));
                        visited[p.m][p.n+1] = 1;
                    }
                    if(p.n -1 >= 0 && p.n - 1 < N && cabbageField[p.m][p.n - 1]== 1 && visited[p.m][p.n - 1] == 0 ){
                        queue.offerFirst(new pair(p.m, p.n - 1));
                        visited[p.m][p.n - 1] = 1;
                    }
                }
                count++;
            }
            System.out.println(count);


        }



    }
}
class pair {
    int m;
    int n;
    pair(int m, int n){
        this.m = m;
        this.n = n;
    }
}
