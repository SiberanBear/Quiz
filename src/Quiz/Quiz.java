package Quiz;
import java.io.*;
import java.util.*;
public class Quiz 
{//подсказки жизни(бальная система)
	public static void main(String[] args) throws IOException
	{
		File lol = new File("C:\\Users\\Pasha\\eclipse-workspace\\Quiz\\2.txt");
		FileReader fr = new FileReader(lol);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        ArrayList<String> qwest = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        while (line != null) {
        	if (line.length() == 1)
        		answer.add(line);
        	else
        		qwest.add(line);
        	line = reader.readLine();
        }
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (int i = 0; i < qwest.size() || i < answer.size(); i++)
        	dict.put(qwest.get(i), Integer.parseInt(answer.get(i)));
		System.out.println("Приветствую Вас в нашей викторине!\nВведите Ваше имя:");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("Для ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");
		int point = 0;
		System.out.println("Приятно познакомиться, " + name + "!\nГотов вступить в незабываемую схватку с ИИ? Или у тебя ещё остались вопросы?");
		int choise = enter.nextInt();
		while(true) 
		{
			if (qwest.isEmpty()) 
			{
				System.out.println("YOU WIN!!!");
				break;
			}
			if (choise == 1) 
			{
				String vopros = qwest.get(new Random().nextInt(qwest.size()));
				System.out.println(vopros);
				int asd1 = enter.nextInt();
				if (asd1 != dict.get(vopros) && asd1 != 0) 
				{
					System.out.println(name + ", GAME OVER!!!!");
					break;
				}
				else if (asd1 == 0)
					System.out.println("Тут всё легко. Отвечаешь на вопросы и зарабатываешь очки");
				else
				{
					point+=100;
					System.out.println("Молодец, у тебя " + point + " очков");
					qwest.remove(vopros);
				}
			}
			else if(choise == 0) 
			{
				System.out.println("Тут всё легко. Отвечаешь на вопросы и зарабатываешь очки");
			}
		}
	}
}