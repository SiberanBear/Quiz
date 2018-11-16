package Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpButtonEventListener implements ActionListener {
    private JButton helpButton;
    HelpButtonEventListener(JButton helpBtn) { helpButton = helpBtn; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == helpButton){
            JOptionPane.showMessageDialog(null,
                    "Правила очень простые: Я буду задавать вопросы, \n"
                            + "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
                            + "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. \n"
                            + "Так же я могу немного помочь. Но увы не бесплатно. Цена в 300 очков меня вполне устроит. \n"
                            + "Как выиграть? Останься в плюсе до конца! Удачной игры!");
        }
    }
}
