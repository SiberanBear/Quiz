package Quiz;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

class GameQuiz {
    private String lastAns = "1";
    private Question lastQuest;
    int choise = 1;
    private String qq;
    private String botAnswer;
    private String hint;
    private Question question;
    private Map<String, String> dict;
    private List<Question> questList;
    private List<String> goodAnswer;
    private List<String> badAnswer;
    private Helper helper;
    int point;

    void gameQuiz(List<Question> quest, List<String> goodAns,
                  List<String> badAns, Helper help) {
        point = 0;
        questList = quest;
        goodAnswer = goodAns;
        badAnswer = badAns;
        choise = questList.size();
        helper = help;
    }

    Question getQuest(){
        if (choise == 0)
            return null;
        question = helper.selectQuest(choise, lastAns, lastQuest, questList);
        return question;
    }

    void correctAnswer(String number)
    {
        if (!number.contains(question.correctAnswer) && !number.equals("hint")) {
            point -= 300;
            setBotAnswer("<html>" + badAnswer.get(new Random().nextInt(badAnswer.size()))
                    + "<br>У тебя: " + point + " очков</html>");
            Collections.swap(questList, questList.indexOf(question), choise-1);
            choise--;
        }
        else if (number.equals("hint")) {
            if (point >= 300){
                //setHint(helper.getHint(question, dict.get(question)));
                point-=300;
            }
            this.lastAns = number;
            this.lastQuest = question;
        }
        else {
            this.lastAns = number;
            point+=100;
            setBotAnswer("<html>" + goodAnswer.get(new Random().nextInt(goodAnswer.size()))
                    + "<br>У тебя: " + point + " очков</html>");
            Collections.swap(questList, questList.indexOf(question), choise-1);
            choise--;
        }
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