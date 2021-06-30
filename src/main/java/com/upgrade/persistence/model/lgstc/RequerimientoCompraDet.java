package com.upgrade.persistence.model.lgstc;

import com.upgrade.persistence.model.extcs.Producto;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

@TableDB(name="lgstc.requerimiento_compra_det", sequence="lgstc.requerimiento_compra_det_id_seq")
public class RequerimientoCompraDet implements Serializable{
	
	public Integer id;
	public String creador;
	public Boolean activo;
	@FieldDB("requerimiento_compra")
	public RequerimientoCompra requerimientoCompra;
	public Producto producto;
	public Integer cantidad;
	
	public RequerimientoCompraDet() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequerimientoCompraDet other = (RequerimientoCompraDet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
