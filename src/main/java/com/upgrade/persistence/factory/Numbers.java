/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.factory;

import java.math.BigDecimal;

/**
 *
 * @author rednave
 */
public class Numbers {
    
    public static BigDecimal getBigDecimal(String val, int precision) {
        BigDecimal bd = new BigDecimal(val);
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
    public static BigDecimal getBigDecimal(BigDecimal val, int precision) {
        BigDecimal bd = val;
        bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
    
    public static BigDecimal getBigDecimalRoundUp(BigDecimal val, int precision) {
        BigDecimal bd = val;
        bd = bd.setScale(precision, BigDecimal.ROUND_UP);
        return bd;
    }
    
    public static BigDecimal divide(BigDecimal dividendo, BigDecimal divisor, int precision) {
        return dividendo.divide(divisor,precision, BigDecimal.ROUND_HALF_UP);
    }   
}