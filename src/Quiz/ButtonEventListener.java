package Quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener implements ActionListener {
    private Window window;
    private Question quest;
    ButtonEventListener(Window w) { window = w; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.helper.getTheme().equals("0")) {
            if (e.getSource() == window.answer1Button)
                window.helper.setTheme(window.answer1Button.getText());
            else if (e.getSource() == window.answer2Button)
                window.helper.setTheme(window.answer2Button.getText());
            try {
                window.helper.startGame(window.game, window.helper);
            } catch (FileException e1) {
                e1.printStackTrace();
            }
        }
        else {
            if(e.getSource() == window.answer1Button)
                window.game.correctAnswer(window.answer1Button.getText());
            else if (e.getSource() == window.answer2Button)
                window.game.correctAnswer(window.answer2Button.getText());
            else if (e.getSource() == window.answer3Button)
                window.game.correctAnswer(window.answer3Button.getText());
            else if (e.getSource() == window.answer4Button)
                window.game.correctAnswer(window.answer4Button.getText());

        }
        if (window.game.choise == 0 && window.game.point >= 0)
            window.setMessage(", You win!", "Вы набрали " + window.game.point + " очков!");

        else if (window.game.point < 0)
            window.setMessage(", Game over!", "У вас " + window.game.point + " очков");
        else {
            quest = window.game.getQuest();
            window.setMessage(quest.text, window.game.getBotAnswer());
            window.answer1Button.setText(quest.answers[0].text);
            window.answer2Button.setText(quest.answers[1].text);
            window.answer3Button.setText(quest.answers[2].text);
            window.answer4Button.setText(quest.answers[3].text);
        }
    }
}