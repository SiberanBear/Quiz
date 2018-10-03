package Quiz;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Event 
{	
	public String selectTheme;
	Scanner enter = new Scanner(System.in);
	public Event(String name)
	{
		Map<String, String> d = new HashMap<String, String>();
		d.put("1.txt", "1.матмех");
		d.put("2.txt", "2.география");
		System.out.println("Для начала, выберите тематику вопросов: " + (String)d.get("1.txt") + " " + (String)d.get("2.txt"));	
		this.selectTheme = enter.next();
		while (this.selectTheme == "0")
		{
			System.out.println("Правила очень простые: Я буду задавать вопросы, "
					+ "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
					+ "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. "
					+ "Как выиграть? Останься в плюсе до конца! Удачной игры!");
			this.selectTheme = enter.next();		
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
				point -= 300;
				System.out.println("Неправильно! У тебя " + point + " очков");
				if (point <= 0) 
				{
					System.out.println(name + ", GAME OVER!!!!");
					break;
				}
			}
			else if (answer == 0)
				System.out.println("Тут всё просто, отвечаешь на вопросы и зарабатываешь очки.");
			else
			{
				point+=100;
				System.out.println("Молодец, у тебя " + point + " очков");
				Collections.swap(quest, quest.indexOf(vopros), choise-1);
				choise--;
			}
		}
	}
}
