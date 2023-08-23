#include <stdcpp.h> //자주 쓰는 헤더파일 선언
using namespace std;
int N,x,a[10005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> x;
    for(int i=0; i<N ; i++) cin >> a[i];
    for(int i=0; i<N ; i++)
        if(a[i]<x) cout << a[i] <<' ';  
}
