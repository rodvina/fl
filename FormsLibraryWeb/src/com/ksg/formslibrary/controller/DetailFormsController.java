package com.ksg.formslibrary.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ksg.formslibrary.domain.Form;
import com.ksg.formslibrary.domain.SearchCriteria;
import com.ksg.formslibrary.service.FormsLibraryService;
import com.ksg.formslibrary.service.FormsLibraryServiceException;

/**
 * Controller class for rendering form details.
 *
 */
@Controller
@RequestMapping(value = "/details")
@SessionAttributes(value = {"searchCriteria", "searchResults"})
public class DetailFormsController {
	private static final Logger log = Logger.getLogger(DetailFormsController.class);

	@Autowired
	@Qualifier("mock")
	private FormsLibraryService formsLibraryService;

	
	/**
	 * Returns initial command object for form
	 * @return <code>SearchCriteria</code>
	 */
	@ModelAttribute(value="searchCriteria")
	public SearchCriteria setupSearchCriteria() {
		return new SearchCriteria();
	}	
	
	/**
	 * Returns initial command object for search results
	 * @return
	 */
	@ModelAttribute(value="searchResults")
	public List<Form> setupSearchResults() {
		log.info("getting ModelAttribute for searchResults...");
		return new ArrayList<Form>();
	}
	
	/**
	 * Returns initial command object for form results
	 * @return
	 */
	@ModelAttribute(value="formDetails")
	public List<Form> getFormDetails() {
		log.info("getting ModelAttribute for formDetails...");
		return new ArrayList<Form>();
	}
	
	@ModelAttribute(value="theform")
	public Form getTheForm() {
		log.info("getting ModelAttribute for the form...");
		return new Form();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String showFormDetails(Model model) {
		log.info("@RequestMapping...show detailsView");
		log.info("model contains searchResults?: " + model.containsAttribute("searchResults"));
		log.info("model contains searchCriteria?: " + model.containsAttribute("searchCriteria"));
		log.info("model contains theForm?: " + model.containsAttribute("theform"));


		return "detailsView";
	}
	
	@RequestMapping(params="action=submitDetail")
	public void processFormDetails(@RequestParam String formname,
			SessionStatus sessionStatus, Model model) {
		log.info("@ActionMapping...viewFormDetails of formNumber: " + formname);
		
		List<Form> forms = null;
		try {
			forms = formsLibraryService.searchDetail(formname);
		} catch (FormsLibraryServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("formDetails", forms);

	}
	
}
