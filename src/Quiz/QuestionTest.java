//package Quiz;
//
//import org.junit.Test;
//import java.util.Map;
//import static org.junit.Assert.assertEquals;
//
//
//
//public class QuestionTest {
//    @Test
//    public void readFile() throws FileException{
//        Question quest = new Question();
//        quest.readFile("1");
//        assertEquals("1.txt", quest.theme1);
//
//    }
//
//    @Test
//    public void getAnswer() throws FileException {
//        assertEquals("Ты на верном пути к своему миллиону!", new Question().getAnswer("GoodAnswer.txt").get(1));
//    }
//
//    @Test
//    public void getList() throws FileException {
//        Question reader = new Question();
//        reader.readFile("2");
//        Map<String, String> dict = reader.getList();
//        assertEquals("4", dict.get("В какое море не впадает ни одной реки? :1.Желтое; 2.Балтийское; 3.Черное; 4.Красное"));
//    }
//}