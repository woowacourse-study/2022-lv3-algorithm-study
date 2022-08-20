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
int A,B,C;
vector<int> v[3];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>A>>B>>C;
    int k,ans=INF;
    for (int i = 0; i < A; i++) {
        cin>>k;
        v[0].push_back(k);
    }
    for (int i = 0; i < B; i++) {
        cin>>k;
        v[1].push_back(k);
    }
    for (int i = 0; i < C; i++) {
        cin>>k;
        v[2].push_back(k);
    }
    for (int i = 0; i < 3; i++) {
        sort(all(v[i]));
    }
    for (int i = 0; i < A; i++) {
        auto b=lower_bound(all(v[1]),v[0][i]);
        auto c=lower_bound(all(v[2]),v[0][i]);
        if(b!=v[1].end() && c!=v[2].end())ans=min(ans,max(*b,*c)-v[0][i]);
    }
    for (int i = 0; i < B; i++) {
        auto a=lower_bound(all(v[0]),v[1][i]);
        auto c=lower_bound(all(v[2]),v[1][i]);
        if(a!=v[0].end() && c!=v[2].end())ans=min(ans,max(*a,*c)-v[1][i]);
    }
    for (int i = 0; i < C; i++) {
        auto b=lower_bound(all(v[1]),v[2][i]);
        auto a=lower_bound(all(v[0]),v[2][i]);
        if(b!=v[1].end() && a!=v[0].end())ans=min(ans,max(*b,*a)-v[2][i]);
    }
    cout<<ans;
}