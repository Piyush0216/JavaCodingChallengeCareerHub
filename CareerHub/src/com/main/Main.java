package com.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.*;
import com.dao.ApplicantDao;
import com.exception.InvalidEmailFormatException;
import com.model.Applicant;
import com.model.JobListing;
import com.service.ApplicantService;
import com.service.JobListingService;


public class Main {
	
	 public static void main(String[] args)  {
		 
			ApplicantService applicant = new ApplicantService();
			JobListingService jobs = new JobListingService();
	        Scanner sc = new Scanner(System.in);
	        int choice;
	        
	        

	        do {
	            System.out.println("=== Job Board Menu ===");
	            System.out.println("0. Create Profile"); // working
	            System.out.println("1. Post a Job");
	            System.out.println("2. Apply for a Job");
	            System.out.println("3. View Job Listings"); //working
	            System.out.println("4. View Applicants");   // working
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            choice = sc.nextInt();
	            sc.nextLine(); 
	            
	            switch (choice) {
	            
	                case 0:
	                	
	                	try {
	                	Applicant app = new Applicant();   	
	                   
		                System.out.println("=== Create Profile ===");
	                    System.out.print("Enter First Name: ");
	                    app.setFirstName(sc.nextLine());
	                    System.out.print("Enter Last Name: ");
	                    app.setLastName(sc.nextLine()) ;
	                    System.out.print("Enter Email: ");
	                    app.setEmail(sc.nextLine());
	                    System.out.print("Enter Phone: ");
	                    app.setPhone(sc.nextLine());
	                    System.out.print("Enter Resume: ");
	                    app.setResume(sc.nextLine());
                        
	                    if(app.getPhone().length()!=10) {
	                    	System.out.println("Phone number must be 10 digit long");
	                    	break;
	                    }
	                    boolean added = applicant.AddApplicant(app);
	                    

	               
	                    if (added) {
	                        System.out.println("Applicant added successfully.");
	                        
	                    } else {
	                        System.out.println("Failed to add applicant Check EmailID.");
	                    }
	                	}catch(InvalidEmailFormatException e) {
	                		System.out.println(e.getMessage());
	                	}
	                	catch(SQLException e){
	                		System.out.println(e.getMessage());
	                	}
	                    break;
                         
                    
	                case 1:
	                   
	                    break;
	                case 2:
	                   
	                    break;
	                case 3:
	                	try {

		                    List<JobListing> jobListings = jobs.getAllJobListings();

		                  
		                    System.out.println("All Job Listings:");
		                    for (JobListing jobListing : jobListings) {
		                        System.out.println("Job ID: " + jobListing.getJobID());
		                        System.out.println("Company ID: " + jobListing.getCompanyID());
		                        System.out.println("Title: " + jobListing.getJobTitle());
		                        System.out.println("Description: " + jobListing.getJobDescription());
		                        System.out.println("Location: " + jobListing.getJobLocation());
		                        System.out.println("Salary: " + jobListing.getSalary());
		                        System.out.println("Type: " + jobListing.getJobType());
		                        System.out.println("Posted Date: " + jobListing.getPostedDate());
		                        System.out.println("----------------------------------");
		                    }}catch(SQLException e){
		                		System.out.println(e.getMessage());
		                	}
		                    break;
	                         
	                	
	                case 4:
	                	
	                	try {

		                    List<ApplicantWithId> applicants = applicant.getAllApplicants();

		                  
		                    System.out.println("All Applicants Listings:");
		                    for (ApplicantWithId app : applicants) {
		                        System.out.println("Applicant ID: " + app.getApplicantID() );
		                        System.out.println("Applicant First Name: " + app.getFirstName() );
		                        System.out.println("Applicant Last Name: " + app.getLastName() );
		                        System.out.println("Applicant Email: " + app.getEmail());
		                        System.out.println("Applicant Phone: " + app.getPhone());
		                        System.out.println("Applicant Resume" + app.getResume());
		                        
		                        System.out.println("----------------------------------");
		                    }}catch(SQLException e){
		                		System.out.println(e.getMessage());
		                	}
		                    break;
	                    
	                   
	                case 5:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 5);

	       
	        sc.close();
	    }

}
