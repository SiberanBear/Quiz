package Quiz;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

public class QuizTests {

	@Test
	public void test() throws IOException {
		HashMap<String, Integer> dict = new Question("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\TestQwest.txt").getDict();	
		assertEquals(2, dict.get("� ����� �� ���� ����� ����� �� ��������? 1.������ 2.������� 3.������� 4.��������").intValue());
		assertEquals(4, dict.get("� ����� ���� �� ������� �� ����� ����? 1.������ 2.���������� 3.������ 4.�������").intValue());
	}
	
	@Test
	public void failtest() throws IOException {
		HashMap<String, Integer> dict = new Question("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\TestQwest.txt").getDict();	
		assertNotEquals(4, dict.get("� ����� �� ���� ����� ����� �� ��������? 1.������ 2.������� 3.������� 4.��������").intValue());
		assertNotEquals(2, dict.get("� ����� ���� �� ������� �� ����� ����? 1.������ 2.���������� 3.������ 4.�������").intValue());
	}
	
	@Test
	public void lenghttest() throws IOException {
		Question q = new Question("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\TestQwest.txt");
		assertEquals(q.answer.size(), q.qwest.size());
	}
}
