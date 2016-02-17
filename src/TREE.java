import java.io.*;
import java.util.*;
class Node
{
    public String keyData;             
    public int frequency;



    public Node leftChild;          

    public Node rightChild;          
    
    Node()
    {
    	frequency=1;
    }
}

class BinaryTree
{
   private Node root;               
   public BinaryTree()               
   {
        root = null;
   }
   public void traverse()
   {
	   preOrder(root);
   }
   private void preOrder(Node tempRoot)
   {
       if (tempRoot != null)
       {
           
           preOrder(tempRoot.leftChild);
           System.out.println("Word : "+tempRoot.keyData + " Frequency : " +tempRoot.frequency);
           preOrder(tempRoot.rightChild);
       }
   }
   public Node findMin()
   {
       Node current = root;
       while(current.leftChild != null)
           current = current.leftChild;
       return current;
   }
   public Node findMax()
   {
       Node current = root;
       while(current.rightChild != null)
           current = current.rightChild;
       return current;
   }

   public void insert(String key)
   {
       Node insertNode = new Node();       
       insertNode.keyData = key;


       if (root == null)            {    
           root = insertNode;
       }
       else
       {
           Node current = root;
           Node parent;


           while(true)
           {
               parent = current;       
               if (key.compareTo(current.keyData)<0)
               {
                   current = current.leftChild;
                   if (current == null)        // 현재 위치에 삽입 가능
                   {
                       parent.leftChild = insertNode;
                       return;
                   }
               }
               else if (key.compareTo(current.keyData)>0)
               {
                   current = current.rightChild;
                   if (current == null)        // 현재 위치에 삽입 가능
                   {
                       parent.rightChild = insertNode;
                       return;
                   }
               }else if(key.compareTo(current.keyData)==0)
               {
            	   current.keyData=key;
            	   current.frequency++;
            	   return;
               }
           }
       }
   }
 
   private Node getCandidate(Node deleteNode)
   {
       Node candidateParent = deleteNode;
       Node candidate = candidateParent.rightChild;

       while (candidate.leftChild != null)
       {
           candidateParent = candidate;
           candidate = candidate.leftChild;
       }

       if (candidate != deleteNode.rightChild)
       {
           candidateParent.leftChild = candidate.rightChild;
           candidate.rightChild = deleteNode.rightChild;
       }
       
       return candidate;
   }
}