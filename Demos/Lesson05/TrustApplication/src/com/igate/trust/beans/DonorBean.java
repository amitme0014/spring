package com.igate.trust.beans;

import java.util.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class DonorBean 
{
	@Override
	public String toString() {
		return "DonorBean [donationAmount=" + donationAmount
				+ ", donationDate=" + donationDate + ", donorAddress="
				+ donorAddress + ", donorId=" + donorId + ", donorName="
				+ donorName + ", donorPhoneNumber=" + donorPhoneNumber + "]";
	}
	int donorId;
	
	@NotEmpty(message="Please Enter Donor Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
	private String donorName;
	
	@Size(min=7,max=10,message="Phone Number Should Accept Only 10 digits")
	@Pattern(regexp = "^[0-9]+$", message = "Phone Number should contain only 10 digits")
	private String donorPhoneNumber;
	@NotEmpty(message="Please Enter Address")
	
	private String donorAddress;
	
	
	@Pattern(regexp="^[0-9]+$",message="Please Enter valid amount greater than 0")
	private String donationAmount;
	
	private Date donationDate;
	
	
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorPhoneNumber() {
		return donorPhoneNumber;
	}
	public void setDonorPhoneNumber(String donorPhoneNumber) {
		this.donorPhoneNumber = donorPhoneNumber;
	}
	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}
	
	public String getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	
	
}
