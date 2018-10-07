package Quiz;

public class FileException extends Exception{
	public FileException(Throwable cause, String message) {
		super(cause);
		System.err.println("Данный файл не найден");
		}
	
	public FileException(String message){
		System.out.println(message);
	}
}
