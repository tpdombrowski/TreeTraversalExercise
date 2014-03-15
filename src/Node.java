public class Node {
	
	private Node firstChild;
	private Node nextSibling;
	
	public Node() {
		
		firstChild = null;
		nextSibling = null;
		
	}
	
	public Node(Node child, Node sibling) {
		
		firstChild = child;
		nextSibling = sibling;
		
	}
	
	public Node getFirstChild() { return firstChild; }
	
	public Node getNextSibling() { return nextSibling; }

}
