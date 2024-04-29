package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Company;

public interface CompanyDao {
	  List<Company> getAllCompanies() throws SQLException;
}
