#include <iostream>
#include <bits/stdc++.h>
#include <cmath>
#include <vector>
using namespace std;
#define int long long int
#define double long double
#define P pair<long long int,long long int>
#define pb push_back
#define FOR(i,a,b,x) for(int i=(a); i<(b); i+=(x))


int n,e,m;
// n= no of vertice;    e=no of edges   m=no_of_column in sparse matrix.
vector<vector<int>> graph;
vector<int>p_2;
vector<int> parent;
vector<int> depth;
vector<vector<int>> sparse;
void scan_and_memset()
{
    cin>>n; m=ceil(log2(n))+1;
    cin>>e;
    graph.resize(n+1);
    p_2.resize(n+1);
    parent.resize(n+1);
    sparse.resize(n+1);
    depth.resize(n+1);
    FOR(i,0,n+1,1)
        sparse[i].resize(m);
    FOR(i,0,e,1)
    {
        int a,b;
        cin>>a; cin>>b;
        graph[a].pb(b); graph[b].pb(a);
    }
    p_2[1]=0;
    p_2[0]=0;
    FOR(i,2,n+1,1) p_2[i]=p_2[i/2]+1;
}

void dfs(int node,int par)
{
    parent[node]=par;
    for(auto child:graph[node])
        if(child!=par)
        {
            depth[child]=depth[node]+1;
            dfs(child,node);
        }
}

void pre_computations() // pre-computed the sparse table
{
    FOR(j,0,m,1)
        FOR(i,1,n+1,1)
        {
            if(j==0)
                sparse[i][j]=parent[i];
            else if(depth[i]<(1<<j))
                continue;
            else 
                sparse[i][j]=sparse[sparse[i][j-1]][j-1];
        }
}

int common_parent(int x,int y) // this computer common parent when x and y are at same level.
{
    int p2_value=p_2[depth[x]];
    while(p2_value>=0)
    {
        if(sparse[x][p2_value]!=sparse[y][p2_value])
        {
            x=sparse[x][p2_value];  
            y=sparse[y][p2_value];
        }
        p2_value--;
    }
    return parent[x];
}

int parent_at_level(int node,int level) // computer parent of provided node at this level
{
    if(level==0)
        return node;
    if(level==1)
        return parent[node];
    int p2_value=p_2[level];
    return parent_at_level(sparse[node][p2_value],level-(1<<p2_value));
}

int solve(int x,int y) // returns LCA of x and y in log(n) time complexity
{
    if(depth[x]>depth[y])
        return solve(y,x);
    // depth of x is always less than depth of y 
    if(depth[x]==depth[y])
        return common_parent(x,y);
    int parent_y=parent_at_level(y,depth[y]-depth[x]);
    if(parent_y==x) // x is ancestor of y;
        return x;
    return common_parent(x,parent_y);
}

int32_t main() 
{
    scan_and_memset();	
    dfs(1,-1);
    pre_computations();
    int t;
    cin>>t;
    while(t--!=0)
    {
        int x,y;
        cin>>x; cin>>y;
        cout<<solve(x,y)<<endl;
    }
}