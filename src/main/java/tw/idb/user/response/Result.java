package tw.idb.user.response;

import tw.idb.user.constant.ResultCode;
import tw.idb.user.constant.ResultMessage;

public class Result {

    private String result;
    private String message;

    public Result() {
        setResult(ResultCode.SUCCESS);
        setMessage(ResultMessage.SUCCESS);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
