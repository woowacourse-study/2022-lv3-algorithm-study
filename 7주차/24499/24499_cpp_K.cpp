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
int N,K,a[MAX],p[MAX],ans;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>K;
    for (int i = 1; i <= N; i++) {
        cin >> a[i];
        a[i + N] = a[i];
    }
    for (int i = 1; i < N+K; i++) {
        p[i]=p[i-1]+a[i];
    }
    for (int i = 0; i < N; i++) {
        ans=max(ans,p[i+K]-p[i]);
    }
    cout<<ans;
}