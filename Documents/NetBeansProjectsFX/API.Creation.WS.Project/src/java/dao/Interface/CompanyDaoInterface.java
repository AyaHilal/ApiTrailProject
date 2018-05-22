/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Interface;

import java.util.List;
import pojo.Company;

/**
 *
 * @author Aya
 */
public interface CompanyDaoInterface {
    
     List<Company> getAllCompanies();
    
    boolean insertCompany(Company company);

    boolean updateCompany(Company company);

    boolean deleteCompany(int id);
    
    Company getCompany(int id);
   
    int getCompanyIdFromMail(String companyMail);
    
    
}
