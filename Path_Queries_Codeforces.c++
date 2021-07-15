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

struct less_mag : public binary_function<pair<int,P>, pair<int,P>, bool> {
    bool operator()(pair<int,P> a, pair<int,P> b)
    {
        if(a.first<b.first)
            return true;
        else if(a.first==b.first)
        {
            if(a.second.first<b.second.first)
                return true;
            else if(a.second.first==b.second.first)
                return a.second.second<b.second.second;
        }
        return false;
    }
};


int n,q;
vector<pair<int,P>> graph;
vector<int> parent;
vector<int> component_size;
vector<int> stepwise_ans;
int ans=0;
void scan_and_memset()
{
    cin>>n; cin>>q;
    parent.resize(n+1);
    component_size.resize(n+1);
    FOR(i,1,n,1)
    {
        int a,b,c;
        cin>>a; cin>>b; cin>>c;
        graph.pb({c,{a,b}});
    }
    FOR(i,1,n+1,1)
    {
        parent[i]=i;
        component_size[i]=1;
    }
        
    sort(graph.begin(),graph.end(),less_mag());
    
}
int sup_parent(int node)
{
    if(parent[node]==node)
        return node;
    return parent[node]=sup_parent(parent[node]);
}

void solve()
{
   for(auto connection:graph)
   {
       int a,b,w;
       w=connection.first;  a=connection.second.first;  b=connection.second.second;
       int sup_a=sup_parent(a);
       int sup_b=sup_parent(b);
       if(sup_a==sup_b)
        continue;
       ans+=component_size[sup_a]*component_size[sup_b];
       component_size[sup_a]+=component_size[sup_b];
       parent[sup_b]=sup_a;
       stepwise_ans.pb(ans);
   }
}

void process_queries()
{
    FOR(i,0,q,1)
    {
        int w;
        cin>>w;
        auto itr=upper_bound(graph.begin(),graph.end(),make_pair(w,make_pair(LLONG_MAX,LLONG_MAX)),less_mag());
        int length=itr-graph.begin();
        if(length==0)
            cout<<0<<" ";
        else 
            cout<<stepwise_ans[length-1]<<" ";
    }
}

int32_t main() 
{
    scan_and_memset();
    solve();
    process_queries();
}