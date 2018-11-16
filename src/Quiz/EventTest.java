//package Quiz;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//public class EventTest {
//
//    @org.junit.Test
//    public void selectQuest() {
//        List<String> questList = new ArrayList <>();
//        questList.add("Сколько ступеней на лестнице, по которой нельзя подняться?");
//        assertEquals("Сколько ступеней на лестнице, по которой нельзя подняться?",
//                new Helper().selectQuest(1, "", "", questList ));
//    }
//
//    @org.junit.Test
//    public void getHint() {
//        assertEquals("Какое имя у Демидовича?  3.Борис 4.Иван",
//                new Helper().getHint("Какое имя у Демидовича? : 3.Борис; 4.Иван", "3"));
//
//    }
//}