package Quiz;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			app.number = "0";
			int answer = Integer.parseInt(app.getNumber());
			while (answer == 0)
				answer = Integer.parseInt(app.getNumber());			
			if (answer != dict.get(question) && answer != 0 && answer != 5) {	
				point -= 300;
				app.label1.setText(badAnswer.get(new Random().nextInt(badAnswer.size())) + "У тебя: " + point + " очков");
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
				if (point <= 0) {
					app.label.setText(name + ", GAME OVER!!!!");
					break;
				}
			}
			else if (answer == 0) {
				lastAns = answer;
				lastQuest = question;
				app.label.setText(e.help);
			}
			else if (answer == 5) {
				if (point <= 500)
					app.label1.setText("У тебя недостаточно очков, чтобы взять подсказку");
				else {			
					e.getHint(app, question, dict.get(question));
					point-=500;
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