package Quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Event 
{
	public Event(String name) throws IOException
	{
		System.out.println("��� ������, �������� �������� ��������: 1.������ 2.���������");
		Scanner enter = new Scanner(System.in);
		int selectTheme = enter.nextInt();
		if (selectTheme == 0)
		{
			System.out.println("��� �� �����. ��������� �� ������� � ������������� ����");
			selectTheme = enter.nextInt();		
		}
		String theme = null;
		switch(selectTheme) 
		{
			case 1:
				theme = "C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\1.txt";
				break;
			case 2:
				theme = "C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\2.txt";
				break;
		}
		Question ls = new Question(theme);		
		int point = 0;
		//int choise = enter.nextInt();
		ArrayList<String> qwe = ls.getQwest();
		HashMap<String, Integer>dic = ls.getDict();
		while(true) 
		{
			if (qwe.isEmpty()) 
			{
				System.out.println("YOU WIN!!!");
				break;
			}
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
	}
}
