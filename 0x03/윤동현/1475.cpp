#include <iostream>
using namespace std;
int N;
int ans = 0;
int a[10];
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    while(N){
        a[N%10]++;        //나머지
        N /= 10;          //몫
    }
    
    for(int i = 0; i<10;i++){
        if(i==6 || i==9) continue;
        ans = max(ans, a[i]);
    }
    ans = max(ans,(a[6]+a[9]+1)/2);
    cout << ans;
    return 0;
}