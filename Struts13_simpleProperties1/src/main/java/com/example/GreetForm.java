package com.example;

import org.apache.struts.action.ActionForm;

public class GreetForm extends ActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "GreetForm [name=" + name + "]";
	}
    
}
