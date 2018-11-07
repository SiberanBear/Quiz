package Quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class Event
{	
	private String selectTheme;
	public String help = "Правила очень простые: Я буду задавать вопросы, "
			+ "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
			+ "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. "
			+ "Как выиграть? Останься в плюсе до конца! Удачной игры!\n";
	//int choise;
	String number = "0";
	List<String> questList;
	Map<String, Integer> dict;
	List<String> goodAnswer;
	List<String> badAnswer;
	
	
	public void startGame(String name, GameQuiz game, Event e) throws FileException
	{
		Question creater = new Question();
		while(number == "0") {
			Thread.yield();
			number = getNumber();
		}
		creater.readFile(number);
		dict = creater.getDict();
		questList = creater.getQwest();	
		goodAnswer = creater.getAnswer("GoodAnswer.txt"); 
		badAnswer = creater.getAnswer("BadAnswer.txt");
		game.gameQuiz(name,  dict, questList, goodAnswer, badAnswer, e);
	}
	
	public String selectQuest(int choise, String name, int lastAns, String lastQuest, List<String> questList) 
	{
		String question = null;
		if (lastAns == 6 || lastAns == 8)
			question = lastQuest;
		else if (lastAns == 5) {
			return lastQuest;
		}
		else
			question = questList.get(new Random().nextInt(choise));
		String [] s = question.split(":");
		//app.label.setText(name + s[0] + " \n" + s[1]);
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
		//app.label1.setText(s[0] + " " + ans.get(1) + " " + ans.get(0));
	}
	
	public void setNumber(String s) {
		number = s;
	}
	
	public String getNumber() {
		return number;
	}
	
//	@Override
//	public void run() {
//		try {
//			startGame();
//		} catch (FileException e) {
//			e.printStackTrace();
//		}		
//	}
}
