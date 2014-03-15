import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class NodeTreeParserTests {
	
	public NodeTreeParser myNodeTreeParser;
	public Node headerNavNode, imgNode, avatarNode, loggedInUserNode, ulNode, listFirstNode, listLastNode,
				headerInboxNode, logOutNode, searchBoxNode, innerNode;

	@Before
	public void setUp() throws Exception {
		
		myNodeTreeParser = new NodeTreeParser();
		
	}
	
	@Test
	public void testGetAllChildrenNoChild() {
		
		avatarNode = new Node();
		myNodeTreeParser.getAllChildren(avatarNode);
		
		assertEquals("Calling getAllChildren on a node with no children builds a null queue",
					0, myNodeTreeParser.getNodeQueueSize());
		
	}

	@Test
	public void testGetAllChildrenOneChild() {
		
		avatarNode = new Node();
		headerNavNode = new Node(avatarNode, null);
		myNodeTreeParser.getAllChildren(headerNavNode);
		
		assertEquals("Calling getAllChildren on a node with one child builds a queue containing one node",
				1, myNodeTreeParser.getNodeQueueSize());
		assertTrue("The one node is the correct child node", myNodeTreeParser.getNodeQueue().contains(avatarNode));
		
	}
	
	@Test
	public void testGetAllChildrenMultipleChildren() {
		
		loggedInUserNode = new Node();
		avatarNode = new Node(null, loggedInUserNode);
		headerNavNode = new Node(avatarNode, null);
		myNodeTreeParser.getAllChildren(headerNavNode);
		
		assertEquals("Calling getAllChildren on a node with two children builds a queue containg two nodes",
					 2, myNodeTreeParser.getNodeQueueSize());
		assertTrue("Contains one of two correct nodes", myNodeTreeParser.getNodeQueue().contains(avatarNode));
		assertTrue("Contains two of two correct nodes", myNodeTreeParser.getNodeQueue().contains(loggedInUserNode));
		
	}
	
	@Test
	public void testCountDescendants() {
		
		loggedInUserNode = new Node();
		avatarNode = new Node(null, loggedInUserNode);
		headerNavNode = new Node(avatarNode, null);
		
		assertEquals("Count descendants should return two for a root node that has two children",
					 2, myNodeTreeParser.countDescendants(headerNavNode));
		
	}
	
	@Test 
	public void testCountDescendantsComplexTree() {
		
		loggedInUserNode = new Node();
		imgNode = new Node();
		avatarNode = new Node(imgNode, loggedInUserNode);
		headerNavNode = new Node(avatarNode, null);
		
		assertEquals("Count descendants should return three for a root node that has three descendants",
				 	 3, myNodeTreeParser.countDescendants(headerNavNode));
		
	}
	
	@Test
	public void testCountDescendantsWithDOMTreeHeaderNav() {
		
		logOutNode = new Node();
		listLastNode = new Node(logOutNode, null);
		headerInboxNode = new Node();
		listFirstNode = new Node(headerInboxNode, listLastNode);
		searchBoxNode = new Node();
		ulNode = new Node(listFirstNode, searchBoxNode);
		loggedInUserNode = new Node(null, ulNode);
		imgNode = new Node();
		avatarNode = new Node(imgNode, loggedInUserNode);
		headerNavNode = new Node(avatarNode, innerNode);
		
		assertEquals("Expected output of 9 descendants for a test DOM tree",
				      9, myNodeTreeParser.countDescendants(headerNavNode));
		
	}
	
	@Test
	public void testCountDescendantsWithDOMTreeUnorderedList() {
		
		logOutNode = new Node();
		listLastNode = new Node(logOutNode, null);
		headerInboxNode = new Node();
		listFirstNode = new Node(headerInboxNode, listLastNode);
		searchBoxNode = new Node();
		ulNode = new Node(listFirstNode, searchBoxNode);
		loggedInUserNode = new Node(null, ulNode);
		imgNode = new Node();
		avatarNode = new Node(imgNode, loggedInUserNode);
		headerNavNode = new Node(avatarNode, innerNode);
		
		assertEquals("Expected output of 4 descendants for a test DOM tree",
				      4, myNodeTreeParser.countDescendants(ulNode));
		
	}
	
	@Test
	public void testCountDescendantsWithDOMTreeAvatar() {
		
		logOutNode = new Node();
		listLastNode = new Node(logOutNode, null);
		headerInboxNode = new Node();
		listFirstNode = new Node(headerInboxNode, listLastNode);
		searchBoxNode = new Node();
		ulNode = new Node(listFirstNode, searchBoxNode);
		loggedInUserNode = new Node(null, ulNode);
		imgNode = new Node();
		avatarNode = new Node(imgNode, loggedInUserNode);
		headerNavNode = new Node(avatarNode, innerNode);
		
		assertEquals("Expected output of 1 descendant for a test DOM tree",
				      1, myNodeTreeParser.countDescendants(avatarNode));
		
	}

}
