/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar;

import com.upgrade.persistence.model.lgstc.OrdenCDet;

import java.io.Serializable;

/**
 *
 * @author darko
 */
public class OrdenCompraModel implements Serializable{
    public OrdenCDet ordenCompraDet;
    public int Facturados;

    public OrdenCompraModel() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordenCompraDet == null) ? 0 : ordenCompraDet.hashCode());
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
		OrdenCompraModel other = (OrdenCompraModel) obj;
		if (ordenCompraDet == null) {
			if (other.ordenCompraDet != null)
				return false;
		} else if (!ordenCompraDet.equals(other.ordenCompraDet))
			return false;
		return true;
	}

    
}
