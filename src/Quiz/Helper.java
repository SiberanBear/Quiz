package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Helper {
    private String number = "0";
    ReadFile reader;
    void startGame(GameQuiz game, Helper helper) throws FileException {
        reader = new ReadFile();
        reader.readFile(number);
        List <Question> questList = reader.getList();
        List<String> goodAnswer = reader.getAnswer("GoodAnswer.txt");
        List<String> badAnswer = reader.getAnswer("BadAnswer.txt");
        game.gameQuiz(questList, goodAnswer, badAnswer, helper);
    }

    Question selectQuest(int choise, String lastAns, Question lastQuest, List<Question> questList) {
        if (lastAns.equals("hint")) {
            return lastQuest;
        } else
            return questList.get(new Random().nextInt(choise));
    }

    String getHint(Question question, String answer) {
        List<String> ans = new ArrayList<>();
        List<String> notAns = new ArrayList<>();
        for (Question.Answer i : question.answers) {
            if (i.text.contains(answer))
                ans.add(i.text);
            else
                notAns.add(i.text);
        }
        ans.add(notAns.get(new Random().nextInt(notAns.size())));
        if (Integer.parseInt(ans.get(0).substring(0, 1)) >
                Integer.parseInt(ans.get(1).substring(0, 1)))
            return question.text + ans.get(1) + ans.get(0);
        return question.text + ans.get(0) + ans.get(1);
    }

    void setTheme(String s) { number = s; }
    String getTheme() { return number; }
}
