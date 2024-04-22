import java.util.Stack;

/**
* This class contains the main methods and the other methods that compute the expressions
*
* CSC 1351 Lab 9
* Section 2
*
* @author John Holcomb
* @since 4/19/24
*
*/
public class Stacks {
	/**
	* Main method, which prints the outputs of the called methods
	*
	* CSC 1351 Lab 9
	* Section 2
	*
	* @author John Holcomb
	* @since 4/19/24
	*
	*/
    public static void main(String[] args) throws Exception {
        System.out.println(isBalancedExpression("{}"));
        System.out.println(isBalancedExpression("({({)})}"));
        System.out.println(isBalancedExpression("({})"));

        System.out.println(evaluateExpression("5 4 5 * + 5 /"));
        System.out.println(evaluateExpression("4 5 + 7 2 - *")); 
    }
    
    /**
	* Takes in a string and returns whether the expression is a palindrome or not
	*
	* CSC 1351 Lab 9
	* Section 2
	*
	* @author John Holcomb
	* @since 4/19/24
	*
	*/
    public static boolean isBalancedExpression(String s) {
    	Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
    
    /**
	* Evaluates string given in postfix notation and returns the result of the expression
	*
	* CSC 1351 Lab 9
	* Section 2
	*
	* @author John Holcomb
	* @since 4/19/24
	*
	*/
    public static double evaluateExpression(String ee) {
    	//create a stack
        Stack<Integer> stack = new Stack<>();
         
        // Scan all characters one by one
        for(int i = 0; i < ee.length(); i++)
        {
            char c = ee.charAt(i);
             
            if(c == ' ') {
            	continue;
            } else if (Character.isDigit(c)) {
                int n = 0;
                 
                while(Character.isDigit(c))
                {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = ee.charAt(i);
                }
                
                stack.push(n);
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c) {
                    case '+':stack.push(val2+val1);break;
                    case '-':stack.push(val2- val1);break;
                    case '/': stack.push(val2/val1);break;
                    case '*':stack.push(val2*val1);break;
                }
            }
        }
        return stack.pop();
    }
}
