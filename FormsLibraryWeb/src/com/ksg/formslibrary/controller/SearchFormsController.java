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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksg.formslibrary.domain.Form;
import com.ksg.formslibrary.domain.ListValues;
import com.ksg.formslibrary.domain.SearchCriteria;
import com.ksg.formslibrary.service.FormsLibraryService;
import com.ksg.formslibrary.service.FormsLibraryServiceException;
import com.ksg.formslibrary.service.ListValueService;
import com.ksg.formslibrary.util.FormBuilder;



/**
 * Controller class responsible for processing portlet requests
 * for the search functionality.  Renders search page, processes search
 * requests, renders search and results
 *
 */
@Controller("searchFormController")
@RequestMapping(value = "/search")
public class SearchFormsController {
	private static final Logger log = Logger.getLogger(SearchFormsController.class);

	@Autowired
	private ListValueService listValueService;
	
	@Autowired
	@Qualifier("mock")
	private FormsLibraryService formsLibraryService;

	
	@RequestMapping(method=RequestMethod.GET)
	public String showSearchCriteria(Model model) {

		return "searchView";
	}
	
	@RequestMapping(params="action=showForms")
	public String showSearchResults(Model model) {
//		SearchResults searchResults = new SearchResults(new ArrayList<Form>());
		log.info("@RenderMapping...doView");
		log.info("model contains searchResults?: " + model.containsAttribute("searchResults"));
		log.info("model contains searchCriteria?: " + model.containsAttribute("searchCriteria"));
		if (model.containsAttribute("searchResults")) {
			List<Form> results = (List<Form>) model.asMap().get("searchResults");
//			searchResults = (SearchResults) model.asMap().get("searchResults");
			log.info("Result count: " + results.size());
		}
//		return new FormBuilder().formNumber("AK234378")
//						.formTitle("FAIR CREDIT")
//						.formType("Endorsement")
//						.company("CO").build();
		return "searchView";
	}
	
	
	public @ResponseBody Form processAjax() {
		log.info("@ResourceMapping...processing Ajax");
		return new FormBuilder().formNumber("AK234378")
				.formTitle("FAIR CREDIT")
				.formType("Endorsement")
				.company("CO").build();
	}

	/**
	 * Returns reference data for list values
	 * @return <code>ListValues</code>
	 */
	@ModelAttribute(value="listValues")
	public ListValues setupListValues(Model model) {
		log.info("getting ModelAttribute for listValues...");
		return listValueService.getListValues();
	}
	
	/**
	 * Returns initial command object for search criteria
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
	
	@ModelAttribute(value="theform")
	public Form setupFormDetail() {
		log.info("getting ModelAttribute for the form...");
		return new Form();
	}
	
	@RequestMapping(params="action=submitSearch")
	public void processSearch(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
			Model model) {
		log.info("@ActionMapping...search for forms... ");
		
		List<Form> forms = null;
		try {
			forms = formsLibraryService.search(searchCriteria);
		} catch (FormsLibraryServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("searchResults", forms);

	}
	
}
