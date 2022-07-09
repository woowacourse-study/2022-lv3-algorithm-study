// 220629 #17362 수학은 체육과목입니다 2
// math
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
int N;
int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    // 주기가 8이다.
    N%=8;
    // case_work
    if(!N)cout<<2;
    else if(N<=5)cout<<N;
    else cout<<10-N;
}