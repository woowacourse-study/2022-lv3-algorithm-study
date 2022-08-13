#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 100+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,M,R,d[MAX][MAX],a[MAX];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>M>>R;
    memset(d,INF,sizeof(d));
    for (int i = 1; i <= N; i++) {
        cin>>a[i];
        d[i][i]=0;
    }
    while(R--){
        int n1,n2,cost;
        cin>>n1>>n2>>cost;
        d[n1][n2]=d[n2][n1]=cost;
    }
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            for (int k = 1; k <= N; k++) {
                d[j][k]=min(d[j][i]+d[i][k], d[j][k]);
            }
        }
    }
    int ans=0;
    for (int i = 1; i <= N; i++) {
        int ret=0;
        for (int j = 1; j <= N; j++) {
            if(d[i][j]<=M)ret+=a[j];
        }
        ans=max(ans,ret);
    }
    cout<<ans;
}