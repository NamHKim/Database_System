import java.io.*;

public class Main
{

	public static B_Tree tree = new B_Tree();

	public static void readCSV(String arg, B_Tree dest, char command)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arg)));
			String s = br.readLine();

			if (command == 'c') // B+ Tree �� �ε��� ������ ���� 
				tree.set_Tree(Integer.parseInt(s));
			else // insert, delete, search�� ������ �����鼭 �ٷ� ����
			{	 // ���� ������ B_Tree Ŭ������ ����
				while ((s = br.readLine()) != null)
				{
					String[] field = s.split(",");

					if (command == 'i')
						dest.insert(field[0], field[1]);
					else if (command == 'd')
						dest.Delete(field[0]);
					else if (command == 's')
						dest.search(arg,'s');
				}
			}
			br.close();
		} catch (FileNotFoundException e){
			System.out.println("Can't find file , " + arg);
		} catch (IOException e){
			System.out.println(arg + ": File is empty");
		}
	}

	public static void main(String[] args) throws IOException
	{
		boolean test = true;
	

		if(test)
		{	
			System.out.println("Test mode");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s=br.readLine();
			int n = Integer.parseInt(s);
		
			tree.set_Tree(n);
			
			while ((s = br.readLine()) != null)
			{
				String[] field = s.split(",");
				for(int i=0;i<3;i++)
				{
					if(field!=null);
					System.out.println(field[i]);
				}
				if(field[0] == "i")
				{
					tree.insert(field[1], field[2]);
					tree.print();
				}
				else if(field[1] == "d")
				{
					tree.Delete(field[1]);
					tree.print();
				}
				else if(field[2] == "s")
				{
					tree.search(field[1], 's');
				}
				if(field[0] == "f") return;
			}
		}
		
		if (args[0].charAt(1) == 'c') // index.dat ������ �����ϴ� ���
		{
			try
			{
				File file = new File(args[1]);
				FileWriter fw = new FileWriter(file);

				fw.write(args[2]);
				fw.flush();

				fw.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} 
		else // ���� index.dat�� �����ϰ� �׿� ���� ����
		{
			readCSV(args[1], tree, 'c');
			readCSV(args[1], tree, 'i');

			if (args[0].charAt(1) == 'i')
				readCSV(args[2], tree, 'i');
			else if (args[0].charAt(1) == 'd')
				readCSV(args[2], tree, 'd');
			else if (args[0].charAt(1) == 's')
				readCSV(args[2], tree, 's');
		}
	}

}
