/*
 
 NAME:           SHARVARI SONKUSARE

 CNUM:           C22019221458
 ASSIGNMENT:     3
 ROLL NO.:       2459
 
 
 PROBLEM STATEMENT: Create a reasonably balanced tree to maintain names and
telephone numbers of all the customers of a shopkeeper
and perform operations on it. 
Test your program for at least 10 names.


 */




package avlTree;
import java.util.*;

class node
{
	node lc,rc;
	String name;
	String telephone;
	int h;

public node(String n,String t) { //parameterized constructor of class node

	name=n;
	telephone=t;
	lc=rc=null;
	h=0;
	}
public node() {
	
	lc=rc=null;
	h=0;
	
}
}

class avlTree{
	node root;
	
	public avlTree(){
		root=null;
		}


int height(node root) {           //TIME COMPLEXITY=O(N)
// height to calculate balance factor of tree

	if (root == null)
        return 0;

    return root.h;
	
}


int max(int a, int b) {        //TIME COMPLEXITY=O(1)
	//to find maximum height
  return (a > b) ? a : b;
}




int balanceFactor(node ptr) {          //TIME COMPLEXITY=O(N)    
//finding balance factor

	  if (root == null)
          return 0;

      return height(ptr.lc) - height(ptr.rc);
	
}


node LL(node ptr){                     //TIME COMPLEXITY=O(1)
	
	node R=ptr.lc;
	ptr.lc=R.rc;
	R.rc=ptr;

    //  Update heights
    ptr.h = max(height(ptr.lc), height(ptr.rc)) + 1;
 
    // Return new root
    return R;
}

node RR(node ptr) {                  //TIME COMPLEXITY=O(1)
	
	node L=ptr.rc;
	ptr.rc=L.lc;
	L.lc=ptr;
	
      //updating heights
	  ptr.h = max(height(ptr.lc), height(ptr.rc)) + 1;
	  
	  return L;
	}



node LR(node root)                      //TIME COMPLEXITY=O(1)
{
root.lc=RR(root.lc);
return LL(root);
}


node RL(node root)                    //TIME COMPLEXITY=O(1)
{
root.rc=LL(root.rc);
return RR(root);
}


node insert(node m,String name,String n)             //TIME COMPLEXITY=O(LOG N)
{
	
    if (m == null) {
    	m=new node(name,n);      //normal bst insertion when no node present
    }

    
    else if ((m.name).compareTo(name)>0) { 
    	//using compareTo method to compare strings and to arrange names lexicographically 
    	
        m.lc = insert(m.lc, name,n);
        if(balanceFactor(m)==2) {          //unbalanced state
        	
        	//LL
        	if((m.lc.name).compareTo(name)>0) {
        		m=LL(m);

        	}
        	    
        	//LR
        	else {              
        		  m=LR(m);
        	}
        	
        }
    }

        else if((m.name).compareTo(name)<0) {              
        	
            m.rc = insert(m.rc, name,n);
            if(balanceFactor(m)==-2) {
        	
        	//RR
        	if((m.rc.name).compareTo(name)<0) {
        		m= RR(m);
        	}
        	
        	//LR
        	else { 
        		  m= RL(m);
        	}
        	
        }

        
    }
        else {
        	System.out.println("DUPLICATES NOT ALLOWED");   
        	// if the element is already present in the tree, we will do nothing   
        }    
    
    //updating height
    m.h = max( height(m.lc), height(m.rc) ) + 1; 
    return m;
	
}


void create() {                                   //TIME COMPLEXITY=O(LOG N)
//Accept general information form customer

	Scanner scan=new Scanner(System.in);
	String name, telephone;
	
	System.out.println("Enter the name: ");
	name=scan.next();
	System.out.println("Enter the telephone number: ");
	telephone=scan.next();

	root=insert(root,name,telephone);
}

    //inorder display
void recursiveInorder(node lRoot) {       //TIME COMPLEXITY: O(N)
	if (lRoot == null)
		return;

	// first recur on left child 
	recursiveInorder(lRoot.lc);

	// then print the data of node 
	System.out.print(""+lRoot.name + "\t"+lRoot.telephone+"\n");

	// now recur on right child 
	recursiveInorder(lRoot.rc);
}

void recursiveInorder() {	 
	recursiveInorder(root); }	
}



public class Avl{
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		avlTree avl=new avlTree();
		int no;
		do{
			System.out.println("\n*********************");
			System.out.println("MENU:\n1.ACCEPT\n2.DISPLAY\n3.EXIT ");
			System.out.println("*********************");
			System.out.println("Enter your choice: ");
			no=sc.nextInt();
			switch(no){
			
			case 1:
				avl.create();
			break;
			
			case 2:
				System.out.println("NAME\t"+"NUMBER");
				avl.recursiveInorder();
			break;
			
			case 3:
			break;
			
			default:
				System.out.println("INVALID CHOICE!");
			break;
				
			}
			}while(no!=3);
		}
	}


/*
 
 OUTPUT:
 
 
*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
KIA
Enter the telephone number: 
989967546

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
JOON
Enter the telephone number: 
234567890

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
KELLY
Enter the telephone number: 
123456789

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
KRYSTAL
Enter the telephone number: 
987654321

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
ZIYA
Enter the telephone number: 
432156789

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
AMY
Enter the telephone number: 
765432190

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
ANA
Enter the telephone number: 
999871234

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
ALEX
Enter the telephone number: 
556789123

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
NIA
Enter the telephone number: 
332195678

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
ZON
Enter the telephone number: 
367812239

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
1
Enter the name: 
JUNE
Enter the telephone number: 
667234510

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
2
NAME	NUMBER
ALEX	556789123
AMY	    765432190
ANA	    999871234
JOON	234567890
JUNE	667234510
KELLY	123456789
KIA	    989967546
KRYSTAL	987654321
NIA	    332195678
ZIYA	432156789
ZON	    367812239

*********************
MENU:
1.ACCEPT
2.DISPLAY
3.EXIT 
*********************
Enter your choice: 
3

*/
 


