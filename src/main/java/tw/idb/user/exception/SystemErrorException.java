package tw.idb.user.exception;

public class SystemErrorException extends RuntimeException {

    public SystemErrorException() {
        super();
    }

    public SystemErrorException(String message) {
        super(message);
    }
}
