#include <iostream>
#include <vector>
using namespace std;
#define int long long int
#define double long double
#define P pair<long long int,long long int>
#define pb push_back
#define FOR(i,a,b,x) for(int i=(a); i<(b); i+=(x))

const int N=200000;
const int Q=200000;
vector<vector<int>> queries;
int parent[N+2];
int color[N]={};
int n,q;

int get_parent(int node)
{
    if(parent[node]==node)
        return node;
    return parent[node]=get_parent(parent[node]);
}

void solve()
{
    for(int i=q-1;i>=0;i--)
    {
        int l,r,c;
        l=queries[i][0];    r=queries[i][1];    c=queries[i][2];
        for(int j=get_parent(l);j<=r;j=get_parent(j))
        {
            color[j]=c;
            parent[j]=get_parent(j+1);
        }
    }
}


void memset()
{
    for(int i=0;i<N+2;i++)
        parent[i]=i;
}

int32_t main() 
{
	cin>>n; cin>>q;
	FOR(i,0,q,1)
	{
	    int a,b,c;
	    cin>>a; cin>>b; cin>>c;
	    vector<int> temp;
	    temp.pb(a); temp.pb(b); temp.pb(c);
	    queries.pb(temp);
	}
	memset();
	solve();
	FOR(i,1,n+1,1)
	    cout<<color[i]<<endl;
}

