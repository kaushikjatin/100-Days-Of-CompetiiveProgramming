import java.util.*;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
class Solution 
{
    static class pair 
    {
        int node;
        int weight;
        pair(int a,int b)
        {
            node=a;
            weight=b;
        }
    }
    
    
    
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
  
    
    static int no_child[];
    static boolean visited[];
    static ArrayList<ArrayList<pair>> graph;
    static int n;
    static long ans;
    
    
	public static void main (String[] args) throws IOException 
	{
		Reader scan=new Reader(); 
		int t=scan.nextInt();
		for(int p=1;p<=t;p++)
		{
		    scantheinput(scan);
		    ans=0;
		    dodfs(0);
		    System.out.println("Case #"+p+": "+ans);
		}
	}
	
	
	public static int dodfs(int node)
	{
	    visited[node]=true;
	    for(int i=0;i<graph.get(node).size();i++)
	    {
	        if(!visited[graph.get(node).get(i).node])
	        {
	            int temp=dodfs(graph.get(node).get(i).node);
	            no_child[node]+=temp;
	            ans+=2*graph.get(node).get(i).weight*Math.min(temp,n-temp);
	        }
	    }
	    return no_child[node];
	}
	
	public static void scantheinput(Reader scan) throws IOException 
	{
	    graph=new ArrayList<>();
	    n=scan.nextInt();
	    for(int i=0;i<n;i++)
	         graph.add(new ArrayList<pair>());
	         
	    for(int i=0;i<n-1;i++)
	    {
	        int n1,n2,w;
	        n1=scan.nextInt();  n2=scan.nextInt();   w=scan.nextInt();
	        graph.get(n1-1).add(new pair(n2-1,w));
	        graph.get(n2-1).add(new pair(n1-1,w));
	    }
	    
	    no_child=new int[n];
	    visited=new boolean[n];
	    for(int i=0;i<n;i++)
	      no_child[i]=1;
	    for(int i=0;i<n;i++)
	      visited[i]=false;
	    
	}
}