package Quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NameButtonEventListener implements ActionListener {
    private NameWindow nameWindow;
    NameButtonEventListener(NameWindow nameW) { nameWindow = nameW; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameWindow.nameButton){
            nameWindow.name = nameWindow.input.getText();
            if (!nameWindow.name.equals("")) {
                new Window(nameWindow.helper, nameWindow.game, nameWindow.name).setVisible(true);
                nameWindow.setVisible(false);
            }
        }
    }
}
