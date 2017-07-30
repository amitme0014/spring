package com.igate.trust.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.trust.beans.DonorBean;

public class TrustMappers implements RowMapper<DonorBean>{

	@Override
	public DonorBean mapRow(ResultSet rs, int arg1) throws SQLException {
		DonorBean donorDetails=new DonorBean();
		donorDetails.setDonorId(rs.getInt(1));
		donorDetails.setDonorName(rs.getString(2));
		donorDetails.setDonorPhoneNumber(rs.getString(3));
		donorDetails.setDonorAddress(rs.getString(4));
		donorDetails.setDonationAmount(rs.getString(5));
		donorDetails.setDonationDate(rs.getDate(6));
		return donorDetails;
	}

}
