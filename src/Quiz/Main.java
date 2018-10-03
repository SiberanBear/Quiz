package Quiz;
import java.io.*;
import java.util.*;
public class Main 
{
	public static void main(String[] args) throws IOException, FileException
	{
		System.out.println("Привет! Для начала скажи, как я могу к тебе обращаться?");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("Приятно познакомиться, " + name + "!\nДавай сыграем! "
				+ "Правила очень простые: Я буду задавать вопросы, "
				+ "а тебе нужно будет выбрать из четырёх вариантов ответа единственно верный. \n"
				+ "За правильный ответ будет начислено 100 очков, за неправильный - отнято 300. "
				+ "Как выиграть? Останься в плюсе до конца! Удачной игры!");
		System.out.println("Для ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");	
		Event s = new Event(name);
		Question creater = new Question(s.selectTheme);
		Map<String, Integer> dict = creater.getDict();
		List<String> quest = creater.getQwest();
		s.gameQuiz(quest, dict, name);
		enter.close();	
	}
}