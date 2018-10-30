package Quiz;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameQuiz {
	
	private int lastAns = 1;
	private String lastQuest = null;
	
	public void gameQuiz(String name, GUI app, Map<String, Integer> dict, List<String> questList, List<String> goodAnswer, List<String> badAnswer) throws FileException
	{	
		Event e = new Event();
		int point = 0;
		int choise = questList.size();
		String question = null;
		while(true) {
			if (choise == 0) {
				app.label.setText(name + "YOU WIN!!!");
				break;
			}
			question = e.selectQuest(app, choise, name, this.lastAns, this.lastQuest, questList);
			app.label.setText(question);
			app.number = "0";
			int answer = Integer.parseInt(app.number);
			while (answer == 0)
				answer = Integer.parseInt(app.number);			
			if (answer != dict.get(question) && answer != 6 && answer != 5) {	
				point -= 300;
				app.label1.setText(badAnswer.get(new Random().nextInt(badAnswer.size())) + "У тебя: " + point + " очков");
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
				if (point <= 0) {
					app.label.setText(name + ", GAME OVER!!!!");
					break;
				}
			}
			else if (answer == 6) {
				app.label1.setText(e.help);
				lastAns = answer;
				lastQuest = question;			
			}
			else if (answer == 5) {
				if (point <= 300)
					app.label1.setText("У тебя недостаточно очков, чтобы взять подсказку");
				else {			
					e.getHint(app, question, dict.get(question));
					point-=300;
				}
				this.lastAns = answer;
				this.lastQuest = question;
			}
			else {
				this.lastAns = answer;
				point+=100;
				app.label1.setText(goodAnswer.get(new Random().nextInt(goodAnswer.size())) + "У тебя: " + point + " очков");
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
			}
		}
	}
}