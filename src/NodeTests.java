import static org.junit.Assert.*;

import java.security.PublicKey;

import org.junit.Before;
import org.junit.Test;

public class NodeTests {

	public Node avatarNode, innerNode, headerNavNode;
	
	@Before
	public void setUp() throws Exception {
		
		avatarNode = new Node();
		innerNode = new Node();
		headerNavNode = new Node(avatarNode, innerNode);
		
	}

	@Test
	public void testAvatarNode() {
		
		assertNull("avatarNode's firstChild should be null", avatarNode.getFirstChild());
		assertNull("avatarNode's nextSibling should be null", avatarNode.getNextSibling());
		
	}
	
	@Test
	public void testInnerNode(){
		
		assertNull("innerNode's firstChild should be null", innerNode.getFirstChild());
		assertNull("innerNode's nextSibling should be null", innerNode.getNextSibling());
		
	}
	
	@Test
	public void testHeaderNavNode(){
		
		assertEquals("headerNavNode's firstChild should be avatarNode", avatarNode, headerNavNode.getFirstChild());
		assertEquals("headerNavNode's nextSibling should be innerNode", innerNode, headerNavNode.getNextSibling());
		
	}

}
