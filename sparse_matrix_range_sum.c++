#include <iostream>
#include <cmath>
#include <vector>
using namespace std;
#define int long long int
#define double long double
#define P pair<long long int,long long int>
#define pb push_back
#define FOR(i,a,b,x) for(int i=(a); i<(b); i+=(x))

int n,m,t;
vector<int>p_2;
vector<int> arr;
vector<vector<int>> matrix;
void memset_and_scan_vaues()
{
    // scanned_all_values
    cin>>n;
	m=ceil(log2(n))+1;
	arr.resize(n);
	FOR(i,0,n,1)cin>>arr[i];
	cin>>t;
	
	//resized_arrays_and_filled_them
    p_2.resize(n+1);
    matrix.resize(n);
    FOR(i,0,n,1)matrix[i].resize(m);
    p_2[1]=0;
    p_2[0]=0;
    FOR(i,2,n+1,1) p_2[i]=p_2[i/2]+1;
}

void fill_matrix()
{
    FOR(j,0,m,1)
        FOR(i,0,n,1)
        {
            if(j==0)
                matrix[i][j]=arr[i];
            else if(i+(1<<j)-1 >=n)
                break;
            else 
            {
                int a,b,c,d;
                int length=1<<j;
                a=i;    b=j-1;  c=(i+length-1)-(1<<(j-1))+1;    d=j-1;
                matrix[i][j]=matrix[a][b]+matrix[c][d];
            }
            //cout<<matrix[i][j]<<" ";
        }
}

int solve(int l,int r)
{
    if(l>r)
        return 0;
    if(l==r)
        return arr[l];
    int length=r-l+1;
    int p2_value=p_2[length];
    int ans=matrix[l][p2_value]+solve(l+(1<<p2_value),r);
    return ans;
}

int32_t main() 
{
	// sparse_matrix_code
	memset_and_scan_vaues();
	fill_matrix();
	FOR(i,0,t,1)
	{
	    int l,r;
	    cin>>l; cin>>r;
	    cout<<solve(l,r)<<endl;
	}
}