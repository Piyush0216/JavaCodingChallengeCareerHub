package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.daoImpl.*;
import com.exception.InvalidEmailFormatException;
import com.model.Applicant;
import com.model.ApplicantWithId;

public class ApplicantService {
	
	ApplicantDao appdao = new ApplicantDaoImpl();
	
	public boolean AddApplicant(Applicant applicant) throws SQLException,InvalidEmailFormatException {
		
		if( !appdao.isValidEmail(applicant.getEmail())) {
			throw new InvalidEmailFormatException("Invalid email format: " + applicant.getEmail());
		}
		else {
			if(appdao.isEmailExists(applicant.getEmail())) {
				return false;
			}
			return appdao.addApplicant(applicant);
		}
		
		
		
	}

	public List<ApplicantWithId> getAllApplicants()  throws SQLException {
		// TODO Auto-generated method stub
		return appdao.getAllApplicants();
	}

}
