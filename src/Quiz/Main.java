package Quiz;
public class Main
{
    public static void main(String[] args) {
        Thread t1 = new Thread(new GUI(new Event(), new GameQuiz()));
        //Thread t2 = new Thread(new GUI(new Event(), new GameQuiz()));
        t1.start();
        //t2.start();
    }
}
