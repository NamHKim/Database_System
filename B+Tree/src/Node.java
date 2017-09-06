
public class Node {
	
	public Node parents = null;
	public int max_size = 0;
	public int size = 0;
	public Node[] index;
	
	public int key;
	public int value;
	
	public Node(int size)
	{
		max_size = size;
		index = new Node[max_size+1];
	}
	
	public void insert(int k, int val)
	{
		Node New_Node = new Node(max_size);
		New_Node.parents = this.parents;
		New_Node.key = k;
		New_Node.value = val;
		
		if(size == 0)
		{
			index[0]=New_Node;
		}
		
		for(int i=0;i<size;i++)
		{
			if(k == index[i].key) return;//같은 키값을 가지고 있는 입력값은 무시한다.
			if(k < index[i].key)
			{
				for(int j=size;j>i;j--)
					index[j] = index[j - 1];
				
				index[i] = New_Node;
				break;
			}
		}
		size++;
	}
	public void insert(Node n)
	{
		for(int i=0;i<size;i++)
		{
			if(n.key < index[i].key)//같은 키값이 들어올 수 없다.(split시에만 사용됨)
			{
				for(int j=size;j>i;j--)
					index[j] = index[j - 1];
				
				index[i] = n;
				break;
			}
		}
		size++;
	}
	public void delete(int k)
	{
		for(int i=0;i<size;i++)
		{
			if(k == index[i].key)
			{
				for(int j=i;j<size-1;j++)
				{
					index[j]=index[j+1];
				}
				break;
			}
		}
		size--;
	}
	public void delete(Node n)
	{
		for(int i=0;i<size;i++)
		{
			if(n.key == index[i].key)
			{
				for(int j=i;j<size-1;j++)
				{
					index[j]=index[j+1];
				}
				break;
			}
		}
		size--;
	}
}
