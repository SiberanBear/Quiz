package Quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Event implements Runnable
{	
	private String selectTheme;
	private String help = "Правила очень простые: Я буду задавать вопросы, "
			+ "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
			+ "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. "
			+ "Как выиграть? Останься в плюсе до конца! Удачной игры!\n";
	Scanner enter = new Scanner(System.in);
	Map<String, Integer> dict = new HashMap<String, Integer>();
	List<String> questList = new ArrayList<String>();
	private int lastAns = 1;
	private String lastQuest = null;
	boolean flag1 = true;
	boolean flag2 = false;

	public void gameQuiz(String name) throws FileException
	{
		int point = 0;
		int choise = questList.size();
		String question = null;
		while(true) {
			if (choise == 0) {
				System.out.println(name + "YOU WIN!!!");
				break;
			}
			question = selectQuest(choise, name);
			int answer = enter.nextInt();
			if (answer != dict.get(question) && answer != 0 && answer != 5) {	
				point -= 300;
				System.out.println(name + "Неверно! У тебя " + point + " очков");
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
				if (point <= 0) {
					System.out.println(name + ", GAME OVER!!!!");
					flag1 = false;
					break;
				}
			}
			else if (answer == 0) {
				this.lastAns = answer;
				this.lastQuest = question;
				System.out.println(this.help);
			}
			else if (answer == 5) {
				if (point <= 500)
					System.out.println("У тебя недостаточно очков, чтобы взять подсказку");
				else {			
					getHint(question, dict.get(question));
					point-=500;
				}
				this.lastAns = answer;
				this.lastQuest = question;
			}
			else {
				this.lastAns = answer;
				point+=100;
				System.out.println(name + "Молодец! У тебя " + point + " очков");
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
			}
		}
	}
	
	public  void startGame() throws FileException
	{
		System.out.println("Привет! Для начала скажи, как я могу к тебе обращаться?");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("Приятно познакомиться, " + name + "!\nДавай сыграем! "
				+ "\nДля ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");
		Question creater = new Question();
		System.out.println("Для начала, выберите тематику вопросов: " + creater.theme.get(0) + " " + creater.theme.get(1));	
		this.selectTheme = enter.next();	
		while (this.selectTheme.contains("0")) {			
			System.out.println(this.help + "Тематики: " + creater.theme.get(0) + " " + creater.theme.get(1));
			this.selectTheme = enter.next();			
		}
		creater.readFile(this.selectTheme);
		dict = creater.getDict();
		questList = creater.getQwest();	
		gameQuiz(name);
	}
	
	public String selectQuest(int choise, String name) 
	{
		String question = null;
		if (this.lastAns == 0)
			question = this.lastQuest;
		else if (this.lastAns == 5) {
			System.out.println(this.lastQuest);
			return this.lastQuest;
		}
		else
			question = questList.get(new Random().nextInt(choise));
		String [] s = question.split(":");
		System.out.println(name + s[0] + " \n" + s[1]);
		return question;
	}
	
	public void getHint(String question, int answer)
	{
		String [] s = question.split(":");
		String[] s1 = s[1].split(";");
		List<String> ans = new ArrayList<>();
		List<String> notAns = new ArrayList<>();
		for (String i : s1) {
			if (i.contains(Integer.toString(answer)))
				ans.add(i);
			else
				notAns.add(i);
		}
		ans.add(notAns.get(new Random().nextInt(3)));
		System.out.println(s[0] + " " + ans.get(1) + " " + ans.get(0));
		//this.lastQuest = s[0] + ans.get(1) + " " + ans.get(0);
	}
	@Override
	public void run() {
		try {
			startGame();
		} catch (FileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
