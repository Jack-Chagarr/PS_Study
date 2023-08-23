#include <stdcpp.h>
using namespace std;
#define X first
#define Y second 


int N,M;
string board [102];
int vis [102][102];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
queue<pair<int,int> > Q;


int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> M;
  for (int i = 0;i < N; i++){
      cin >> board [i];
  }
  //1. (0,0)에서 시작
  Q.push(make_pair(0,0)); //큐에 (0,0) 넣기
  vis[0][0] = 1;
  while(!Q.empty()){
    pair<int,int> cur = Q.front();
    Q.pop();

    for(int dir = 0; dir < 4; dir ++){
        int nx= cur.X + dx[dir];
        int ny= cur.Y + dy[dir];
        if (nx<0 || nx >= N || ny<0 || ny >= M) continue;   //보드판을 벗어나면 가지마라
        if (vis[nx][ny] != 0 || board[nx][ny] != '1') continue; //이미 갔던 곳이거나 갈 수 없는 곳이면 가지마라
        vis[nx][ny] = vis[cur.X][cur.Y]+1;
        Q.push(make_pair(nx,ny));
    }
  }
  cout << vis[N-1][M-1];
  return 0;
}