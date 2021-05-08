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

int n,q,k;
vector<vector<int>> graph;
vector<int> visited,parent,tin,tout;
int timer=0;

void scan_and_memset()
{
    cin>>n; cin>>q;
    graph.resize(n+1);
    visited.resize(n+1);
    parent.resize(n+1);
    tin.resize(n+1);
    tout.resize(n+1);
    FOR(i,1,n,1)
    {
        int a,b;
        cin>>a; cin>>b;
        graph[a].pb(b); graph[b].pb(a);
    }
    
}

void dfs(int node,int par)
{
    visited[node]=1;
    parent[node]=par;
    tin[node]=timer++;
    for(auto child:graph[node])
    {
        if(!visited[child])
        {
            dfs(child,node);
        }
    }
    tout[node]=timer++;
}

bool solve_query(int arr[])
{
    int deepest=-1,depth=-1;
    FOR(i,0,k,1)
    {
        arr[i]=parent[arr[i]];
        if(tin[arr[i]]>depth)
        {
            depth=tin[arr[i]];
            deepest=arr[i];
        }
    }
    
    FOR(i,0,k,1)
    {
        int x=arr[i];
        if(!(tin[x]<=tin[deepest] && tout[x]>=tout[deepest]))
            return false;
    }
        
    return true;
}

void preocess_queries()
{
    FOR(i,0,q,1)
    {
        cin>>k;
        int arr[k];
        FOR(j,0,k,1)
            cin>>arr[j];
        if(solve_query(arr))
            cout<<"YES"<<endl;
        else 
            cout<<"NO"<<endl;
    }
}

int32_t main() 
{
    scan_and_memset();   
    dfs(1,1);
    preocess_queries();
}