// 220629 #10814 나이 순 정렬
// sorting
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
vector<pair<int,pair<string,int>>> v;
// sorting settings
bool cmp(pair<int,pair<string,int>> p1, pair<int,pair<string,int>> p2) {
    if(p1.first==p2.first)return p1.second.second<p2.second.second;
    return p1.first<p2.first;
}
int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N;
    v.resize(N);
    for (int i = 0; i < N; i++) {
        cin>>v[i].first>>v[i].second.first;
        v[i].second.second=i;
    }
    // sort
    sort(all(v),cmp);
    for(auto i:v)cout<<i.first<<" "<<i.second.first<<"\n";
}