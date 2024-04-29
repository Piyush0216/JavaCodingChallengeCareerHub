package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.JobListing;

public interface JobListingDao {
	 List<JobListing> getAllJobListings() throws SQLException;
}
