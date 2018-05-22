/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Implementation;

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
public class CompanyPhoneDaoImplementation implements CompanyPhoneDaoInterface{
    Connection connection = null;

    public List<String> getCompanyPhone(int id){
      connection = DataBaseConnection.getConnection();   
      ResultSet rs = null;
      PreparedStatement ps = null;
      String myQuery = "select * from company_phone where company_company_id = ?";
      List <String> phoneList = null;
       try {
            ps= connection.prepareStatement(myQuery);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            phoneList = new ArrayList<String>();
           while (rs.next()) {
        String phone = rs.getString(1);
        phoneList.add(phone);
        }
      } catch (SQLException ex) {
            Logger.getLogger(CompanyPhoneDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return phoneList;
    }
    
    
    
    
    @Override
    public boolean insertCompanyPhone (int companyId,List<String> phoneList)
    {
       connection = DataBaseConnection.getConnection();   
       PreparedStatement ps = null;
        String myQuery = "insert into company_phone(phone, company_company_id) values(?, ?)";
         int return_flage = 0;
         int phoneListSize=phoneList.size();
         int i=0;
            while( phoneListSize>0)
           {    
           try {
               ps = connection.prepareStatement(myQuery);
               ps.setString(1, (String) phoneList.get(i));
               ps.setInt(2,companyId);
               return_flage = ps.executeUpdate();
               if(return_flage==1)
               {
                   phoneListSize--;
                   i++;
               }
           } catch (SQLException ex) {
               Logger.getLogger(CompanyPhoneDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
    return return_flage == 1;
    
    }
    
    
    
    @Override
    public int deleteCompanyPhone (int companyId){
     connection = DataBaseConnection.getConnection();
     Statement s = null;
     String myQuery = "DELETE FROM company_phone WHERE company_company_id=";
     int return_flage = 0;
      try{
                s = connection.createStatement();
                return_flage = s.executeUpdate(myQuery + companyId);
                }
            catch(SQLException ex2){
               Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex2);
               }   
      return return_flage;
    
    }
    
}




