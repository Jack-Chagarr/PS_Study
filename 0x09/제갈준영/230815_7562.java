import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int l = Integer.parseInt(br.readLine());
            int[][] chessField = new int[l][l];
            int[][] visited = new int[l][l];
            String[] first = br.readLine().split(" ");
            String[] last = br.readLine().split(" ");
            chessField[Integer.parseInt(last[0])][Integer.parseInt(last[1])] = 1;

            LinkedList<pair> queue = new LinkedList<>();
            queue.offerFirst(new pair(Integer.parseInt(first[0]), Integer.parseInt(first[1])));
            visited[Integer.parseInt(first[0])][Integer.parseInt(first[1])] = 1;
            int count = 0;
            while(!queue.isEmpty() && visited[Integer.parseInt(last[0])][Integer.parseInt(last[1])] == 0){
                int len = queue.size();
                for(int k = 0; k < len; k++){
                    pair grid = queue.pollLast();
                    if(grid.m + 2 >= 0 && grid.m + 2 < l){
                        if(grid.n + 1 >= 0 && grid.n + 1 <l && visited[grid.m+2][grid.n+1] == 0){
                            queue.offerFirst(new pair(grid.m + 2, grid.n + 1));
                            visited[grid.m + 2][grid.n + 1] = 1;
                        }
                        if(grid.n - 1 >= 0 && grid.n - 1 <l && visited[grid.m+2][grid.n-1] == 0){
                            queue.offerFirst(new pair(grid.m + 2, grid.n - 1));
                            visited[grid.m + 2][grid.n - 1] = 1;
                        }

                    }
                    if(grid.m - 2 >= 0 && grid.m - 2 < l){
                        if(grid.n + 1 >= 0 && grid.n + 1 <l && visited[grid.m-2][grid.n+1] == 0){
                            queue.offerFirst(new pair(grid.m - 2, grid.n + 1));
                            visited[grid.m - 2][grid.n + 1] = 1;
                        }
                        if(grid.n - 1 >= 0 && grid.n - 1 <l && visited[grid.m-2][grid.n-1] == 0){
                            queue.offerFirst(new pair(grid.m - 2, grid.n - 1));
                            visited[grid.m - 2][grid.n - 1] = 1;
                        }
                    }
                    if(grid.n + 2 >= 0 && grid.n + 2 < l){
                        if(grid.m + 1 >= 0 && grid.m + 1 <l && visited[grid.m+1][grid.n+2] == 0){
                            queue.offerFirst(new pair(grid.m + 1, grid.n + 2));
                            visited[grid.m + 1][grid.n + 2] = 1;
                        }
                        if(grid.m - 1 >= 0 && grid.m - 1 <l && visited[grid.m-1][grid.n+2] == 0){
                            queue.offerFirst(new pair(grid.m - 1, grid.n + 2));
                            visited[grid.m - 1][grid.n + 2] = 1;
                        }
                    }
                    if(grid.n - 2 >= 0 && grid.n - 2 < l){
                        if(grid.m + 1 >= 0 && grid.m + 1 <l && visited[grid.m+1][grid.n-2] == 0){
                            queue.offerFirst(new pair(grid.m + 1, grid.n - 2));
                            visited[grid.m + 1][grid.n - 2] = 1;
                        }
                        if(grid.m - 1 >= 0 && grid.m - 1 <l && visited[grid.m-1][grid.n-2] == 0){
                            queue.offerFirst(new pair(grid.m - 1, grid.n - 2));
                            visited[grid.m - 1][grid.n - 2] = 1;
                        }
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