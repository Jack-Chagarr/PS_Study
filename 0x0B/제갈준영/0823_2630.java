import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pair count = numPapers(paper, n , 0, 0);
        System.out.println(count.m);
        System.out.println(count.n);



    }
    static pair numPapers(int[][] paper, int size, int x, int y){
        pair count = new pair(0, 0);
        if(size == 1){
            if(paper[y][x] == 0){
                return new pair(1, 0);
            }
            else{
                return new pair(0, 1);
            }
        }
        int same = 1;
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(paper[y][x] != paper[i][j]){
                    same = 0;
                    break;
                }
            }
        }

        if(same == 1){
            if(paper[y][x] == 0) return new pair(1, 0);
            else return new pair(0, 1);
        }

        count.m = numPapers(paper, size/2, x, y).m + numPapers(paper, size/2, x + size/2, y).m + numPapers(paper, size/2, x, y + size/2).m + numPapers(paper, size/2, x + size/2, y + size/2).m;

        count.n = numPapers(paper, size/2, x, y).n + numPapers(paper, size/2, x + size/2, y).n + numPapers(paper, size/2, x, y + size/2).n + numPapers(paper, size/2, x + size/2, y + size/2).n;
        return count;


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