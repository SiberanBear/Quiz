package Quiz;

class FileException extends Exception{
    FileException(Throwable cause, String message) {
        super(cause);
    }

    FileException(){
        super();
    }
}
