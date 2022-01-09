package inacio;

public class WeakPasswordException extends Exception {
    public WeakPasswordException(String errorMessage) {
        //You can call the parent constructor by using super.
        super(errorMessage);
    }
}
