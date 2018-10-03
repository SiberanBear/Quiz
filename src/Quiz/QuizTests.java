package Quiz;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

import org.junit.Test;

public class QuizTests {

	@Test
	public void test() throws FileException {
		Map<String, Integer> dict = new Question("2").getDict();	
		assertEquals(2, dict.get("С какой из этих стран Чехия НЕ граничит? 1.Польша 2.Венгрия 3.Австрия 4.Германия").intValue());
		assertEquals(4, dict.get("В какое море не впадает ни одной реки? 1.Желтое 2.Балтийское 3.Черное 4.Красное").intValue());
	}
	
	@Test
	public void failtest() throws FileException {
		Map<String, Integer> dict = new Question("2").getDict();	
		assertNotEquals(3, dict.get("С какой из этих стран Чехия НЕ граничит? 1.Польша 2.Венгрия 3.Австрия 4.Германия").intValue());
		assertNotEquals(2, dict.get("В какое море не впадает ни одной реки? 1.Желтое 2.Балтийское 3.Черное 4.Красное").intValue());
	}
}
