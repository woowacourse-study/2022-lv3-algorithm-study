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
int T,N,M,d[MAX],p[MAX];
vector<pi> v[MAX];
int dijkstra(int s, int e){
    priority_queue<pi, vector<pi>, greater<pi>> pq;
    pq.push({ 0,s });
    fill(d, d + MAX, INF);
    d[s] = 0;
    while (!pq.empty()) {
        int cost = pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        if (d[cur] < cost)
            continue;
        for (auto i : v[cur]) {
            int next = i.second;
            int nCost = i.first + cost;
            if (nCost < d[next]) {
                d[next] = nCost;
                p[next]=cur;
                pq.push({ nCost, next });
            }
        }
    }
    return d[e];
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>T;
    for (int t = 1; t <= T; t++) {
        for (int i = 0; i < M; i++) {
            v[i].clear();
            p[i]=-1;
        }
        cin>>N>>M;
        for (int i = 0; i < N; i++) {
            int n1,n2,cost;
            cin>>n1>>n2>>cost;
            v[n1].push_back({cost,n2});
            v[n2].push_back({cost,n1});
        }
        int dis=dijkstra(0,M-1);
        cout<<"Case #"<<t<<": ";
        if(dis==INF){
            cout<<-1<<"\n";
            continue;
        }
        vector<int> ans;
        for (int i = M-1;; i=p[i]) {
            ans.push_back(i);
            if(!i)break;
        }
        reverse(all(ans));
        for(auto i:ans){
            cout<<i<<" ";
        }
        cout<<"\n";
    }
}