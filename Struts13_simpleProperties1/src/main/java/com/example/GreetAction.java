package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.struts.util.MessageResources;

public class GreetAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        GreetForm greetForm = (GreetForm) form;
        String name = greetForm.getName();
        System.out.println(name);
        request.setAttribute("name", name);

        MessageResources resources = getResources(request);
//        String name= "john";
        String greetingMessage = resources.getMessage(request.getLocale(), "greeting.message",new Object[] { name });
        System.out.println(greetingMessage);
		request.setAttribute("greetingMessage", greetingMessage);
    
        return mapping.findForward("success");
        
}}
