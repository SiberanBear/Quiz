package Quiz;
import java.io.*;
import java.util.*;
public class Quiz 
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Приветствую Вас в нашей викторине!\nВведите Ваше имя:");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("Приятно познакомиться, " + name + "!\nГотов вступить в незабываемую схватку с ИИ? Или у тебя ещё остались вопросы?");
		System.out.println("Для ответа на вопросы используйте клавиши от 1 до 4. Справка вызывается по нажатию клавиши 0");	
		Event s = new Event(name);	
	}
}