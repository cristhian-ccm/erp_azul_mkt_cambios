package up.erp.view.exporter;


public class FloatData extends Data {
	
	public Float value;
	
	public FloatData() {
	}
	
	public FloatData(float value) {
		this.value = value;
	}
	
        public Float get_Value(){
            return this.value;
        }
	
        public void set_Value(Float value){
            this.value = value;
        }
	

}