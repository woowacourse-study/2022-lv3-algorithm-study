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
int t,N,K,ans=1;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>t;
    while(t--){
        int l=0,r=0;
        bool flag=false;
        for (int i = 1,j=0; j<27; i++) {
            int k;cin>>k;
            j+=k;
            if(i%2==0){
                l+=k;
            }else{
                r+=k;
            }
            if(!flag&&i%2==0&&ans<=13&&l>=ans){
                ans=r+ans;
                flag=true;
            }
            else if(!flag&&i%2&&ans>13&&r>=ans-13){
                ans=ans-13+l;
                flag=true;
            }
        }
    }
    cout<<ans;
}