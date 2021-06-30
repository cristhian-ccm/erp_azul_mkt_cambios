package com.upgrade.persistence.model.ecommerce;

import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;




@TableDB(name="ecommerce.bannerTable")
public class BannerOb implements Serializable{

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "nombreComent")
    public String nombreComent;

  
    @FieldDB(value = "url_banner")
    public String url_banner;

    @FieldDB(value = "activo")
    public Boolean activo;

    @FieldDB(value = "url_reDirec")
    public String url_reDirec;


////////
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//////////////


public String getnombreComent() {
    return nombreComent;
}

public void setnombreComent(String nombreComent) {
    this.nombreComent = nombreComent;
}





/////////////

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /////////////////

    public String getUrl_banner() {
        return url_banner;
    }

    public void setUrl_banner(String url_banner) {
        this.url_banner = url_banner;
    }


    public String geturl_reDirec() {
        return url_reDirec;
    }

    public void seturl_reDirec(String url_reDirec) {
        this.url_reDirec = url_reDirec;
    }  








    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatalogoPuntos other = (CatalogoPuntos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }





    
}
