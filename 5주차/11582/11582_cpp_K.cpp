#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e6+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,K;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    vector<int> v(N);
    for (int i = 0; i < N; i++) {
        cin>>v[i];
    }
    cin>>K;
    int n=N/K,idx=0;
    for (int i = 0; i < N; i+=n) {
        sort(v.begin()+idx*n,v.begin()+(idx+1)*n);
        idx++;
    }
    for(auto i:v)cout<<i<<" ";
}