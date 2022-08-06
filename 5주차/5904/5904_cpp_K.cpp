#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 2e5+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,ans,M,m;
vector<int> v;
char dfs(int cur){
    if(cur<=3){
        return cur==1?'m':'o';
    }
    M=v.back();
    v.pop_back();
    m=v.back();
    if(cur<=m) {
        return dfs(cur);
    }
    else if(cur>m&&cur<=M-m){
        return cur-m==1?'m':'o';
    }
    else{
        return dfs(cur-(M-m));
    }
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    v.push_back(0);
    v.push_back(3);
    v.push_back(10);
    while(v.back()<N){
        int k=v.back();
        v.push_back(k*2+sz(v)+2);
    }
    cout<<dfs(N);
}