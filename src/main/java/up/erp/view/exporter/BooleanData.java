package up.erp.view.exporter;

import java.math.BigDecimal;

public class BooleanData extends Data {
	
	public Boolean value;
	
	public BooleanData() {
	}
	
	public BooleanData(Boolean value) {
		this.value = value;
	}
	
        public Boolean get_Value(){
            return this.value;
        }
	
        public void set_Value(Boolean value){
            this.value = value;
        }
	

}