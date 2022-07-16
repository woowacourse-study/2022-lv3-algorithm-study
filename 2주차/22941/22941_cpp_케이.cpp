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
int hi,ai,hm,am,P,S,hpi,hpm;
bool check(){
    if(hpm<=0){
        cout<<"Victory!";
        return true;
    }
    if(hpi<=0){
        cout<<"gg";
        return true;
    }
    return false;
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>>hi>>ai>>hm>>am>>P>>S;
    hpi=hi, hpm=hm;
    int cnti=max(0LL,(hm-P)/ai-1);
    int cntm=max(0LL,hi/am-1);
    int cnt = min(cnti,cntm);
    hpm-=ai*cnt;
    if(check())return 0;
    hpi-=am*cnt;
    if(check())return 0;
    while(hpm>P && hpi>0){
        hpm-=ai;
        if(check())return 0;
        hpi-=am;
        if(check())return 0;
    }
    if(hpm<=P)hpm+=S;
    cnti=max(0LL,hpm/ai-1);
    cntm=max(0LL,hpi/am-1);
    cnt=min(cnti,cntm);
    hpm-=ai*cnt;
    if(check())return 0;
    hpi-=am*cnt;
    if(check())return 0;
    while(hpm>0 && hpi>0){
        hpm-=ai;
        if(check())return 0;
        hpi-=am;
        if(check())return 0;
    }
}