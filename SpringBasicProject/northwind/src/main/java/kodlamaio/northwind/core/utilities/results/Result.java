package kodlamaio.northwind.core.utilities.results;

public class Result {  //Base class
    private boolean success;
    private String message;

    public Result(boolean success) {

        this.success = success;
    }

    public Result(boolean success, String message) {

        this(success);// tek parametreli constructor ı çağırdı
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
