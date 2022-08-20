#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e4+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,t,a[MAX],p[MAX];
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>t;
    while(t--){
        cin>>N;
        int ans=0;
        set<int> S;
        for (int i = 1; i <= N; i++) {
            cin>>a[i];
            p[i]=p[i-1]+a[i];
            S.insert(p[i]);
        }
        vector<int> v;
        for(int i=1;i<=sqrt(p[N]);i++){
            if((p[N]%i)==0){
                v.push_back(i);
                v.push_back(p[N]/i);
            }
        }
        sort(all(v));
        for (int i:v) {
            if(p[N]%i)continue;
            bool flag=true;
            for (int j = i; j <= p[N]; j+=i) {
                if(S.count(j)==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                cout<<i<<"\n";
                break;
            }
        }
    }
}