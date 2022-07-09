// 220630 #14659 한조서열정리하고옴ㅋㅋ
// implementation, sliding_window
// O(N)
#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
typedef pair<ll, ll> pl;
const int MAX = 3e4+7;
const int INF = 0x3f3f3f3f;
const ll LNF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int n,k,m,cnt,ans;
int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>n;
    for (int i = 0; i < n; i++) {
        cin>>k;
        if(m<k){
            m=k;
            ans=max(ans,cnt);
            cnt=0;
            continue;
        }
        cnt++;
    }
    cout<<max(ans,cnt);
}