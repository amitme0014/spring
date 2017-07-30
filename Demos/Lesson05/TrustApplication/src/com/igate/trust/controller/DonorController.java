package com.igate.trust.controller;

/**********************************************************************
 * FileName: DonorController.java
 * Date:27/8/2014
 * 
 * Description:The file contains the User Defined Controller Class For 
 * 				the application Donor Application.
 * 
 * @author nn824719
 *********************************************************************/
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.igate.trust.beans.DonorBean;
import com.igate.trust.exception.TrustException;
import com.igate.trust.service.IDonorService;

@Controller
public class DonorController {
	@Autowired
	private IDonorService donorService;

	/***********************************************************
	 * Method Name: showHomePage(Model model) Return type:String
	 * Parameters:Object of type Model Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * 
	 * @author igateCorp
	 ***********************************************************/
	@RequestMapping(value = "showHomePage")
	public String showHomePage(Model model) {
		return "index";
	}

	/***********************************************************
	 * Method Name: showAddDonationForm(Model model) Return type:String
	 * Parameters:Object of type Model Description:This method returns the name
	 * of the view that is to be displayed on the browser.
	 * 
	 * @author igateCorp
	 ***********************************************************/
	@RequestMapping(value = "showAddDonationForm")
	public String showAddDonation(Model model) {
		// Create an attribute of type Question
		DonorBean donor = new DonorBean();
		// Add the attribute to the model
		model.addAttribute("donor", donor);
		// return the view name
		return "addDonationForm";
	}

	/***********************************************************
	 * Method Name: addDonation Return type:String Parameters:Object of type
	 * Model,Binding Result,Question Description:This validates the Object
	 * fields and if success calls the service layer method to add the Question
	 * to the database.
	 * 
	 * @author igateCorp
	 ***********************************************************/
	@RequestMapping(value = "addDonation")
	public String addDonation(@ModelAttribute("donor") @Valid DonorBean donor,
			BindingResult result, Model model) {
			int donorId=0;
		if (result.hasErrors()) {
			return "addDonationForm";
		}
		
		try
		{
			donorId = donorService.addDonation(donor);
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		if (donorId != 0) {
			model.addAttribute("donorId", donorId);
			model.addAttribute("amount", donor.getDonationAmount());
			return "addSuccess";
		} 
		else {
			String msg = "Technical Problem..Please Try Later!!";
			model.addAttribute("msg", msg);
			return "myError";
		}
		
		
	}
	

	/***********************************************************
	 * Method Name: showViewDonationForm Return type:String Parameters:Object of type
	 * Model is for setting attribute
	 * 
	 * @author igateCorp
	 ***********************************************************/
	
	@RequestMapping(value = "showViewDonationForm")
	public String showViewDonationForm(Model model) {
		// Create an attribute of type Question
		DonorBean donor = new DonorBean();
		// Add the attribute to the model
		model.addAttribute("donor", donor);
		model.addAttribute("isFirst","true");
		// return the view name
		return "viewDonation";
	}

	/***********************************************************
	 * Method Name: viewDonation Return type:String Parameters:Object of type
	 * Model is for setting attribute
	 * 
	 * @author igateCorp
	 ***********************************************************/
	
	@RequestMapping(value = "viewDonation")
	public String viewDonation(@ModelAttribute("donor") DonorBean donor,
			Model model) throws TrustException {
			boolean isValidId;
			try
			{
				isValidId=donorService.isValidDonorId(donor.getDonorId());
				System.out.println("isValid="+isValidId);
			}
			catch(DataAccessException dataAccessException)
			{
				model.addAttribute("msg","Technical Problem..Please Try Later!!");
				return "myError";
			}
		
		if("".equals(donor.getDonorId()))
		{
			throw new TrustException("Enter  Your Donor Id");
		}
		try
		{
		if(isValidId==true)
		{
			DonorBean dBean = new DonorBean();
			dBean = donorService.getDonationDetails(donor.getDonorId());
			model.addAttribute("dBean", dBean);
			return "viewDonation";
		}
		else
		{
			String msg = "Enter a Valid Id!!";
			model.addAttribute("msg", msg);
			return "myError";
		}
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
		}
	

	/***********************************************************
	 * Method Name: showViewAllDonations Return type:String Parameters:Object of type
	 * Model is for setting attribute
	 * 
	 * @author igateCorp
	 ***********************************************************/
	
	@RequestMapping(value = "showViewAllDonations")
	public String showViewAllDonations(Model model) {

		// return the view name
		try
		{
			List<DonorBean> list = donorService.getAllDonorsDetails();
			if (list.isEmpty()) {
			String msg = "There are no Donors";
			model.addAttribute("msg", msg);
			return "myError";
		}
		// Add the attribute to the model
		model.addAttribute("list", list);
		return "viewAllDonorsList";
		}
		catch(DataAccessException dataAccessException)
		{
			model.addAttribute("msg","Technical Problem..Please Try Later!!");
			return "myError";
		}
	}

}
