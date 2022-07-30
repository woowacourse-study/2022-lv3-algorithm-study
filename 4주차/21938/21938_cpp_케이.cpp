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
int N,M,ans=INF,a[MAX][MAX*3],T,b[MAX][MAX],p[MAX*MAX];
bool vis[MAX*MAX];
int dx[4]={0,0,-1,1};
int dy[4]={-1,1,0,0};
// DSU
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
    cin>>N>>M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                cin>>a[i][j*3+k];
            }
        }
    }
    cin>>T;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int n=a[i][j*3]+a[i][j*3+1]+a[i][j*3+2];
            if(n>=T*3)b[i][j]=1;
            if(b[i][j])p[i*M+j+1]=i*M+j+1;  // make two dimension array to one dimension parent array
            else p[i*M+j+1]=-1;
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 4; k++) {
                int nx=j+dx[k];
                int ny=i+dy[k];
                if(nx>=0&&ny>=0&&nx<M&&ny<N&&b[ny][nx]){
                    if(p[i*M+j+1]==-1)continue;
                    if(p[ny*M+nx+1]==-1)continue;
                    merge(i*M+j+1,ny*M+nx+1);
                }
            }
        }
    }
    set<int> S;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            // final result: not parent array, but return find to ancestor parent
            if(p[i*M+j+1]!=-1)S.insert(find(i*M+j+1));
        }
    }
    cout<<sz(S);
}