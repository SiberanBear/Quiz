package Quiz;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameQuiz {
	
	public int lastAns = 1;
	public String lastQuest = null;
	int choise = 1;
	String question;
	String botAnswer; 
	String number;
	int point;
	boolean flag = false;
	//int answer = 0; первое нажатие кнопки для выбора тематики
	//Может вызывать вопрос отдельно, потом нажимать на кнопку, а затем передавать в quiz вопрос и ответ?
	public void gameQuiz(String name, Map<String, Integer> dict, List<String> questList, List<String> goodAnswer, List<String> badAnswer, Event e) throws FileException
	{	
		point = 0;
		choise = questList.size();		
		while(true) {
			if (choise == 0) {
				break;
			}
			question = e.selectQuest(choise, name, lastAns, lastQuest, questList);
			setQ(question);
			number = "0";
			System.out.println(question);
			int answer = Integer.parseInt(number);
			while(answer == 0) {
				Thread.yield();
				answer = Integer.parseInt(getAnswer());
			}
				
			System.out.println(answer);
			
			if (answer != dict.get(question) && answer != 6 && answer != 5 && answer != 8) {	
				point -= 300;
				botAnswer = badAnswer.get(new Random().nextInt(badAnswer.size())) + "У тебя: " + point + " очков";
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
				if (point < 0) {
					//app.label.setText(name + ", GAME OVER!!!!");
					break;
				}
			}
			else if (answer == 6 || answer == 8) {
				//app.label1.setText(e.help);
				this.lastAns = answer;
				this.lastQuest = question;			

			}
			else if (answer == 5) {
//				if (point <= 300)
//					app.label1.setText("У тебя недостаточно очков, чтобы взять подсказку");
//				else {			
//					e.getHint(app, question, dict.get(question));
//					point-=300;
//				}
				this.lastAns = answer;
				this.lastQuest = question;
			}
			else {
				this.lastAns = answer;
				point+=100;
				botAnswer = goodAnswer.get(new Random().nextInt(goodAnswer.size())) + "У тебя: " + point + " очков";
				Collections.swap(questList, questList.indexOf(question), choise-1);
				choise--;
			}
		}
	}
	public void setQ(String q) {
		question = q;
	}
	public String getQ() {
		return question;
	}
	
	
	public void setAnswer(String num) {
		number = num;
	}
	public String getAnswer() {
		return number;
	}
}