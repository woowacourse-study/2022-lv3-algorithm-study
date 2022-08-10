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
int N,M,K,ans;
bool cmp(pi p1, pi p2){
    if(p1.second==p2.second)return p1.first>p2.first;
    return p1.second>p2.second;
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>M>>K;
    vector<pi> v(N);
    for (int i = 0; i < N; i++) {
        cin>>v[i].first>>v[i].second;
    }
    sort(all(v),cmp);
    priority_queue<int,vector<int>,greater<int>> pq;
    for (int i = 0; i < M+K; i++) {
        ans+=v[i].first;
        if(i>=K)pq.push(v[i].first);
    }
    for (int i = M+K; i < N; i++) {
        if(pq.top()<v[i].first){
            ans+=v[i].first-pq.top();
            pq.pop();
            pq.push(v[i].first);
        }
    }
    cout<<ans;
}