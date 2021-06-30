package up.erp.view.exporter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RowData implements Serializable {

	public Data[] data;
	private int pos = 0;
        
        //----------------------- Variables de Apoyo ---------------------------
        //--------------------------- BigDecimal -------------------------------
        List<BigDecimal> L_BigD = new ArrayList<>();
        List<Integer> L_BigD_it = new ArrayList<>();
        //----------------------------- Boolean --------------------------------
        List<Boolean> L_Bool = new ArrayList<>();
        List<Integer> L_Bool_it = new ArrayList<>();
        //----------------------------- Date -----------------------------------
        List<Date> L_Date = new ArrayList<>();
        List<Integer> L_Date_it = new ArrayList<>();
        //--------------------------- Double -----------------------------------
        List<Double> L_Doub = new ArrayList<>();
        List<Integer> L_Doub_it = new ArrayList<>();
	//----------------------------- String --------------------------------
        List<String> L_Str = new ArrayList<>();
        List<Integer> L_Str_it = new ArrayList<>();
        //----------------------------- Integer --------------------------------
        List<Integer> L_Int = new ArrayList<>();
        List<Integer> L_Int_it = new ArrayList<>();
        //----------------------------- Float ----------------------------------
        List<Float> L_Float = new ArrayList<>();
        List<Integer> L_Float_it = new ArrayList<>();
        //----------------------------------------------------------------------
        
	public RowData() {
            // TODO Auto-generated constructor stub
	}
	
	public RowData(int size) {
            data = new Data[size];
            pos = 0;
	}
	
        //-------------------------------- ADD ---------------------------------
	public RowData add(Object value) {
            if (value instanceof BigDecimal) {
                return add((BigDecimal) value);
            }

            if (value instanceof Boolean) {
                    return add((Boolean) value);
            }
            if (value instanceof Date) {
                    return add((Date) value);
            }
            if (value instanceof Double) {
                    return add((Double) value);
            }
            if (value instanceof String) {
                    return add((String) value);
            }
            if (value instanceof Integer) {
                    return add((Integer) value);
            }
            if (value instanceof Float) {
                    return add((Float) value);
            }
            return this;
	}
	//-------------------------------- ADD ---------------------------------
	public RowData add(BigDecimal value) {
            data[pos] = new BigDecimalData(value);
            L_BigD.add(value);
            L_BigD_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(Boolean value) {
            data[pos] = new BooleanData(value);
            L_Bool.add(value);
            L_Bool_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(Date value) {
            data[pos] = new DateData(value);
            L_Date.add(value);
            L_Date_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(Double value) {
            data[pos] = new DoubleData(value);
            L_Doub.add(value);
            L_Doub_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(Integer value) {
            data[pos] = new IntegerData(value);
            L_Int.add(value);
            L_Int_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(Float value) {
            data[pos] = new FloatData(value);
            L_Float.add(value);
            L_Float_it.add(pos);
            pos++;
            return this;
	}
	
	public RowData add(String value) {
            data[pos] = new StringData(value);
            L_Str.add(value);
            L_Str_it.add(pos);
            pos++;
            return this;
	}

        //-------------------------------- GET ---------------------------------
        /*
        public String get_Type(int p){
            String ref = "";
            ref = this.data[p].getClass().getTypeName();
            System.out.println("Type Encontrado:" + ref);
            return ref;
        }
        
        public Data get_Value(int p){
            String ref = "";
            ref = get_Type(p);
            if (ref.contentEquals("BigDecimal")) {
           
            }
            
            if (ref.contentEquals("Boolean")) {
                return (BooleanData) this.data[p];
            }
            
            if (ref.contentEquals("Date")) {
                return (DateData) this.data[p];
            }
            
            if (ref.contentEquals("Double")) {
                return (DoubleData) this.data[p];
            }
            
            if (ref.contentEquals("Integer")) {
                return (IntegerData) this.data[p];
            }
            
            if (ref.contentEquals("Float")) {
                return (FloatData) this.data[p];
            }
            
            if (ref.contentEquals("String")) {
                return (StringData) this.data[p];
            }
            
            return this.data[p];
        }
        
        public Boolean check_pos_LBigD(int pos){
            Boolean r = Boolean.FALSE;
            
            for(int i = 0; i < L_BigD_it.size(); i++){
                if(pos == L_BigD_it.get(i))
                    r = Boolean.TRUE;
            }
            return r;
        }
        */
        public BigDecimal get_Value_BigD(int p){
            BigDecimal resp = null;
            resp = L_BigD.get(p);
            return resp;
        }
        
        public Boolean get_Value_Bool(int p){
            Boolean resp = Boolean.FALSE;
            resp = L_Bool.get(p);
            return resp;
        }
        
        public Date get_Value_Date(int p){
            Date resp = new Date();
            resp = L_Date.get(p);
            return resp;
        }
        
        public Double get_Value_Double(int p){
            Double resp = 0.00;
            resp = L_Doub.get(p);
            return resp;
        }
        
        public Integer get_Value_Integer(int p){
            Integer resp = 0;
            resp = L_Int.get(p);
            return resp;
        }
        
        public Float get_Value_Float(int p){
            Float resp = null;
            resp = L_Float.get(p);
            return resp;
        }
        
        public String get_Value_String(int p){
            String resp = "";
            resp = L_Str.get(p);
            return resp;
        }
        
}
