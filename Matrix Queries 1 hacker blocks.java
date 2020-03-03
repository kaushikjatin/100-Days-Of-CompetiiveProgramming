import java.io.*;
import java.util.Scanner;

class matrix
{
    int a;
    int b;
    int c;
    int d;
    matrix(int a,int b,int c,int d)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
}

class Main
{
	public static void main (String[] args)
	{
	    Scanner scan=new Scanner(System.in);
	    int r,n,q;
	    r=scan.nextInt();
	    n=scan.nextInt();
	    q=scan.nextInt();
	    matrix values[]=new matrix[n];
	    matrix tree[]=new matrix[4*n-1];
	    for(int i=0;i<n;i++)
	    {
	        //System.out.println(i+" ");
	        int a,b,c,d;
	        a=scan.nextInt();
	        b=scan.nextInt();
	        c=scan.nextInt();
	        d=scan.nextInt();
	        scan.nextLine();
	        matrix temp=new matrix(a,b,c,d);
	        values[i]=temp;
	    }
	    
	    build_tree(values,0,n-1,0,tree,r);
	    // now we need to query the tree.....
	    for(int i=0;i<q;i++)
	    {
	        int L,R;
	        L=scan.nextInt();
	        R=scan.nextInt();
	        //System.out.print(L+" "+R+"bcjdbvv");
	        print_matrix(query_tree(tree,0,n-1,0,L-1,R-1,r));
	        System.out.println();
	        System.out.println();
	    }
	    
	}
	
	public static void print_matrix(matrix temp)
	{
	    System.out.print(temp.a+" ");
	    System.out.print(temp.b+" ");
	    System.out.println();
	    System.out.print(temp.c+" ");
	    System.out.print(temp.d+" ");
	}
	
	
	public static matrix query_tree(matrix tree[],int se,int ee,int root,int l,int r,int modulo)
	{
	    // if it is complete overlap...
	    if(l<=se && r>=ee)
	    {
	        return tree[root];
	    }
	    
	    
	    // if it a out_of bounds....
	    if(r<se || l>ee)
	    {
	        return new matrix(1,0,0,1);
	    }
	    
	    
	    // if it ia partial overlap...
	    matrix left=query_tree(tree,se,(se+ee)/2,2*root+1,l,r,modulo);
	    matrix right=query_tree(tree,(se+ee)/2 +1,ee,2*root+2,l,r,modulo);
	    return matrix_multiply(left,right,modulo);
	    
	}
	
	public static void build_tree(matrix values[],int se,int ee,int root,matrix tree[],int r)
	{
	    // if it a root node...
	    if(se==ee)
	    {
	        tree[root]=values[se];
	        return;
	    }
	    
	    // it means partial overlap...
	    build_tree(values,se,(se+ee)/2,2*root+1,tree,r);
	    build_tree(values,(se+ee)/2+1,ee,2*root+2,tree,r);
	    tree[root]=matrix_multiply(tree[2*root+1],tree[2*root+2],r);
	    return;
	}
	
	public static matrix matrix_multiply(matrix obj1,matrix obj2,int r)
	{
	    int a,b,c,d;
	    a=((obj1.a * obj2.a)%r + (obj1.b * obj2.c)%r)%r;
	    b=((obj1.a * obj2.b)%r + (obj1.b * obj2.d)%r)%r;
	    c=((obj1.c * obj2.a)%r + (obj1.d * obj2.c)%r)%r;
	    d=((obj1.c * obj2.b)%r + (obj1.d * obj2.d)%r)%r;
	    return new matrix(a,b,c,d);
	}
}