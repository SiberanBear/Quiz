package Quiz;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {

    @org.junit.Test
    public void selectQuest() {
        List<String> questList = new ArrayList <>();
        questList.add("Сколько ступеней на лестнице, по которой нельзя подняться?");
        assertEquals("Сколько ступеней на лестнице, по которой нельзя подняться?",
                new Event().selectQuest(1, 0, "", questList ));
    }

    @org.junit.Test
    public void getHint() {
        assertEquals("Какое имя у Демидовича?  4.Иван 3.Борис",
                new Event().getHint("Какое имя у Демидовича? : 3.Борис; 4.Иван", 3));

    }
}