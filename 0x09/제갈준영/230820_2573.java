import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int day = 0;
        LinkedList<pair> queue = new LinkedList<>();
        int[][] glacier = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                glacier[i][j] = Integer.parseInt(st.nextToken());
                if(glacier[i][j] > 0){
                    queue.offerFirst(new pair(i,j));
                }
            }
        }
        int glacierSize = queue.size();

        if(glacierSize == 0){
            System.out.println(day);
            return;
        }

        int num = 0;

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            LinkedList<Integer> subQueue = new LinkedList<>();
            if(num != 0){
                for(int i = 0; i < queueSize; i++){
                    pair p = queue.pollLast();
                    int meltingCount = 0;
                    if(p.m + 1 >= 0 && p.m + 1 < M && glacier[p.m + 1][p.n] == 0 ){
                        meltingCount++;
                    }
                    if(p.m - 1 >= 0 && p.m - 1 < M && glacier[p.m - 1][p.n] == 0 ){
                        meltingCount++;
                    }
                    if(p.n + 1 >= 0 && p.n + 1 < N && glacier[p.m][p.n+1] == 0 ){
                        meltingCount++;
                    }
                    if(p.n - 1 >= 0 && p.n - 1 < N && glacier[p.m][p.n-1] == 0 ){
                        meltingCount++;
                    }

                    queue.offerFirst(p);
                    subQueue.offerFirst(meltingCount);

                }
                for(int i = 0; i < queueSize; i++){
                    pair newP = queue.pollLast();
                    int newMeltingCount = subQueue.pollLast();
                    glacier[newP.m][newP.n] -= newMeltingCount;
                    if(glacier[newP.m][newP.n] <= 0) glacier[newP.m][newP.n] = 0;
                    else queue.offerFirst(newP);
                }
            }
            glacierSize = queue.size();
            if(queue.isEmpty()){
                day = 0;
                break;
            }
            LinkedList<pair> tempQueue = new LinkedList<>();
            tempQueue.offerFirst(queue.peek());
            int[][] visited = new int[M][N];
            visited[tempQueue.peekLast().m][tempQueue.peekLast().n] = 1;
            int tempGlacierSize = 1;

            while(!tempQueue.isEmpty()){
                pair p = tempQueue.pollLast();
                if(p.m + 1 >= 0 && p.m + 1 < M && glacier[p.m + 1][p.n] != 0 && visited[p.m + 1][p.n] == 0){
                    tempQueue.offerFirst(new pair(p.m+1, p.n));
                    visited[p.m+1][p.n] = 1;
                    tempGlacierSize++;
                }
                if(p.m - 1 >= 0 && p.m - 1 < M && glacier[p.m - 1][p.n] != 0 && visited[p.m - 1][p.n] == 0){
                    tempQueue.offerFirst(new pair(p.m-1, p.n));
                    visited[p.m-1][p.n] = 1;
                    tempGlacierSize++;
                }
                if(p.n + 1 >= 0 && p.n + 1 < N && glacier[p.m][p.n+1] != 0 && visited[p.m][p.n+1] == 0){
                    tempQueue.offerFirst(new pair(p.m, p.n+1));
                    visited[p.m][p.n+1] = 1;
                    tempGlacierSize++;
                }
                if(p.n - 1 >= 0 && p.n - 1 < N && glacier[p.m][p.n-1] != 0 && visited[p.m][p.n-1] == 0){
                    tempQueue.offerFirst(new pair(p.m, p.n-1));
                    visited[p.m][p.n-1] = 1;
                    tempGlacierSize++;
                }
            }

            if(tempGlacierSize != glacierSize){
                break;
            }
            day++;
            num++;

        }
        System.out.println(day);
        return;
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