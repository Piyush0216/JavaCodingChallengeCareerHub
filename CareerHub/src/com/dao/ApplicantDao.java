package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Applicant;
import com.model.ApplicantWithId;

public interface ApplicantDao {
	 boolean  addApplicant(Applicant aplcnt);
	 boolean isValidEmail(String email);
	 boolean isEmailExists(String email);
	 List<ApplicantWithId> getAllApplicants() ;
}
