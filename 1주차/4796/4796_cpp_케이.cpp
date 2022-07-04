// 220630 #4796 캠핑
// greedy
#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
typedef pair<ll, ll> pl;
const int MAX = 53;
const int INF = 0x3f3f3f3f;
const ll LNF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int l,p,v;
int main() {
    cin.tie(0)->sync_with_stdio(0);
    for (int t=1;;t++) {
        cin>>l>>p>>v;
        if(!l&&!p&&!v)break;
        // 사용할 수 있는 만큼 최대한 사용하는 게 답
        cout<<"Case "<<t<<": "<<(v/p)*l+max(l,v%p)<<"\n";
    }
}