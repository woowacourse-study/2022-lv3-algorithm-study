#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 30+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,t;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        int ans=0,vis[MAX],d[MAX];
        for (int i = 0; i < sz(s); i++) {
            vis[i]=0;d[i]=0;
            if(s[i]=='1')d[i]=1;
        }
        for (int i = 0; i < sz(s); i++) {
            if(d[i]!=vis[i]){
                ans+=pow(2,sz(s)-i-1);
                vis[i]=(vis[i]+1)%2;
                vis[i+1]=(vis[i+1]+1)%2;
            }
        }
        cout<<ans<<"\n";
    }
}