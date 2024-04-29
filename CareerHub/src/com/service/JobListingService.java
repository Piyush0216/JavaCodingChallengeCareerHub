package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.*;
import com.daoImpl.JobListingDaoImpl;
import com.model.JobListing;

public class JobListingService {

	JobListingDao jobdao = new JobListingDaoImpl();
	public List<JobListing> getAllJobListings() throws SQLException {
		// TODO Auto-generated method stub
		
		return jobdao.getAllJobListings() ;
	}
     
}
