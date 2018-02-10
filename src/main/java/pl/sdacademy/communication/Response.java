package pl.sdacademy.communication;

public class Response {
    private boolean isSuccess;
    private String message;

    public static Response isSuccessful() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }
    public static Response isNotSuccessful(String failure){
        Response response = new Response();
        response.setMessage(failure);
        response.setSuccess(false);
        return response;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
