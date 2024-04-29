package com.model;



import java.sql.Timestamp;

public class JobListing {
	
	    private int jobID;
	    private int companyID;
	    private String jobTitle;
	    private String jobDescription;
	    private String jobLocation;
	    private double salary;
	    private String jobType;
	    private Timestamp postedDate;
	    
		public int getJobID() {
			return jobID;
		}
		public void setJobID(int jobID) {
			this.jobID = jobID;
		}
		public int getCompanyID() {
			return companyID;
		}
		public void setCompanyID(int companyID) {
			this.companyID = companyID;
		}
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public String getJobDescription() {
			return jobDescription;
		}
		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}
		public String getJobLocation() {
			return jobLocation;
		}
		public void setJobLocation(String jobLocation) {
			this.jobLocation = jobLocation;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double Decimal) {
			this.salary = Decimal;
		}
		public String getJobType() {
			return jobType;
		}
		public void setJobType(String jobType) {
			this.jobType = jobType;
		}
		public Timestamp getPostedDate() {
			return postedDate;
		}
		public void setPostedDate(Timestamp timestamp) {
			this.postedDate = timestamp;
		}
		
	    
	    
	    
	    
}
