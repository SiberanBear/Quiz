package Quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

class Event {
    private String number = "0";
    String hint = null;

    
    void startGame(String name, GameQuiz game, Event e) throws FileException {
        Question creater = new Question();
        while (number.equals("0")) {
            Thread.yield();
            number = getNumber();
        }
        creater.readFile(number);
        Map<String, Integer> dict = creater.getDict();
        List <String> questList = creater.getQwest();
        List<String> goodAnswer = creater.getAnswer("GoodAnswer.txt");
        List<String> badAnswer = creater.getAnswer("BadAnswer.txt");
        game.gameQuiz(dict, questList, goodAnswer, badAnswer, e);
    }

    String selectQuest(int choise, int lastAns, String lastQuest, List<String> questList) {
        String question;
        if (lastAns == 5) {
            return lastQuest;
        } else
            question = questList.get(new Random().nextInt(choise));
        return question;
    }

    String getHint(String question, int answer) {
        String[] s = question.split(":");
        String[] s1 = s[1].split(";");
        List<String> ans = new ArrayList<>();
        List<String> notAns = new ArrayList<>();
        for (String i : s1) {
            if (i.contains(Integer.toString(answer)))
                ans.add(i);
            else
                notAns.add(i);
        }
        ans.add(notAns.get(new Random().nextInt(notAns.size())));
        return s[0] + ans.get(1) + ans.get(0);
    }


    void setNumber(String s) {
        number = s;
    }
    String getNumber() { return number; }
}