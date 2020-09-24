import java.util.*;
public class multiplicative_inverse_by_Extended_euclid 
{
    static int x,y;
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t--!=0)
        {
            int n,m;
            n=scan.nextInt();   m=scan.nextInt();
            // find multiplicative inverse of n wrt. m
            // solve for nx + my =1;
            // find for integral x
            find_inverse(n,m);
            System.out.println((x+m)%m);
        }
        return;
    }


    public static void find_inverse(int A,int B)
    {
        if(B==0)
        {   x=1;y=0;}
        else 
        {
            find_inverse(B, A%B);
            int tempx,tempy;
            tempx=y;
            tempy=(x-(A/B)*y);
            x=tempx;
            y=tempy;
        }
    }
}