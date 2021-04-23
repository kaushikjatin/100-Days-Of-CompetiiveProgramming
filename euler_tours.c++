// euler tour1 --> node at every edge occrus twice;
// euler tour2 --> every node occurs twice; (Time-In and time-out values are useful)
// euler tour3 --> every node oocurs; (Time-In and time-out values are useful)

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define int long long int
#define double long double
#define P pair<int,int>
#define pb push_back
#define FOR(i,a,b,x) for(int i=(a); i<(b); i+=(x))

const int N=100005; 
int n;

vector<int> graph[N];
int tin[N],tout[N];
int timer=0;

void sc()
{
    cin>>n;
    FOR(i,0,n-1,1)
    {
        int a,b;
        cin>>a; cin>>b;
        graph[a].pb(b);
        graph[b].pb(a);
    }
}

void euler_tour1(int node,int par)
{
    cout<<node<<" ";
    for(auto x:graph[node])
        if(x!=par)
        {
            euler_tour1(x,node);
            cout<<node<<" ";   
        }
    return;
}

void euler_tour2(int node,int par)
{
    cout<<node<<" ";
    tin[node]=++timer;
    for(auto x:graph[node])
        if(x!=par)
            euler_tour2(x,node);
    tout[node]=++timer;
    cout<<node<<" ";
}

void euler_tour3(int node,int par)
{
    cout<<node<<" ";
    for(auto x:graph[node])
        if(x!=par)
            euler_tour3(x,node);
}

bool is_ancestor(int x,int y)
{
    return (tin[x]<=tin[y] && tout[x]>=tout[y]);
}


int32_t main()
{
    sc();
    euler_tour1(1,-1);
    cout<<endl;
    euler_tour2(1,-1);
    cout<<endl;
    euler_tour3(1,-1);
    cout<<endl;
    cout<<is_ancestor(1,8); // is a ancestor of b
}

// 9
// 1 2
// 2 4
// 2 5
// 2 6
// 1 3
// 3 7
// 7 8
// 7 9
