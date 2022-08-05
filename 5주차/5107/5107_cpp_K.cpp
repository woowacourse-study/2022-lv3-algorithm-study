#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 2e1+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,a[MAX];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    for (int t = 1;; t++) {
        cin>>N;if(!N)break;
        map<string,int> m;
        bool vis[MAX]={false};
        int ans=0;
        fill(a,a+N,-1);
        for (int i = 0; i < N; i++) {
            string s1,s2;
            cin>>s1>>s2;
            m.insert({s1,sz(m)});
            m.insert({s2,sz(m)});
            a[m[s1]]=m[s2];
        }
        for (int i = 0; i < N; i++) {
            if(vis[i])continue;
            for (int j = i; !vis[j]; j=a[j]) {
                vis[j]=true;
            }
            ans++;
        }
        cout<<t<<" "<<ans<<"\n";
    }
}