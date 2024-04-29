package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ApplicantDao;
import com.model.Applicant;
import com.model.ApplicantWithId;
import com.utility.DBConnection;

public class ApplicantDaoImpl implements ApplicantDao {
     
	@Override
	 public boolean isValidEmail(String email) {
	 	        return email.contains("@") && email.contains(".");
	    }
	
	@Override
	public List<ApplicantWithId> getAllApplicants() {
		// TODO Auto-generated method stub
		    Connection conn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    List<ApplicantWithId> applicants = new ArrayList<>(); // List to store retrieved applicants
		    
		    	    

		    try {
		    	
		        // Establish database connection
		        conn = DBConnection.dbConnect();
		        
		        // Prepare SQL query to retrieve all applicants
		        String query = "SELECT * FROM Applicant";
		        ps = conn.prepareStatement(query);
		        
		        // Execute the query and get the result set
		        rs = ps.executeQuery();
		        
		        // Iterate through the result set and populate the list of applicants
		        while (rs.next()) {
		            // Create an Applicant object for each row in the result set
		            ApplicantWithId applicant = new ApplicantWithId();
		            
		            // Set Applicant attributes from the result set
		            
		            applicant.setApplicantID(rs.getInt("ApplicantId"));
		            applicant.setFirstName(rs.getString("FirstName"));
		            applicant.setLastName(rs.getString("LastName"));
		            applicant.setEmail(rs.getString("Email"));
		            applicant.setPhone(rs.getString("Phone"));
		            applicant.setResume(rs.getString("Resume"));
		            
		            // Add the Applicant object to the list
		            applicants.add(applicant);
		        }
		    } catch (SQLException ex) {
		        // Handle SQL exceptions
		        ex.printStackTrace();
		       
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

		    return applicants; // Return the list of applicants
	}
	
	@Override
	public boolean isEmailExists(String email) {
		 Connection conn = null;
		 
        String sql = "SELECT COUNT(*) FROM Applicant WHERE email = ?";
        try {
        	
        	conn = DBConnection.dbConnect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // If count > 0, email exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	@Override
	public boolean addApplicant(Applicant aplcnt) {
		// TODO Auto-generated method stub
		    Connection conn = null;
	        PreparedStatement ps = null;

	        try {
	        	conn = DBConnection.dbConnect();
	            String insertQuery = "INSERT INTO Applicant (FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?)";
	            ps = conn.prepareStatement(insertQuery);
	            ps.setString(1, aplcnt.getFirstName());
	            ps.setString(2, aplcnt.getLastName());
	            ps.setString(3, aplcnt.getEmail());
	            ps.setString(4, aplcnt.getPhone());
	            ps.setString(5, aplcnt.getResume());

	            int rowsAffected = ps.executeUpdate();
	            return rowsAffected > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error adding applicant: " + e.getMessage());
	            return false;
	        } finally {
	            
	            try {
	                if (ps != null) {
	                    ps.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }
	    }
		
		
	}
