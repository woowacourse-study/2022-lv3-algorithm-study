#include <bits/stdc++.h>
#define sz(v) (int)v.size()
#define int long long
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef pair<int, int> pi;
typedef pair<int,pi> pii;
const int MAX = 1e5+7;
const int INF = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int N,M,S,E,p[MAX];
vector<pii> v;
bool cmp(pii p1,pii p2){
    return p1.first>p2.first;
}
int find(int a) {
	if (a == p[a])
		return a;
	return p[a] = find(p[a]);
}
bool merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)
		return false;
    if (a > b)
        swap(a,b);
	p[b] = a;
	return true;
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>N>>M>>S>>E;
    for (int i = 1; i <= N; i++) {
        p[i]=i;
    }
    for (int i = 0; i < M; i++) {
        int n1,n2,cost;
        cin>>n1>>n2>>cost;
        v.push_back({cost,{n1,n2}});
    }
    sort(all(v),cmp);
    int ans=INF;
    for (int i = 0; i < sz(v); i++) {
        int n1=v[i].second.first;
        int n2=v[i].second.second;
        int cost=v[i].first;
        if(find(n1)!=find(n2)){
            merge(n1,n2);
            ans=min(ans,cost);
        }
        if(find(S)==find(E))break;
    }
    cout<<(find(S)!=find(E)?0:ans);
}