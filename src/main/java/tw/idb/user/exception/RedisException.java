package tw.idb.user.exception;

public class RedisException extends RuntimeException {

    public RedisException() {
        super();
    }

    public RedisException(String message) {
        super(message);
    }
}
