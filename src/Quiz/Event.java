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
		Question ls = new Question("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\2.txt");
		Scanner enter = new Scanner(System.in);
		int point = 0;
		int choise = enter.nextInt();
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
					System.out.println("Тут всё легко. Отвечаешь на вопросы и зарабатываешь очки");
				else
				{
					point+=100;
					System.out.println("Молодец, у тебя " + point + " очков");
					qwe.remove(vopros);
				}
			}
			else if(choise == 0) 
			{
				System.out.println("Тут всё легко. Отвечаешь на вопросы и зарабатываешь очки");
			}
		}
	}
}
