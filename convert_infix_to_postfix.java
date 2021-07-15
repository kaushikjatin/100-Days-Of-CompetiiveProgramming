class Solution
{
    static Stack<Character> stack;
    static String ans;
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String exp) 
	{
		// Your code here
		stack=new Stack<>();
		ans="";
		for(int i=0;i<exp.length();i++){
		    char c=exp.charAt(i);
		    if(c=='(')
		        stack.push(c);
		    else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
		        handle_operator(c);
		    else if(c==')')
    		    handle_paranthesis(c);
		    else 
		        ans+=c;
		      
		}
		while(stack.size()!=0)
		    ans+=stack.pop();
		return ans;
	} 
	
	public static void handle_paranthesis(char c){
	   while(stack.peek()!='(')
	    ans+=stack.pop();
	   stack.pop();
	}
	
	public static void handle_operator(char c){
	        if(stack.size()==0 || stack.peek()=='(')
	            stack.push(c);
	        else 
	        {
	            while(stack.size()!=0 && precedence(c)<=precedence(stack.peek()))
	                ans+=stack.pop();
	           stack.push(c);
	        }
	   }
	   
	   public static int precedence(char c)
	   {
	    switch (c)
	    {
	        case '+':
	        case '-':
	            return 0;
	        case '*':
	        case '/':
	            return 1;
	       case '^':
	           return 2;
	    }
	    return -1;
	   }
	
	}
	