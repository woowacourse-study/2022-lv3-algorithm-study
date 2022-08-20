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
int N;
bool isSlump(string s){
    if(sz(s)<2)return false;
    if(s[0]!='D'&&s[0]!='E')return false;
    int idx=1;
    while(s[idx++]=='F');
    --idx;
    if(idx==sz(s)-1&&s[idx]=='G')return true;
    return isSlump(s.substr(idx));
}
bool isSlimp(string s){
    if(sz(s)<2)return false;
    if(s[0]!='A')return false;
    if(sz(s)==2)return s=="AH";
    bool flag= isSlimp(s.substr(2, sz(s)-3));
    if(flag&&s[1]=='B'&&s[sz(s)-1]=='C')return true;
    flag= isSlump(s.substr(1,sz(s)-2));
    return flag&&s[sz(s)-1]=='C';
}
int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    cout<<"SLURPYS OUTPUT\n";
    cin>>N;
    while(N--){
        string s;
        cin>>s;
        bool flag=false;
        for (int i = 2; i < sz(s); i++) {
            string s1=s.substr(0,i);
            string s2=s.substr(i);
            if(isSlimp(s1)&& isSlump(s2)){
                flag=true;
                break;
            }
        }
        cout<<(flag?"YES":"NO")<<"\n";
    }
    cout<<"END OF OUTPUT\n";
}