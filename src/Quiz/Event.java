package Quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Event 
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
	
	public void gameQuiz(String name) throws FileException
	{
		int point = 0;
		int choise = questList.size();
		String question = null;
		while(true) {
			if (choise == 0) {
				System.out.println("YOU WIN!!!");
				break;
			}
			question = selectQuest(question, choise);
			int answer = enter.nextInt();
			if (answer != dict.get(question) && answer != 0) {	
				point -= 300;
				System.out.println("Неверно! У тебя " + point + " очков");
				if (point <= 0) {
					System.out.println(name + ", GAME OVER!!!!");
					break;
				}
			}
			else if (answer == 0) {
				this.lastAns = answer;
				this.lastQuest = question;
				System.out.println(this.help);
			}
			else {
				this.lastAns = answer;
				point+=100;
				System.out.println("Молодец! У тебя " + point + " очков");	
			}
			Collections.swap(questList, questList.indexOf(question), choise-1);
			choise--;
		}
	}
	
	public void startGame() throws FileException
	{
		System.out.println("Привет! Для начала скажи, как я могу к тебе обращаться?");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("Приятно познакомиться, " + name + "!\nДавай сыграем! "
				+ "\nДля ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");
		Question creater = new Question();
		System.out.println("Для начала, выберите тематику вопросов: " + creater.dictTheme.get("1.txt") + " " + creater.dictTheme.get("2.txt"));	
		this.selectTheme = enter.next();	
		while (this.selectTheme.contains("0")) {			
			System.out.println(this.help + "Тематики: " + creater.dictTheme.get("1.txt") + " " + creater.dictTheme.get("2.txt"));
			this.selectTheme = enter.next();			
		}
		creater.readFile(this.selectTheme);
		dict = creater.getDict();
		questList = creater.getQwest();	
		gameQuiz(name);
	}
	
	public String selectQuest(String question, int choise) 
	{
		if (this.lastAns == 0)
			question = this.lastQuest;
		else
			question = questList.get(new Random().nextInt(choise));
		String [] s = question.split(":");
		System.out.println(s[0] + " \n" + s[1]);
		return question;
	}
}
