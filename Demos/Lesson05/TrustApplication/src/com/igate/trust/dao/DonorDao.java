package com.igate.trust.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.igate.trust.beans.DonorBean;
import com.igate.trust.mappers.TrustMappers;


@Repository
public class DonorDao implements IDonorDao
{

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	
	/***********************************************************
	 * Method Name: addDonation 
	 * Return type:int 
	 * Parameters:Object of type DonorBean
	 * Package Name: com.igate.trust.dao
	 * @author igateCorp
	 ***********************************************************/
	
	@Override
	public int addDonation(DonorBean donor) {
		int donorId=0;
    	String sequenceSql="SELECT donorId_seq.NEXTVAL FROM DUAL ";
    	donorId=jdbcTemplate.queryForInt(sequenceSql);
    		
    	String name=donor.getDonorName();
    	String phoneNo=donor.getDonorPhoneNumber();
    	String address=donor.getDonorAddress();
    	String amount=donor.getDonationAmount();
    	
    	String insertSql="INSERT INTO DONOR VALUES(?,?,?,?,?,SYSDATE)";
    	Object[] params=new Object[]{donorId,name,phoneNo,address,amount};
    	
    	int inserted=jdbcTemplate.update(insertSql,params);    	
    	System.out.println(inserted);
    	
    	return donorId;
    }


	/***********************************************************
	 * Method Name: getDonationDetails 
	 * Return type:	Object of type DonorBean
	 * Parameters:	donorId int
	 * Package Name: com.igate.trust.dao
	 * @author igateCorp
	 ***********************************************************/

	@Override
	public DonorBean getDonationDetails(int donorId) {
		String sql="SELECT donorid,donorname,phonenumber,address,amount,donationdate FROM donor WHERE donorId=?";
	       Object[] params=new Object[]{donorId};
	       TrustMappers mapper=new TrustMappers();
		  DonorBean donorDetail=(DonorBean)jdbcTemplate.queryForObject(sql,mapper,params);
	     return donorDetail;
	}


	/***********************************************************
	 * Method Name: getAllDonorsDetails 
	 * Return type:	List of DonorBean Type
	 * Parameters :	none
	 * Package Name: com.igate.trust.dao
	 * @author igateCorp
	 ***********************************************************/

	@Override
	public List<DonorBean> getAllDonorsDetails() {
		String sql="SELECT donorid,donorname,phonenumber,address,amount,donationdate FROM donor";
		  TrustMappers mapper=new TrustMappers();
		  List<DonorBean> list=jdbcTemplate.query(sql,mapper);
	     return list;
	}


	/***********************************************************
	 * Method Name: isValidDonorId 
	 * Return type:	boolean
	 * Parameters :	donorId int
	 * Package Name: com.igate.trust.dao
	 * @author igateCorp
	 ***********************************************************/
	
	@Override
	public boolean isValidDonorId(int donorId) {
		boolean status=false;
		System.out.println("donorId="+donorId);
    	String sql="SELECT 1 FROM donor WHERE donorId=?";
		Object[] params=new Object[]{donorId};
		int iStatus= jdbcTemplate.update(sql,params);
		if(iStatus>0)
		{
			status=true;
		}
		
		return status;
	}
	
}
