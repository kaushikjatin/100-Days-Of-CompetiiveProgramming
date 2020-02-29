import java.io.*;
import java.util.*;
import java.util.HashMap;
class Main 
{
	public static void main (String[] args) 
	{
	    Scanner scan=new Scanner(System.in);
	   HashMap<Character,ArrayList<String>> map=new HashMap<>();
	   System.out.println("Enter all no of productions");
	   int n=scan.nextInt();
	   scan.nextLine();
	   while(n--!=0)
	   {
	       char c=scan.next().charAt(0);
	       String s=scan.next();
	       if(s.charAt(0)==' ')
	       {
	           s="";
	       }
	       if(map.containsKey(c))
	       {
	           map.get(c).add(s);
	       }
	       else 
	       {
	           ArrayList<String> temp=new ArrayList<>();
	           temp.add(s);
	           map.put(c,temp);
	       }
	   }
	   ArrayList<String> temp=new ArrayList<>();
	   temp.add("");
	   map.put('[',temp);
	   // upto now we have just taken all the productions in account.....
	   scan.nextLine();
	   String to_be_checked=scan.nextLine();
	   System.out.println(can_be_made_or_not(to_be_checked,map,"S",0));
	   
	}
	
	public static boolean can_be_made_or_not(String to_be_checked , HashMap<Character,ArrayList<String>> map , String till_now , int len_till_now)
	{
	    if(till_now.equals(to_be_checked))
	    {
	        
	        return true;
	    }
	    if(len_till_now>to_be_checked.length())
	    {
	        
	        return false;
	    }
	    int i=0;
	    while(i<till_now.length()&&(till_now.charAt(i)>91 || till_now.charAt(i) < 65))
	    {
	        i++;
	    }
	    if(i==till_now.length())
	    {
	        
	        return false;
	    }
	    map.get(till_now.charAt(i)).size();
	    for(int j=0;j<map.get(till_now.charAt(i)).size();j++)
	    {
	        int new_length=find_length(len_till_now,map.get(till_now.charAt(i)).get(j));
	        String new_string=till_now.substring(0,i)+map.get(till_now.charAt(i)).get(j)+till_now.substring(i+1);
	        if(can_be_made_or_not(to_be_checked,map,new_string,new_length))
	        {
	            return true;
	        }
	    }
	    
	    return false;
	}
	
	public static int find_length(int x,String str)
	{
	   
	    for(int i=0;i<str.length();i++)
	    {
	        if((str.charAt(i)<65 || str.charAt(i)>91))
	        {
	            x++;
	         }
	    }
	    return x;
	}
}




// input type.......
/*
5
S aSb
S A
A ABa
A [
B [
ab
*/