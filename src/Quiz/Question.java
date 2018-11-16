package Quiz;

class Question {
    String text;
    Answer[] answers;
    String correctAnswer;
    Question(String lastQ, String lastA){
        String[] s = lastQ.split(":");
        String[] s1 = s[1].split(";");
        text = s[0];
        correctAnswer = lastA;
        answers = new Answer[s1.length];
        for (int i = 0; i < s1.length; i++)
            answers[i] = new Answer(s1[i]);

    }

    public class Answer {
        String text;
        Answer(String s){
            text = s;
        }
    }
    @Override
    public String toString(){
        return answers[0].text + answers[1].text + answers[2].text + answers[3].text;
    }
}

