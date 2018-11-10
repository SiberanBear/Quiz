package Quiz;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.*;

class GameQuiz {

    private int lastAns = 1;
    private String lastQuest;
    int choise = 1;
    private String qq;
    private String botAnswer;
    private String hint;
    String number = "0";
    int point;

    //int answer = 0; первое нажатие кнопки для выбора тематики
//Может вызывать вопрос отдельно, потом нажимать на кнопку, а затем передавать в quiz вопрос и ответ?
    void gameQuiz(Map<String, Integer> dict, List<String> questList, List<String> goodAnswer, List<String> badAnswer, Event e) {
        point = 0;
        choise = questList.size();
        String question;
        while(true) {
            if (choise == 0) {
                break;
            }
            question = e.selectQuest(choise, lastAns, lastQuest, questList);
            String [] s = question.split(":");
            String[] s1 = s[1].split(";");
            setQ(", " + s[0] + "<br>" + s1[0] + s1[1] + "<br>" + s1[2] + s1[3]);
            int answer = Integer.parseInt(number);
            while(answer == 0) {
                yield();
                answer = Integer.parseInt(getAnswer());
            }
            number = "0";
            if (answer != dict.get(question) && answer != 5 && answer != 8) {
                point -= 300;
                setBotAnswer("<html>" + badAnswer.get(new Random().nextInt(badAnswer.size()))
                        + "<br>У тебя: " + point + " очков</html>");
                Collections.swap(questList, questList.indexOf(question), choise-1);
                choise--;
                if (point < 0)
                    break;
            }
            else if (answer == 5) {
                if (point >= 300){
                    setHint(e.getHint(question, dict.get(question)));
                    point-=300;
                }
                this.lastAns = answer;
                this.lastQuest = question;
            }
            else {
                this.lastAns = answer;
                point+=100;
                setBotAnswer("<html>" + goodAnswer.get(new Random().nextInt(goodAnswer.size()))
                        + "<br>У тебя: " + point + " очков</html>");
                Collections.swap(questList, questList.indexOf(question), choise-1);
                choise--;
            }
        }
    }
    private void setQ(String q) { qq = q; }
    String getQ() { return qq; }

    void setAnswer(String num) {
        number = num;
    }
    private String getAnswer() {
        return number;
    }

    private void setHint(String h) {
        hint = h;
    }
    String getHint() {
        return hint;
    }

    private void setBotAnswer(String a) {
        botAnswer = a;
    }
    String getBotAnswer() {
        return botAnswer;
    }


}