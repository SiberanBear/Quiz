package Quiz;
public class Main
{
    public static void main(String[] args) {
        new NameWindow(new Helper(), new GameQuiz());
        //new NameWindow(new Helper(), new GameQuiz());
//        Thread t1 = new Thread(new NameWindow(new Helper(), new GameQuiz()));
//        Thread t2 = new Thread(new NameWindow(new Helper(), new GameQuiz()));
//        t1.start();
//        t2.start();
    }
}
