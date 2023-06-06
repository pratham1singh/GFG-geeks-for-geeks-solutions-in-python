//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    static Node pre,suc;
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
	            int k=Integer.parseInt(br.readLine());
        	    pre=null;
        	    suc=null;
                findPreSuc(root,k);
                if(pre!=null){
                    System.out.print(pre.data+" ");
                }else{
                    System.out.print("-1 ");
                }
                if(suc!=null){
                    System.out.println(suc.data);
                }else{
                    System.out.println("-1 ");
                }
        }
    }
  
// } Driver Code Ends



public static void in(Node root,ArrayList<Node> arr){
    if(root!=null){
        in(root.left,arr);
        arr.add(root);
        in(root.right,arr);
    }
}
public  static void findPreSuc(Node root, int key){
   pre=null;
   suc=null;
   ArrayList<Node> arr =new ArrayList<>();
   in(root,arr);
   int i;
   for(i=0;i<arr.size();i++)
       if(arr.get(i).data>key)
            break;
    if(i<arr.size())
        suc=arr.get(i);
    
    for(i=arr.size()-1;i>=0;i--)
       if(arr.get(i).data<key)
            break;
    if(i>=0)
        pre=arr.get(i);
   
    
}
}