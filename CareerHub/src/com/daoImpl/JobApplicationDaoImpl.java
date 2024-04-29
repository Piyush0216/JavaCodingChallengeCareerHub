package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.JobApplicationDao;
import com.model.JobApplication;
import com.utility.DBConnection;

public class JobApplicationDaoImpl implements JobApplicationDao {

	@Override
	public List<JobApplication> getAllJobApplications() throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<JobApplication> jobApplications = new ArrayList<>(); // List to store retrieved job applications

	    try {
	        // Establish database connection
	        conn = DBConnection.dbConnect();
	        
	        // Prepare SQL query to retrieve all job applications
	        String query = "SELECT * FROM JobApplication";
	        ps = conn.prepareStatement(query);
	        
	        // Execute the query and get the result set
	        rs = ps.executeQuery();
	        
	        // Iterate through the result set and populate the list of job applications
	        while (rs.next()) {
	            // Create a JobApplication object for each row in the result set
	            JobApplication jobApp = new JobApplication();
	            
	            // Set JobApplication attributes from the result set
	            jobApp.setApplicationID(rs.getInt("ApplicationID"));
	            jobApp.setJobID(rs.getInt("JobID"));
	            jobApp.setApplicantID(rs.getInt("ApplicantID"));
	            jobApp.setApplicationDate(rs.getTimestamp("ApplicationDate"));
	            jobApp.setCoverLetter(rs.getString("CoverLetter"));
	            
	            // Add the JobApplication object to the list
	            jobApplications.add(jobApp);
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

	    return jobApplications; // Return the list of job applications
	}


}
