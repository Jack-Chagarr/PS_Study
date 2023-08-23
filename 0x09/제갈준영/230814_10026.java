import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class RedGreen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        int[][] visited_nonWeak = new int[n][n];
        int[][] visited_weak = new int[n][n];

        int colorWeak = 0;
        int non_colorWeak = 0;
        for(int i = 0; i < n; i++){
            grid[i] = br.readLine().toCharArray();
        }
        LinkedList<pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited_nonWeak[i][j] == 0){
                    queue.offerFirst(new pair(i,j));
                    visited_nonWeak[i][j] = 1;
                }else continue;
                while(!queue.isEmpty()){
                    pair p = queue.pollLast();
                    if(p.m + 1 >= 0 && p.m + 1 < n && grid[p.m][p.n] == grid[p.m+1][p.n] && visited_nonWeak[p.m+1][p.n] == 0){
                        queue.offerFirst(new pair(p.m+1,p.n));
                        visited_nonWeak[p.m+1][p.n] = 1;
                    }
                    if(p.m - 1 >= 0 && p.m - 1 < n && grid[p.m][p.n] == grid[p.m-1][p.n] && visited_nonWeak[p.m-1][p.n] == 0){
                        queue.offerFirst(new pair(p.m-1,p.n));
                        visited_nonWeak[p.m-1][p.n] = 1;
                    }
                    if(p.n + 1 >= 0 && p.n + 1 < n && grid[p.m][p.n] == grid[p.m][p.n+1] && visited_nonWeak[p.m][p.n+1] == 0){
                        queue.offerFirst(new pair(p.m,p.n+1));
                        visited_nonWeak[p.m][p.n+1] = 1;
                    }
                    if(p.n - 1 >= 0 && p.n - 1 < n && grid[p.m][p.n] == grid[p.m][p.n-1] && visited_nonWeak[p.m][p.n-1] == 0){
                        queue.offerFirst(new pair(p.m,p.n-1));
                        visited_nonWeak[p.m][p.n-1] = 1;
                    }
                }
                non_colorWeak ++;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'R') grid[i][j] = 'G';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited_weak[i][j] == 0){
                    queue.offerFirst(new pair(i,j));
                    visited_weak[i][j] = 1;
                }else continue;
                while(!queue.isEmpty()){
                    pair p = queue.pollLast();
                    if(p.m + 1 >= 0 && p.m + 1 < n && grid[p.m][p.n] == grid[p.m+1][p.n] && visited_weak[p.m+1][p.n] == 0){
                        queue.offerFirst(new pair(p.m+1,p.n));
                        visited_weak[p.m+1][p.n] = 1;
                    }
                    if(p.m - 1 >= 0 && p.m - 1 < n && grid[p.m][p.n] == grid[p.m-1][p.n] && visited_weak[p.m-1][p.n] == 0){
                        queue.offerFirst(new pair(p.m-1,p.n));
                        visited_weak[p.m-1][p.n] = 1;
                    }
                    if(p.n + 1 >= 0 && p.n + 1 < n && grid[p.m][p.n] == grid[p.m][p.n+1] && visited_weak[p.m][p.n+1] == 0){
                        queue.offerFirst(new pair(p.m,p.n+1));
                        visited_weak[p.m][p.n+1] = 1;
                    }
                    if(p.n - 1 >= 0 && p.n - 1 < n && grid[p.m][p.n] == grid[p.m][p.n-1] && visited_weak[p.m][p.n-1] == 0){
                        queue.offerFirst(new pair(p.m,p.n-1));
                        visited_weak[p.m][p.n-1] = 1;
                    }
                }
                colorWeak ++;
            }
        }
        System.out.println(non_colorWeak + " " + colorWeak);




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