// the graph in this code must be having a single connected componenet.

#include <iostream>
#include <bits/stdc++.h>
#include <cmath>
#include <vector>
using namespace std;
#define int long long int
#define double long double
#define P pair<int,int>
#define pb push_back
#define FOR(i,a,b,x) for(int i=(a); i<(b); i+=(x))

int n,e;
vector<vector<int>> graph;
vector<int> low,dis,visited;
vector<P> bridges;
vector<int> art_pnt;
void scan_and_memset()
{
    cin>>n; cin>>e;
    graph.resize(n+1);
    FOR(i,0,e,1)
    {
        int a,b;
        cin>>a; cin>>b;
        graph[a].pb(b); graph[b].pb(a);
    }
    low.resize(n+1);  dis.resize(n+1);  visited.resize(n+1);
}

void dfs(int node,int dis_time,int par)
{
    dis[node]=dis_time;
    int num_child=0;
    visited[node]=1;
    low[node]=LLONG_MAX;
    for(auto child:graph[node])
    {
        if(!visited[child])
        {
            num_child++;
            dfs(child,dis_time+1,node)
            low[node]=min(low[node],low[child]);
            // art_pnt
            if(low[child]>=dis[node])
                art_pnt.pb(node);
            // art_bridge 
            if(low[child]>dis[node])
                bridges.pb({node,child});
        }
        else if(child!=par)//backedge
           low[node]=min(low[node],dis[child]);
    }
    if(num_child>=2 && par==-1) // this case is when the root is itselt articulation point
        art_pnt.pb(node);
    return false;
}

int32_t main()
{
    scan_and_memset();
    dfs(1,1,-1);
    for(auto x:art_pnt)
        cout<<x<<" ";
    cout<<endl<<"BRIDGES"<<endl;
    for(auto x:bridges)
        cout<<x.first<<" "<<x.second<<endl;
}

// 8 9
// 1 2
// 1 3
// 2 4
// 2 5
// 4 5
// 3 6
// 6 7
// 6 8
// 3 7