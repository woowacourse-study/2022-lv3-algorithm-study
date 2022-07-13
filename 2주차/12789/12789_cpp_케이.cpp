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
int N,k=1;
vector<int> v;  // 대기열
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    for (int i = 0; i < N; i++) {
        int n;cin>>n;
        // 들어갈 차례보다 차례가 이후면
        if(k<n){
            // 대기열 왼쪽에 들어갈 사람이 있다면 다 보내줌.
            while(!v.empty() && v.back()==k){
                v.pop_back();
                k++;
            }
            // 대기열에 들어가세요
            v.push_back(n);
            continue;
        }
        // 들어갈 차례면 다음 사람으로 인덱싱 즞ㅇ가
        else if(k==n)k++;
        else break;
    }
    // 대기열 남아있는 사람 중 차례에 해당되는 사람들 있다면 비워줌
    while(!v.empty()){
        if(k++==v.back())v.pop_back();
        else break;
    }
    cout<<(v.empty()?"Nice":"Sad");
}