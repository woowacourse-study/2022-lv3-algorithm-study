#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e3+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,m[MAX],vis[MAX][11];
vector<int> v[MAX];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    for (int i = 1; i <= N; i++) {
        cin>>m[i];
        v[i].resize(m[i]);
        for (int j = 0; j < m[i]; j++) {
            cin>>v[i][j];
        }
    }
    queue<pi> q;
    q.push({0,0});
    while(!q.empty()){
        int cur=q.front().first;
        int day=q.front().second;
        q.pop();
        if(day==N){
            vector<int> ans;
            for (int i = cur, j=0; j<N; i=vis[N-j][i], j++) {
                ans.push_back(i);
            }
            reverse(all(ans));
            for(auto i:ans){
                cout<<i<<"\n";
            }
            return 0;
        }
        for(auto i:v[day+1]){
            if(cur!=i&&!vis[day+1][i]){
                vis[day+1][i]=cur;
                q.push({i,day+1});
            }
        }
    }
    cout<<-1<<"\n";
}