package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CompanyDao;
import com.model.Company;
import com.utility.DBConnection;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public List<Company> getAllCompanies() throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Company> companies = new ArrayList<>(); // List to store retrieved companies

	    try {
	        // Establish database connection
	        conn = DBConnection.dbConnect();
	        
	        // Prepare SQL query to retrieve all companies
	        String query = "SELECT * FROM Company";
	        ps = conn.prepareStatement(query);
	        
	        // Execute the query and get the result set
	        rs = ps.executeQuery();
	        
	        // Iterate through the result set and populate the list of companies
	        while (rs.next()) {
	            // Create a Company object for each row in the result set
	            Company company = new Company();
	            
	            // Set Company attributes from the result set
	            company.setCompanyID(rs.getInt("CompanyID"));
	            company.setCompanyName(rs.getString("CompanyName"));
	            company.setLocation(rs.getString("Location"));
	            
	            // Add the Company object to the list
	            companies.add(company);
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

	    return companies; // Return the list of companies
	}


}
