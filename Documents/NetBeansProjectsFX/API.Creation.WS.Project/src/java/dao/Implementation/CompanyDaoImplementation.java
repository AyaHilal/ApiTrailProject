/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation;

import dao.Interface.CompanyDaoInterface;
import dao.Interface.CompanyPhoneDaoInterface;
import dbGetConnection.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Company;

/**
 *
 * @author Aya
 */
public class CompanyDaoImplementation implements CompanyDaoInterface{
    Connection connection = null;
    
    
    @Override
    public Company getCompany(int id) {
        Company company = new Company();
         List<String>phoneList;
        connection = DataBaseConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String myQuery = "select * from company where company_id = ?";
        
        try {
            ps = connection.prepareStatement(myQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                company.setCompanyId(rs.getInt(1));
                company.setCompanyEmail(rs.getString(2));
                company.setCompanyLatitude(rs.getString(3));
                company.setCompanyLongitude(rs.getString(4));
                company.setCompanyAddress(rs.getString(5));
                company.setCompanyPackage(rs.getString(6));
                company.setCompanyName(rs.getString(7));
                company.setCompanyStartDate(rs.getString(8));
                company.setCompanyEndDate(rs.getString(9));
                company.setCompanyCEO(rs.getString(10));
                company.setInsuranceId(rs.getInt(11));
         
                CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
                phoneList = companyPhoneObject.getCompanyPhone(company.getCompanyId());
                company.setCompanyPhone(phoneList);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return company;
    }
    
    
    
    @Override
    public List<Company> getAllCompanies() {
        connection = DataBaseConnection.getConnection();

        List<Company>allCompanies = new ArrayList<Company>();
       List<String>phoneList;
        Statement s = null;
        ResultSet rs = null;
        String myQuery = "select * from company";
        try {
            s = connection.createStatement();
            rs = s.executeQuery(myQuery);
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyId(rs.getInt(1));
                company.setCompanyEmail(rs.getString(2));
                company.setCompanyLatitude(rs.getString(3));
                company.setCompanyLongitude(rs.getString(4));
                company.setCompanyAddress(rs.getString(5));
                company.setCompanyPackage(rs.getString(6));
                company.setCompanyName(rs.getString(7));
                company.setCompanyStartDate(rs.getString(8));
                company.setCompanyEndDate(rs.getString(9));
                company.setCompanyCEO(rs.getString(10));
                company.setInsuranceId(rs.getInt(11));

               CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
                phoneList = companyPhoneObject.getCompanyPhone(company.getCompanyId());
                company.setCompanyPhone(phoneList);
                allCompanies.add(company);
               }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCompanies;
    }
    
    @Override
    public int getCompanyIdFromMail(String companyMail){
        int companyId = -1;
        connection = DataBaseConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String myQuery = "select company_id from company where company_email = ?";
        try {
            ps = connection.prepareStatement(myQuery);
            ps.setString(1, companyMail);
            rs= ps.executeQuery();
            while (rs.next()) {
                companyId = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
         return companyId;
    }
    
    
    

    @Override
    public boolean insertCompany(Company company) {
        connection = DataBaseConnection.getConnection();
        PreparedStatement ps = null;
        String myQuery = "insert into company(company_email, company_latitude, company_longitude, company_address, company_package_type, company_name, company_start_date, company_end_date, company_ceo, medical_insurance_insurance_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int return_flage1 = 0;

        int companyId = -1 ;
        boolean isInserted=false;
        try {
            ps = connection.prepareStatement(myQuery);    
            ps.setString(1, company.getCompanyEmail());
            ps.setString(2,company.getCompanyLatitude());
            ps.setString(3,company.getCompanyLongitude());
            ps.setString(4,company.getCompanyAddress());
            ps.setString(5, company.getCompanyPackage());
            ps.setString(6,company.getCompanyName());
            ps.setString(7,company.getCompanyStartDate());
            ps.setString(8,company.getCompanyEndDate());
            ps.setString(9,company.getCompanyCEO());
            ps.setInt(10,company.getInsuranceId());
            return_flage1 = ps.executeUpdate();
           
            CompanyDaoInterface implObject = new CompanyDaoImplementation();
            companyId = implObject.getCompanyIdFromMail(company.getCompanyEmail());
            
            CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
            isInserted = companyPhoneObject.insertCompanyPhone(companyId, company.getCompanyPhone());
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return return_flage1 == 1 && isInserted ;
    }

    
    
    
    
    @Override
    public boolean updateCompany(Company company) {
        connection = DataBaseConnection.getConnection();

        PreparedStatement ps = null;
        String myQuery = "UPDATE company SET company_email = ?, company_name=?, company_latitude=?, company_longitude=?, company_address=?, company_package_type=?, company_start_date=?, company_end_date=?, company_ceo=?, medical_insurance_insurance_id=? WHERE company_id=?";
        int return_flage = 0;

          boolean isInserted = false;

        
        try {
            ps = connection.prepareStatement(myQuery);
            
            ps.setString(1, company.getCompanyEmail());
            ps.setString(2, company.getCompanyName());
            ps.setString(3, company.getCompanyLatitude());
            ps.setString(4, company.getCompanyLongitude());
            ps.setString(5,company.getCompanyAddress());
            ps.setString(6, company.getCompanyPackage());
            ps.setString(7, company.getCompanyStartDate());
            ps.setString(8, company.getCompanyEndDate());
            ps.setString(9,company.getCompanyCEO());
            ps.setInt(10, company.getInsuranceId());
            ps.setInt(11, company.getCompanyId());
            return_flage = ps.executeUpdate();
            
            if(return_flage==1)
            {
              CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
               return_flage = companyPhoneObject.deleteCompanyPhone(company.getCompanyId());
               
              if(return_flage != 0)
              {
               isInserted = companyPhoneObject.insertCompanyPhone(company.getCompanyId(), company.getCompanyPhone());
              }
          }
       
        } catch (SQLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isInserted;
    }
    
    
    
    

    @Override
    public boolean deleteCompany(int id) {
        connection = DataBaseConnection.getConnection();
        Statement s = null;
        String myQuery2 = "DELETE FROM company WHERE company_id=";

        int return_flage = 0;
       
               CompanyPhoneDaoInterface companyPhoneObject = new CompanyPhoneDaoImplementation();
               return_flage = companyPhoneObject.deleteCompanyPhone(id);
               
            try{
                s = connection.createStatement();
               return_flage = s.executeUpdate(myQuery2 + id);
            }
            catch(SQLException ex2){
               Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex2);
            }
       
        return return_flage == 1;
    }
}
    
   
