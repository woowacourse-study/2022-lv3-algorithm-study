#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e2+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,K,a[MAX];
bool vis[MAX];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>K;
    for (int i = 1; i <= N; i++) {
        cin>>a[i];
    }
    int cnt,res=0;
    for (cnt = 0; res < N; ++cnt) {
        int n=0,idx=0;
        for (int j = 1; j <= N; j++) {
            if(vis[j])continue;
            if(idx<j&&n<a[j]){
                idx=j;
                n=a[j];
                res++;
                vis[j]=true;
            }
        }
    }
    cout<<(cnt<=K?"YES":"NO")<<"\n";
}