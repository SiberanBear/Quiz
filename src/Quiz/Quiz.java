package Quiz;
import java.io.*;
import java.util.*;
public class Quiz 
{//��������� �����(������� �������)
	public static void main(String[] args) throws IOException
	{
		//Question ls = new Question("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\2.txt");
		System.out.println("����������� ��� � ����� ���������!\n������� ���� ���:");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("��� ������ �� ������� ����������� ������� �� 1 �� 4. ������� ���������� �� ������� ������� 0");
		//int point = 0;
		System.out.println("������� �������������, " + name + "!\n����� �������� � ������������ ������� � ��? ��� � ���� ��� �������� �������?");
		//int choise = enter.nextInt();
		Event s = new Event(name);
		/*int choise = enter.nextInt();
		ArrayList<String> qwe = ls.getQwest();
		HashMap<String, Integer>dic = ls.getDict();
		while(true) 
		{
			if (qwe.isEmpty()) 
			{
				System.out.println("YOU WIN!!!");
				break;
			}
			if (choise == 1) 
			{
				String vopros = qwe.get(new Random().nextInt(qwe.size()));
				System.out.println(vopros);
				int asd1 = enter.nextInt();
				if (asd1 != dic.get(vopros) && asd1 != 0) 
				{
					System.out.println(name + ", GAME OVER!!!!");
					break;
				}
				else if (asd1 == 0)
					System.out.println("��� �� �����. ��������� �� ������� � ������������� ����");
				else
				{
					point+=100;
					System.out.println("�������, � ���� " + point + " �����");
					qwe.remove(vopros);
				}
			}
			else if(choise == 0) 
			{
				System.out.println("��� �� �����. ��������� �� ������� � ������������� ����");
			}
		}*/
	}

}