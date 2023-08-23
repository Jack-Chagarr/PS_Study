import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            LinkedList<pair> fireQueue = new LinkedList<>();
            LinkedList<pair> userQueue = new LinkedList<>();
            int[][] userVisited = new int[h][w];
            int[][] fireVisited = new int[h][w];
            int count = 0;

            char[][] building = new char[h][w];
            for(int j = 0; j < h; j++){
                building[j] = br.readLine().toCharArray();
                for(int k = 0; k < w; k++){
                    if(building[j][k] == '*'){
                        fireQueue.offerFirst(new pair(j, k));
                        fireVisited[j][k] = 1;
                    }
                    if(building[j][k] == '@'){
                        userQueue.offerFirst(new pair(j, k));
                        userVisited[j][k] = 1;
                    }
                }
            }

            int finished = 0;
            while(!userQueue.isEmpty() && finished == 0){
                int fireQueueSize = fireQueue.size();
                for(int j = 0; j < fireQueueSize; j++){
                    pair gridFire = fireQueue.pollLast();
                    if(gridFire.m + 1 >= 0 && gridFire.m + 1 < h && (building[gridFire.m + 1][gridFire.n] == '.' || building[gridFire.m + 1][gridFire.n] == '@') && fireVisited[gridFire.m+1][gridFire.n] == 0 ){
                        fireQueue.offerFirst(new pair(gridFire.m+1, gridFire.n));
                        fireVisited[gridFire.m+1][gridFire.n] = 1;
                    }
                    if(gridFire.m - 1 >= 0 && gridFire.m - 1 < h && (building[gridFire.m - 1][gridFire.n] == '.' || building[gridFire.m - 1][gridFire.n] == '@') && fireVisited[gridFire.m-1][gridFire.n] == 0 ){
                        fireQueue.offerFirst(new pair(gridFire.m-1, gridFire.n));
                        fireVisited[gridFire.m-1][gridFire.n] = 1;
                    }
                    if(gridFire.n + 1 >= 0 && gridFire.n + 1 < w && (building[gridFire.m][gridFire.n + 1] == '.' || building[gridFire.m][gridFire.n + 1] == '@') && fireVisited[gridFire.m][gridFire.n + 1] == 0 ){
                        fireQueue.offerFirst(new pair(gridFire.m, gridFire.n + 1));
                        fireVisited[gridFire.m][gridFire.n + 1] = 1;
                    }
                    if(gridFire.n - 1 >= 0 && gridFire.n - 1 < w && (building[gridFire.m][gridFire.n - 1] == '.' || building[gridFire.m][gridFire.n - 1] == '@') && fireVisited[gridFire.m][gridFire.n - 1] == 0 ){
                        fireQueue.offerFirst(new pair(gridFire.m, gridFire.n - 1));
                        fireVisited[gridFire.m][gridFire.n - 1] = 1;
                    }
                }


                count++;
                int userQueueSize = userQueue.size();
                for(int k = 0; k < userQueueSize; k++) {
                    pair gridUser = userQueue.pollLast();
                    if(gridUser.m == h-1 || gridUser.n == w-1 || gridUser.m == 0 || gridUser.n == 0){
                        System.out.println(count);
                        finished = 1;
                        break;
                    }
                    if (gridUser.m + 1 >= 0 && gridUser.m + 1 < h && building[gridUser.m + 1][gridUser.n] == '.' && userVisited[gridUser.m + 1][gridUser.n] == 0 && fireVisited[gridUser.m + 1][gridUser.n] == 0) {
                        userQueue.offerFirst(new pair(gridUser.m + 1, gridUser.n));
                        userVisited[gridUser.m + 1][gridUser.n] = 1;
                    }
                    if (gridUser.m - 1 >= 0 && gridUser.m - 1 < h && building[gridUser.m - 1][gridUser.n] == '.' && userVisited[gridUser.m - 1][gridUser.n] == 0 && fireVisited[gridUser.m - 1][gridUser.n] == 0) {
                        userQueue.offerFirst(new pair(gridUser.m - 1, gridUser.n));
                        userVisited[gridUser.m - 1][gridUser.n] = 1;
                    }
                    if (gridUser.n + 1 >= 0 && gridUser.n + 1 < w && building[gridUser.m][gridUser.n + 1] == '.' && userVisited[gridUser.m][gridUser.n + 1] == 0 && fireVisited[gridUser.m][gridUser.n + 1] == 0) {
                        userQueue.offerFirst(new pair(gridUser.m, gridUser.n + 1));
                        userVisited[gridUser.m][gridUser.n + 1] = 1;
                    }
                    if (gridUser.n - 1 >= 0 && gridUser.n - 1 < w && building[gridUser.m][gridUser.n - 1] == '.' && userVisited[gridUser.m][gridUser.n - 1] == 0 && fireVisited[gridUser.m][gridUser.n - 1] == 0) {
                        userQueue.offerFirst(new pair(gridUser.m, gridUser.n - 1));
                        userVisited[gridUser.m][gridUser.n - 1] = 1;
                    }
                }

            }
            if(finished == 0){
                System.out.println("IMPOSSIBLE");
            }

        }
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