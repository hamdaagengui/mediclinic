/**
 * 
 */
package com.mediapp.web.controller.common;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author A461353
 *
 */
public class LoginController extends MediAppBaseController {

	public ModelAndView onSubmit(Object command) throws ServletException {
        //return new ModelAndView(new RedirectView());
		return new ModelAndView(getSuccessView());
    }
}