package up.erp.service.model;

public class ErrorTokenCulqi {

    private String object;
    private String type;
    private String merchant_message;
    private String user_message;
    // getters and setters


    public ErrorTokenCulqi() {
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMerchant_message() {
        return merchant_message;
    }

    public void setMerchant_message(String merchant_message) {
        this.merchant_message = merchant_message;
    }

    public String getUser_message() {
        return user_message;
    }

    public void setUser_message(String user_message) {
        this.user_message = user_message;
    }


}