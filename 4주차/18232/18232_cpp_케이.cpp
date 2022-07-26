#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 3e5+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,M,ans=INF,S,E;
vector<int> v[MAX];
bool vis[MAX];
void bfs(){
    queue<pi> q;
    q.push({0,S});
    vis[S]=true;
    while(!q.empty()){
        int cur=q.front().second;
        int cost=q.front().first;
        q.pop();
        if(cur==E){
            ans=min(ans,cost);
            continue;
        }
        for(auto i:v[cur]){
            if(!vis[i]){
                vis[i]=true;
                q.push({cost+1,i});
            }
        }
        if(cur-1>=1&&!vis[cur-1]){
            vis[cur-1]=true;
            q.push({cost+1,cur-1});
        }
        if(cur+1<=N&&!vis[cur+1]){
            vis[cur+1]=true;
            q.push({cost+1,cur+1});
        }
    }
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>M>>S>>E;
    for (int i = 0; i < M; i++) {
        int n1,n2;
        cin>>n1>>n2;
        v[n1].push_back(n2);
        v[n2].push_back(n1);
    }
    bfs();  // shortest_path : bfs (weight is equal)
    cout<<ans;
}