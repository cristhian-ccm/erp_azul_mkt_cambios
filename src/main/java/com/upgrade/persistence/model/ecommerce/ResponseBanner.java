package com.upgrade.persistence.model.ecommerce;

import java.util.Date;

public class ResponseBanner {

    public String url_imagen;
    public String url_redirec;
    public Date fecha_fin;

    public ResponseBanner() {
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getUrl_redirec() {
        return url_redirec;
    }

    public void setUrl_redirec(String url_redirec) {
        this.url_redirec = url_redirec;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
