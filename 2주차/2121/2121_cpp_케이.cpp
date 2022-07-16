#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 5e5+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,A,B,ans;
set<pi> S;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>A>>B;
    for (int i = 0; i < N; i++) {
        int a,b;
        cin>>a>>b;
        S.insert({a,b});
    }
    // map time performence < set time performence (set count: o(logN))
    for (auto it=S.begin();it!=S.end();it++) {
        ans+=S.count({it->first+A,it->second})&&S.count({it->first,it->second+B})
                &&S.count({it->first+A,it->second+B})?1:0;
    }
    cout<<ans;
}