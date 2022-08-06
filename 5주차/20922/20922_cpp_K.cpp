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
int N,K,v[MAX],ans,cnt;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>K;
    for (int i = 0; i < N; i++) {
        cin>>v[i];
    }
    int idx = 0;
    map<int,int> m;
    for (int i = 0; i < N; i++) {
        m[v[i]]++;
        if (m[v[i]] > K) {
            ans = max(ans, cnt);
            for (int j = idx; j <= i; j++) {
                m[v[j]]--;
                if (m[v[i]] <= K) {
                    i = j;
                    idx = j + 1;
                    m.clear();
                    cnt = 0;
                    break;
                }
            }
        }
        else {
            cnt++;
        }
    }
    ans = max(ans, cnt);
    cout << ans << "\n";
}