/*
 * Implementation of the stack data structure.
 */
class Stack {
	
	private Node topNode;
	private int size; // Stack's size dynamically changes
	
	/*
	 * Creates a new stack and adds a null node to it.
	 * You can't get the null node fields' values
	 * using Stack object methods.
	 */
	Stack() {
		
		this.topNode = new Node(null, null);
		this.size = 0;
		
	}
	
	/*
	 * Adds a new element to the top of the stack.
	 * 
	 * @param value New node's value
	 */
	public void push(String value) {
		
		this.topNode = new Node(value, topNode);
		
		this.size++;
		
	}
	
	/*
	 * Returns a value of a top element of the stack.
	 * 
	 * @return Top element's value
	 * 
	 * @exception EmptyStackException If the stack is empty
	 */
	public String top() {
		
		try {
			
			if (size <= 0) {
				
				throw new EmptyStackException("Can't get top element, the stack is empty.");
				
			}
			
			return this.topNode.value;
			
		}
		catch (EmptyStackException e) {
			
			e.printStackTrace();
			
			return null;
			
		}	
	}
	
	/*
	 * Returns a value of a top element of the stack
	 * and removes that element, marking a previous
	 * element (it may be the null node) as top.
	 * 
	 * @return Top element's value
	 * 
	 * @exception EmptyStackException If the stack is empty
	 */
	public String pop() {
		
		try {
			
			if (this.size <= 0) {
				
				throw new EmptyStackException("Can't pop any element, the stack is empty.");
				
			}
			
			String topNodeValue = topNode.value;
			
			this.topNode = topNode.getPrevious();
			
			this.size--;
			
			return topNodeValue;

		}
		catch (EmptyStackException e) {
			
			e.printStackTrace();
			
			return null;
			
		}
	}
	
	/*
	 * Returns a current size of the stack.
	 * 
	 * @return A current size of the stack
	 */
	public int getSize() {
		
		return this.size;
		
	}
}

/*
 * Represents node (element) of the stack data structure.
 * Support Class.
 */
class Node {
	
	String value;
	private Node previous;
	
	/*
	 * Creates a new node.
	 * 
	 * @param value String value of the node
	 * @param previous A link to previous node of the stack
	 */
	public Node(String value, Node previous) {
		
		this.value = value;
		this.previous = previous;
		
	}
	
	/*
	 * Reutrns a previous node of the stack.
	 * 
	 * @return A previous node of the stack.
	 */
	public Node getPrevious() {
		
		return this.previous;
		
	}
}

/*
 * Occurs when trying to get an element from an empty stack.
 */
class EmptyStackException extends Exception {

	private static final long serialVersionUID = -335117072136990522L;

	/*
	 * Transmits an error message to the superclass method.
	 * 
	 * @param message Error message
	 */
	public EmptyStackException(String message) {
		
		super(message);
		
	}
}