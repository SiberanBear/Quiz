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
		System.out.println("Для начала, выберите тематику вопросов: 1.Матмех, 2.География");
		Scanner enter = new Scanner(System.in);
		int selectTheme = enter.nextInt();
		if (selectTheme == 0)
		{
			System.out.println("Тут всё просто, отвечаешь на вопросы и зарабатываешь очки.");
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
				System.out.println("Тут всё просто, отвечаешь на вопросы и зарабатываешь очки.");
			else
			{
				point+=100;
				System.out.println("Молодец, у тебя " + point + " очков");
				qwe.remove(vopros);
			}
		}
	}
}
