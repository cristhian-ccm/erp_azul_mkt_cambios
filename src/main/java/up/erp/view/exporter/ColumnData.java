package up.erp.view.exporter;

import java.io.Serializable;

public class ColumnData implements Serializable{
	
	public String name;
	public int width;
	
	public ColumnData() {
		// TODO Auto-generated constructor stub
	}
	
	public ColumnData(String name, int width) {
		this.name = name;
		this.width = width;
	}
        
        //----------------------------------------------------------------------
        
        public String get_Name(){
            return this.name;
        }
        
        public void set_Name(String name){
            this.name = name;
        }
	
        public int get_Width(){
            return this.width;
        }
        
        public void set_Width(int width){
            this.width = width;
        }

}
