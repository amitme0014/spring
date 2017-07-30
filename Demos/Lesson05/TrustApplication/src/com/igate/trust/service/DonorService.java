package com.igate.trust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.trust.beans.DonorBean;
import com.igate.trust.dao.IDonorDao;


@Service
public class DonorService implements IDonorService
{

	@Autowired
	IDonorDao donorDao;

	@Override
	public int addDonation(DonorBean donor) {
		
		return donorDao.addDonation(donor);
	}

	@Override
	public DonorBean getDonationDetails(int donorId) {
		return donorDao.getDonationDetails(donorId);
	}

	@Override
	public List<DonorBean> getAllDonorsDetails() {
		return donorDao.getAllDonorsDetails();
	}

	@Override
	public boolean isValidDonorId(int donorId) {
		return donorDao.isValidDonorId(donorId);
	}

	}
