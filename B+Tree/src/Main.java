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

			if (command == 'c') // B+ Tree 의 인덱스 사이즈 설정 
				tree.set_Tree(Integer.parseInt(s));
			else // insert, delete, search를 파일을 읽으면서 바로 진행
			{	 // 세부 사항은 B_Tree 클래스에 구현
				while ((s = br.readLine()) != null)
				{
					String[] field = s.split(",");

					if (command == 'i')
						dest.insert(field[0], field[1]);
					else if (command == 'd')
						dest.Delete(field[0], field[1]);
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

	public static void main(String[] args)
	{
		if (args[0].charAt(1) == 'c') // index.dat 파일을 생성하는 명령
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
		else // 기존 index.dat이 존재하고 그에 따른 실행
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
