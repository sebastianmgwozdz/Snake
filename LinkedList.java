
public class LinkedList {
	
	private Node head;
	private Node tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	public void addFront(Box b) {
		Node n = new Node(b);
		
		if (head == null) {
			tail = n;
		}
		else {
			n.setNext(head);
		}
		
		head = n;
	}
	
	public void addEnd(Box b) {
		Node n = new Node(b);
		
		if (head == null) {
			head = n;
		}
		else {
			tail.setNext(n);	
		}
		
		tail = n;
	}
	
	public Box remove() {
		if (head == null) {
			return null;
		}
		
		Box b = head.getBox();
		
		head = head.getNext();
		
		if (head == null) {
			tail = null;
		}
		
		return b;
	}
	
	
	
	
	class Node {
		private Box b;
		private Node next;
		
		public Node(Box b) {
			this.setBox(b);
			this.setNext(null);
		}

		public Box getBox() {
			return b;
		}

		public void setBox(Box b) {
			this.b = b;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
