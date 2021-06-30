/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar;

import com.upgrade.persistence.model.planestrategico.CuotaParticular;

import java.util.Objects;

/**
 *
 * @author JCARLOS TIPO
 */
public class CuotaParticularModel {
    
    public CuotaParticular cuotaParticular;
    public double total;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuotaParticularModel other = (CuotaParticularModel) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.cuotaParticular, other.cuotaParticular)) {
            return false;
        }
        return true;
    }

    
    
}
