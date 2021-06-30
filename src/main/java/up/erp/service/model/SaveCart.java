package up.erp.service.model;
import java.io.Serializable;


public class SaveCart implements Serializable {

    private Integer usuariow_id;
    private String cods;

    public SaveCart() {
    }

    public Integer getUsuariow_id() {
        return usuariow_id;
    }

    public void setUsuariow_id(Integer usuariow_id) {
        this.usuariow_id = usuariow_id;
    }

    public String getCods() {
        return cods;
    }

    public void setCods(String cods) {
        this.cods = cods;
    }
}