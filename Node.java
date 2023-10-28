public class Node {
	private String name;
	private int SSN;
	private Node next;
	private Node left;
	private Node right;

	public Node (String nodeName, int nodeSSN){
		name = nodeName;
		SSN = nodeSSN;
	}
		public String getName(){
			return name;
		}
		public int getSSN(){
			return SSN;
		}
		public void setName(String newName){
			name = newName;
		}
		public void setSSN(int newSSN){
			SSN = newSSN;
		}
		public int getKey(){
			return (SSN%10000);
		}
		public Node getNext(){
			return next;
		}
		public Node getLeft(){
			return left;
		}
		public Node getRight(){
			return right;
		}
		public void setNext(Node nextNode){
			next = nextNode;
		}
		public void setLeft(Node leftNode){
			left = leftNode;
		}
		public void setRight(Node rightNode){
			right = rightNode;
		}
		
}