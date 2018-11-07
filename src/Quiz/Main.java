package Quiz;
import java.io.*;
public class Main 
{
	// {Имя:ввод}
	// GUI
	public static void main(String[] args) throws IOException, FileException, InterruptedException {
//		Event event = new Event();
//		GameQuiz gameQuiz = new GameQuiz();
//		GUI app = new GUI(event, gameQuiz);
//		app.setVisible(true);
//		GUI app1 = new GUI(event, gameQuiz);
//		app1.setVisible(true);
		//event.startGame(app.name, gameQuiz, event);
		Thread t1 = new Thread(new GUI(new Event(), new GameQuiz()));
		Thread t2 = new Thread(new GUI(new Event(), new GameQuiz()));
		t1.start();
		//t2.start();
	}
}
