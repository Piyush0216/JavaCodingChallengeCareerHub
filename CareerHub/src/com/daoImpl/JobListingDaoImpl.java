package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.JobListingDao;
import com.model.JobListing;
import com.utility.DBConnection;

public class JobListingDaoImpl implements JobListingDao {

	@Override
	public List<JobListing> getAllJobListings() throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<JobListing> jobListings = new ArrayList<>(); // List to store retrieved job listings

	    try {
	        // Establish database connection
	        conn = DBConnection.dbConnect();
	        
	        // Prepare SQL query to retrieve all job listings
	        String query = "SELECT * FROM JobListing";
	        ps = conn.prepareStatement(query);
	        
	        // Execute the query and get the result set
	        rs = ps.executeQuery();
	        
	        // Iterate through the result set and populate the list of job listings
	        while (rs.next()) {
	            // Create a JobListing object for each row in the result set
	            JobListing jobListing = new JobListing();
	            
	            // Set JobListing attributes from the result set
	            jobListing.setJobID(rs.getInt("JobID"));
	            jobListing.setCompanyID(rs.getInt("CompanyID"));
	            jobListing.setJobTitle(rs.getString("JobTitle"));
	            jobListing.setJobDescription(rs.getString("JobDescription"));
	            jobListing.setJobLocation(rs.getString("JobLocation"));
	            jobListing.setSalary(rs.getDouble("Salary"));
	            jobListing.setJobType(rs.getString("JobType"));
	            jobListing.setPostedDate(rs.getTimestamp("PostedDate"));
	            
	            // Add the JobListing object to the list
	            jobListings.add(jobListing);
	        }
	    } catch (SQLException ex) {
	        // Handle SQL exceptions
	        ex.printStackTrace();
	        throw ex;
	    } finally {
	        // Close resources in finally block
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            // Log or handle the exception accordingly
	        }
	    }

	    return jobListings; // Return the list of job listings
	}


}
