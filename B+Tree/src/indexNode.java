
public class indexNode {

	private indexNode parents = null;
	private int max_size = 2;
	private int size = 0;
	public Node indexedArr[];
	
	public indexNode(){
		indexedArr = new Node[max_size];
	}
	public indexNode(int size) {
		this.max_size = size;
		indexedArr = new Node[max_size];
	}

	
	public int getSize(){
		return size;
	}
	public indexNode getParents(){
		return this.parents;
	}
	
	public void insertNode(int key,int value, int spot){
		Node New_Node = new Node();
		
		New_Node
		
	}
	
	public class Node {
		private Node prev = null;
		private Node next = null;
		private Object data = null;
		private indexNode son =null;

		public Node(){
		}
		
		public void setSon(indexNode son){
			this.son = son;
		}
		public void setPrev(Node prev){
			this.prev = prev;
		}
		public void setNext(Node next){
			this.next = next;
		}
		public void setData(int key, int value){
			data.setKey(key);
			data.setValue(value);
		}
		public void setData(Object data){
			this.data = data;
		}
		
		public indexNode getSon(){
			return son;
		}
		public Node getPrev() {
			return prev;
		}
		public Node getNext() {
			return next;
		}
		public Object getdata() {
			return data;
		}
	}

	public class Object {
		private int key;
		private int value;

		
		public Object(){
			key = -1;
			value = -1;
		}
		public Object(int key, int value){
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}
		public int getValue() {
			return value;
		}

		public void setKey(int key) {
			this.key = key;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
}
