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
int N,ans;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    vector<int> v;
    for (int i = 0; i < N; i++) {
        int n; cin>>n;
        while(!v.empty()&&v.back()<=n){
            v.pop_back();
        }
        ans+=sz(v);
        v.push_back(n);
    }
    cout<<ans;
}