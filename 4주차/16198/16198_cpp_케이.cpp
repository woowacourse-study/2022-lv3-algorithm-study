#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e1+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,a[MAX],ans;
vector<pi> idx; // Linked_List
bool vis[MAX];
void solve(int cnt, int w){
    if(cnt==N-2){
        ans=max(ans,w);
        return;
    }
    for (int i = 0; i < N; i++) {
        int l=idx[i].first;
        int r=idx[i].second;
        if(l!=-1&&r!=N){
            pi tmp={idx[r].first, idx[l].second};
            pi now=idx[i];
            idx[l].second=idx[i].second;
            idx[r].first=idx[i].first;  // index change
            idx[i]={-1,-1};
            solve(cnt+1,w+a[l]*a[r]);
            idx[i]=now;
            idx[l].second=tmp.second;   // index restoration
            idx[r].first=tmp.first;
        }
    }
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    idx.resize(N+2);
    fill(vis,vis+N,false);
    for (int i = 0; i < N; i++) {
        cin>>a[i];
        idx[i].first=i-1;
        idx[i].second=i+1;
    }
    solve(0,0);
    cout<<ans;
}