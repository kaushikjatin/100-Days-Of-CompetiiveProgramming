class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        int se=0,ee=0;
        int ans=0;
        int flipped=0;
        // inital state and it's values have been found and ans too...
        while(ee<n){
            
            // trying to go to a new state
            if(arr[ee]==1)
                ee++;
            else if(arr[ee]==0 && flipped<m)
            {
                ee++;
                flipped++;
            }
            else if(arr[ee]==0 && flipped>=m)
                while(flipped>=m)
                {
                    if(arr[se]==0)
                        flipped--;
                    se++;
                }
                // reached a new state
                ans=Math.max(ans,ee-se);
            // values have been found of that new state
        }
        return ans;
    }
}