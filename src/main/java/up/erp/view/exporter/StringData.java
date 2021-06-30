package up.erp.view.exporter;


public class StringData extends Data {
	
	public String value;
	
	public StringData() {
	}
	
	public StringData(String value) {
		this.value = value;
	}
	
        public String get_Value(){
            return this.value;
        }
	
        public void set_Value(String value){
            this.value = value;
        }

}