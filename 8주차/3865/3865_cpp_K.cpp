#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 2e3+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,ans=0;
vector<int> v[MAX];
bool vis[MAX];
void dfs(int cur){
    vis[cur]=true;
    if(sz(v[cur])==0){
        ans++;
        return;
    }
    for(auto i:v[cur]){
        if(!vis[i]){
            dfs(i);
        }
    }
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    while(cin>>N){
        if(!N)break;
        map<string,int> m;
        ans=0;
        for (int i = 0; i < N*15; i++) {
            v[i].clear();
            vis[i]=false;
        }
        string s;
        for (int i = 0; i < N; i++) {
            cin>>s;
            string k,group;
            int g;
            for (int j = 0; j < sz(s); j++) {
                if(s[j]==':'){
                    m.insert({k,sz(m)});
                    g=m[k];
                    k="";
                    continue;
                }
                if(s[j]==','||s[j]=='.'){
                    m.insert({k,sz(m)});
                    v[g].push_back(m[k]);
                    k="";
                    continue;
                }
                k+=s[j];
            }
        }
        dfs(0);
        cout<<ans<<"\n";
    }
}