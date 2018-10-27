package Quiz;
import java.io.*;
public class Main 
{
	// {Имя:ввод}
	// GUI
	public static void main(String[] args) throws IOException, FileException, InterruptedException {
		Thread t1 = new Thread(new Event());
		Thread t2 = new Thread(new Event());
		t1.start();
//		t2.start();
	}
}