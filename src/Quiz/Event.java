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
		if (selectTheme == 1)
			theme = "C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\1.txt";
		else if (selectTheme == 2)
			theme = "C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\2.txt";
		Question creater = new Question(theme);		
		int point = 0;
		ArrayList<String> quest = creater.getQwest();
		HashMap<String, Integer> dict = creater.getDict();
		while(true) 
		{
			if (quest.isEmpty()) 
			{
				System.out.println("YOU WIN!!!");
				break;
			}
			String vopros = quest.get(new Random().nextInt(quest.size()));
			System.out.println(vopros);
			int answer = enter.nextInt();
			if (answer != dict.get(vopros) && answer != 0) 
			{
				System.out.println(name + ", GAME OVER!!!!");
				break;
			}
			else if (answer == 0)
				System.out.println("Тут всё просто, отвечаешь на вопросы и зарабатываешь очки.");
			else
			{
				point+=100;
				System.out.println("Молодец, у тебя " + point + " очков");
				quest.remove(vopros);
			}
		}
	}
}
