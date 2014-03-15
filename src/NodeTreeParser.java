/*
Given a group of nodes connected in an abstract tree structure, this class has methods
to traverse and count those nodes using a breadth first method
*/

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NodeTreeParser {
	
	private Queue<Node> nodeQueue;
	
	public NodeTreeParser() {
		nodeQueue = new LinkedBlockingQueue<Node>();	
	}
	
	public Queue<Node> getNodeQueue() { return nodeQueue; }
	
	public int getNodeQueueSize() { return nodeQueue.size(); } 
	
	public int countDescendants(Node rootNode)
	{
		
		int count = -1;
		Node currNode;
		nodeQueue.add(rootNode);
		
		while(nodeQueue.peek() != null)
		{
			currNode = nodeQueue.remove();
			count++;
			getAllChildren(currNode);	
		}
		
		return count;
		
	}
	
	public void getAllChildren(Node rootNode) 
	{
		
		if (rootNode.getFirstChild() == null)
			return;
		
		Node currNode = rootNode.getFirstChild();
		nodeQueue.add(currNode);
		
		while (currNode.getNextSibling() != null)
		{
			currNode = currNode.getNextSibling();
			nodeQueue.add(currNode);	
		}
		
	}

}
