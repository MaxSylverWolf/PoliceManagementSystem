package myapp.spring.domain;

import java.beans.PropertyEditorSupport;

public class AccessoryWebEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException { 
    	
        Accessory a = new Accessory(); 
        a.setId(Long.parseLong(text));
        setValue(a);  
    }      
    
    @Override  
    public String getAsText() {
       
        Accessory accessory = (Accessory) getValue();
        return accessory == null ? null :  Long.toString(accessory.getId());  
    }      

}
