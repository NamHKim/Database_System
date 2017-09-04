
public class B_Tree
{

	static private int max_size = 2;
	static private indexNode root = null;
	static int depth = 1;
	
	
	public void set_Tree(int size)
	{
		this.max_size = size;
		if (root == null)
			root = new indexNode(max_size);
	}

	public indexNode search(String key, char command)
	{
		int k = Integer.parseInt(key);
		
		indexNode tmp = root;
		
		for (int i = 1; i <= depth; i++)
		{
			if(i!=depth) // depth에 도달하기 전에 가는 노드는 모두 indexed array 이다.
			{
				for(int j=0;j<tmp.getSize();j++)
				{
					if(k <= tmp.indexedArr[j].getdata().getKey())
					{
						if(command == 's')
						{
							if(i!= 1) System.out.print(",");
							System.out.print("<"+tmp.indexedArr[j].getdata().getKey() + ">");
						}
						tmp = tmp.indexedArr[j].getSon();
						break;
					}
				}
			}
			else// root로 부터 depth에 도달했을 때 자리를 찾아줌
			{
				for(int j=0;j<tmp.getSize();j++)
				{
					if(tmp.indexedArr[j].getdata().getKey() == k)
					{
						if(command == 's')
							System.out.println(tmp.indexedArr[j].getdata().getKey()+", "+
											   tmp.indexedArr[j].getdata().getValue());
						return tmp;
					}
					else if(tmp.indexedArr[j].getdata().getKey() > k)
					{
						if(command == 's')
						{
							System.out.println("NOT FOUND");
							return null;
						}
						else
							return tmp; 
					}
				}
			}
		}
		return tmp;
	}

	public void insert(String key, String data)
	{
		int k = Integer.parseInt(key);
		int dt = Integer.parseInt(data);
		
		indexNode tmp = search(key,'\0');
		
		if(tmp.getSize() == max_size)
		{
			
		}
		else
		{
			
		}
	}

	public void Delete(String key, String data)
	{
		int k = Integer.parseInt(key);
		int dt = Integer.parseInt(data);
	}

}
