package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.JobApplication;

public interface JobApplicationDao {
	 List<JobApplication> getAllJobApplications() throws SQLException;
}
