// Creates the Binary Seach Tree Class for other files to use
// Bee Rigg, Compiled Arpil 13th
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.io.Serializable;
public class BST implements Serializable {
	private Person root;

	public void insert(Person p){
		if (root == null){
			root = p;
		}
		else {
			insert2(p,root);
		}
	}

	public boolean isEmptyTree(){
		return root == null;
	}

	public void insert2(Person p, Person t ){
		if (p.getSSN() < t.getSSN()){
			if(t.getLeft() == null){
				t.setLeft(p);
			}
			else {
				insert2(p,t.getLeft());
			}
		}
		else {
			if(t.getRight() == null){
				t.setRight(p);
			}
			else {
				insert2(p,t.getRight());
			}
		}
	}

	public Person search(int key){
		return search2(root,key);
	}

	public Person search2(Person temp, int key){
		if (temp == null){
			return null;
		}
		else if(temp.getSSN() == key){
			return temp;
		}
		else if (key < temp.getSSN()){
			if (temp.getLeft() == null){
				return null;
			}
			return search2(temp.getLeft(),key);
		}
		else if (key > temp.getSSN()){
			if (temp.getRight() == null){
				return null;
			}
			return search2(temp.getRight(),key);
		}
		return null;
	}

	public void traverse()
	{
		traverser(root);
	}

	public void traverser(Person leaf){
		if (leaf != null){
				traverser(leaf.getLeft());
				System.out.print(leaf.getSSN() + " ");
				traverser(leaf.getRight());
		}
	}


	public void traverseEmail(int SN){
		if (root.getSN() == SN) {
			System.out.println(root.getEmail());
			return;
		}
		 traverserEmail(root, SN);
		
	}

	public void traverserEmail(Person leaf, int SN){
		
		if (leaf != null){
			
				if (leaf.getSN() == SN){
					System.out.println(leaf.getEmail());
					return;
				}
				traverserEmail(leaf.getLeft(), SN);
				
				//System.out.print(leaf.getSSN() + " ");
				traverserEmail(leaf.getRight(), SN);
				if (leaf.getSN() == SN){
					System.out.println(leaf.getEmail());
					return;
				}
		}
		
	}

	


	public void delete(Person x){
		
		if (root != null){
			if (x.getSSN() == root.getSSN()){
				root = deleteRoot(root);
			}
			else {
				delete2(root,x);
			}
		}
	}

	public void delete2(Person t, Person x){
		if (t.getLeft() != null && x.getSSN() < t.getSSN()){
			if(x.getSSN() == (t.getLeft().getSSN())){
				t.setLeft(deleteRoot(t.getLeft()));
			}
			else{
				delete2(t.getLeft(), x);
			}
			
		}
		if (t.getRight() != null && x.getSSN() > t.getSSN()){
			if(x.getSSN() == (t.getRight().getSSN())){
				t.setRight(deleteRoot(t.getRight()));
			}
			else{
				delete2(t.getRight(), x);
			}
			
		}
	}

	public Person deleteRoot(Person t){
	//	Person temp = t;
		if (t.getLeft() ==  null && t.getRight() == null){
			return null;
		}
		else if (t.getRight() == null) {
			return t.getLeft();
		}
		else if (t.getLeft() == null){
			return t.getRight();
		}
		else {
			Person newroot = successor(t);
			delete(newroot);
			newroot.setLeft(t.getLeft());
			newroot.setRight(t.getRight());
			t.setLeft(null);
			t.setRight(null);
			return(newroot);
		}
		
	}
	
	public Person successor(Person treeroot){
		if (treeroot == null) {
			return null;
		}
		treeroot = treeroot.getRight();
		while (treeroot.getLeft() != null){
			treeroot = treeroot.getLeft();
		}
		return treeroot;
	}

    public void printTree() {
    	System.out.println();
		printTree2(root);
		System.out.println();
    }

    private void printTree2(Person tree) {
	if (tree != null) {
		    System.out.println("Name: "+tree.getName() + " SSN: " + tree.getSSN() + " Student ID " + tree.getSN());
			if (tree.ideaAmount() > 0){
				System.out.print("Average Idea Score: " + tree.getAverage() + "\n");
			}
	            // if (tree.getLeft() != null){
		        // System.out.print("Left: " + tree.getLeft().getSSN() + " ");
		    	// }
	            // else {
	            //     System.out.print("Left: null ");
	            // }
	            // if (tree.getRight() != null){
		        // System.out.println("Right: " + tree.getRight().getSSN() + " ");
		    	// }
	            // else {
	            //     System.out.println("Right: null ");
	            // }
		    printTree2(tree.getLeft());
		    printTree2(tree.getRight());
		}
    }

}