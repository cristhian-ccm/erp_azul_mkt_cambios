package up.erp.service.model;
import java.io.Serializable;


public class ResponseModel implements Serializable {

    private String object;
    private String id;
    // getters and setters


    public ResponseModel(String object, String id) {
        this.object = object;
        this.id = id;
    }
}