package Quiz;

import java.util.List;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Event 
{	
	public int selectTheme;
	Scanner enter = new Scanner(System.in);
	public Event(String name)
	{
		System.out.println("Для начала, выберите тематику вопросов: 1.Матмех, 2.География");	
		this.selectTheme = enter.nextInt();
		if (this.selectTheme == 0)
		{
			System.out.println("Тут всё просто, отвечаешь на вопросы и зарабатываешь очки.");
			this.selectTheme = enter.nextInt();		
		}		
	}
	public void gameQuiz(List<String> quest,Map<String, Integer> dict, String name) 
	{
		int point = 0;
		int choise = quest.size();
		while(true) 
		{
			if (choise == 0) 
			{
				System.out.println("YOU WIN!!!");
				break;
			}
			String vopros = quest.get(new Random().nextInt(choise));
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
				Collections.swap(quest, quest.indexOf(vopros), choise-1);
				System.out.println(quest);
				choise--;
			}
		}
	}
}
