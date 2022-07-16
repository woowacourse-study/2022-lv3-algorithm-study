// 요세푸스 문제 0
// queue
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
int N,K;
queue<int> q;
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>K;
    for (int i = 1; i <= N; i++) {
        q.push(i);
    }
    cout<<"<";
    while(!q.empty()) {
        // queue를 이용한 O(NK)
        for (int i = 0; i < K-1; i++) {
            int k=q.front();
            // front를 pop해주고, 다시 맨 뒤에 넣어줌.
            q.pop();
            q.push(k);
        }
        // 맨 마지막 원소는 ", " 적용 X
        cout<<q.front()<<(q.size()!=1?", ":"");
        // 해당 원소는 아예 큐에서 빼버리기
        q.pop();
    }
    cout<<">";
}