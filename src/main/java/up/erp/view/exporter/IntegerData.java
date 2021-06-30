package up.erp.view.exporter;


public class IntegerData extends Data {
	
	public Integer value;
	
	public IntegerData() {
	}
	
	public IntegerData(Integer value) {
		this.value = value;
	}
	
	public Integer get_Value(){
            return this.value;
        }
	
        public void set_Value(Integer value){
            this.value = value;
        }

}