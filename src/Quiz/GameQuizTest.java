//package Quiz;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//public class GameQuizTest {
//
//    @Test
//    public void gameQuiz() {
//        GameQuiz gameQuiz = new GameQuiz();
//        gameQuiz.number = "3";
//        Map<String, String> dict = new HashMap <>();
//        List<String> questLust = new ArrayList <>();
//        dict.put("Третья планета от Солнца :1.Меркурий; 2.Плутон; 3.Земля; 4.Марс", "3");
//        questLust.add("Третья планета от Солнца :1.Меркурий; 2.Плутон; 3.Земля; 4.Марс");
//        gameQuiz.gameQuiz(dict, questLust, questLust, questLust, new Helper());
//        assertEquals(100, gameQuiz.point);
//    }
//}