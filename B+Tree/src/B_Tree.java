
public class B_Tree
{

	static private int max_size = 2;
	static private Node root = null;
	static int depth = 0;
	
	
	public void set_Tree(int size)
	{
		this.max_size = size;
		if (root == null)
			root = new Node(max_size);
		depth = 1;
	}

	public Node search(String key, char command)
	{
		int k = Integer.parseInt(key);
		
		Node tmp = root;
		
		for (int i = 1; i <= depth; i++)
		{
			if(i!=depth) // depth�� �����ϱ� ���� ���� ���� ��� indexed array �̴�.
			{	
				for(int j=0;j<tmp.size;j++)
					if(k <= tmp.index[j].key)
					{
						tmp = tmp.index[j];
						break;
					}
			}
			else// root�� ���� depth�� �������� �� �ڸ��� ã����
			{
				if(command == 's')
				{
					for(int j=0;j<tmp.size;j++)
						if(tmp.index[j].key == k)
						{
								System.out.println("\n" + tmp.index[j].key+
												   ", " + tmp.index[j].value);
								return tmp;
						}
						else if(tmp.index[j].key > k)
						{
							System.out.println("NOT FOUND");
							return null;
						}
						 
				}
				else
				{
					return tmp;
				}
			}
		}
		return tmp;
	}
	public void split(Node current)
	{
		int n = (max_size+1)/2;
		Node New_Node = new Node(max_size);
		
		for(int i=0;i<max_size/2;i++)
		{
			New_Node.index[i] = current.index[n+i];
			current.index[n+i] = null;
		}
		current.size = n;
		New_Node.size = max_size/2;
		
		if(current.parents != null)
		{
			current.parents.insert(New_Node);
			if(current.parents.size>max_size)
				split(current.parents);
		}
		else//parents�� ������ root ����̹Ƿ� ���ο� root�� �Ҵ�������Ѵ�.
		{
			Node New_root = new Node(max_size);
			New_root.index[0]=current;
			New_root.index[1]=New_Node;
			New_root.size=2;
			root = New_root;
			depth++;
		}
	}
	public void insert(String key, String data)
	{
		int k = Integer.parseInt(key);
		int dt = Integer.parseInt(data);
		
		Node tmp = search(key,'i');
		
		tmp.insert(k, dt);
		
		if(tmp.size > max_size)
			split(tmp);
	}

	public void Delete(String key, String data)
	{
		int k = Integer.parseInt(key);
		int dt = Integer.parseInt(data);
	}

}
