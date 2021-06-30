package up.erp.view.exporter;

import java.math.BigDecimal;

public class BigDecimalData extends Data {
	
	public BigDecimal value;
	
	public BigDecimalData() {
	}
	
	public BigDecimalData(BigDecimal value) {
		this.value = value;
	}
	
        public BigDecimal get_Value(){
            return this.value;
        }
	
        public void set_Value(BigDecimal value){
            this.value = value;
        }
	

}
