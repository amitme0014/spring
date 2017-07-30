package com.igate.trust.dao;

import java.util.List;

import com.igate.trust.beans.DonorBean;

public interface IDonorDao {

	public int addDonation(DonorBean donor);
	public DonorBean getDonationDetails(int donorId);
	public List<DonorBean> getAllDonorsDetails();
	public boolean isValidDonorId(int donorId);
}
