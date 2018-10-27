package Quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class Event implements Runnable
{	
	private String selectTheme;

	public String help = "Правила очень простые: Я буду задавать вопросы, "
			+ "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
			+ "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. "
			+ "Как выиграть? Останься в плюсе до конца! Удачной игры!\n";
	
	public void startGame() throws FileException
	{
		GUI app = new GUI();
		app.setVisible(true);
		app.label.setText("Привет! Для начала скажи, как я могу к тебе обращаться?");	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = app.getName();
//		while (name == "Player")
//			name = app.getName();
		app.label.setText("Приятно познакомиться, " + name + "!\nДавай сыграем! "
				+ "\nДля ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");
		Question creater = new Question();
		//ls.label.setText("Для начала, выберите тематику вопросов: " + creater.theme.get(0) + " " + creater.theme.get(1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.label.setText("Для начала, выберите тематику вопросов: " + creater.theme.get(0) + " " + creater.theme.get(1));

		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.selectTheme = app.getNumber();	
		while (this.selectTheme == "0") {			
			app.label.setText(this.help + "Тематики: " + creater.theme.get(0) + " " + creater.theme.get(1));
			this.selectTheme = app.getNumber();			
		}
		creater.readFile(this.selectTheme);
		Map<String, Integer> dict = creater.getDict();
		List<String> questList = creater.getQwest();	
		List<String> goodAnswer = creater.getAnswer("GoodAnswer.txt"); 
		List<String> badAnswer = creater.getAnswer("BadAnswer.txt");
		new GameQuiz().gameQuiz(name, app, dict, questList, goodAnswer, badAnswer);
	}
	
	public String selectQuest(GUI app, int choise, String name, int lastAns, String lastQuest, List<String> questList) 
	{
		String question = null;
		if (lastAns == 0)
			question = lastQuest;
		else if (lastAns == 5) {
			//app.label.setText(lastQuest);
			return lastQuest;
		}
		else
			question = questList.get(new Random().nextInt(choise));
		String [] s = question.split(":");
		app.label.setText(name + s[0] + " \n" + s[1]);
		return question;
	}
	
	public void getHint(GUI app, String question, int answer)
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
		app.label.setText(s[0] + " " + ans.get(1) + " " + ans.get(0));
		//this.lastQuest = s[0] + ans.get(1) + " " + ans.get(0);
	}
	@Override
	public void run() {
		try {
			startGame();
		} catch (FileException e) {
			e.printStackTrace();
		}		
	}
}
