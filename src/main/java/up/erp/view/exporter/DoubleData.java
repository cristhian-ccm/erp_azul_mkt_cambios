package up.erp.view.exporter;


public class DoubleData extends Data {
	
	public Double value;
	
	public DoubleData() {
	}
	
	public DoubleData(Double value) {
		this.value = value;
	}
	
	public Double get_Value(){
            return this.value;
        }
	
        public void set_Value(Double value){
            this.value = value;
        }

}