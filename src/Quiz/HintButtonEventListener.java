package Quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HintButtonEventListener implements ActionListener {
    private Window window;
    HintButtonEventListener(Window w) { window = w; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == window.hintButton) {
            if (window.game.point < 300)
                window.label1.setText("У тебя недостаточно очков");
            else{
                window.game.correctAnswer("hint");
                window.setMessage(window.game.getQuest().text, window.game.getHint());
            }
        }
    }
}
