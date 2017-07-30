package com.igate;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class SQLDateEditor extends PropertyEditorSupport {

	public SQLDateEditor() { }
	
	public void setAsText(String text) {
		if(text.equalsIgnoreCase("getdate()")) {
			Date date = new Date(System.currentTimeMillis());
			setValue(date);
		}
		else {
			setValue(Date.valueOf(text));
		}	
	}
	
	public String getAsText() {
		return getValue().toString();
	}	
}
