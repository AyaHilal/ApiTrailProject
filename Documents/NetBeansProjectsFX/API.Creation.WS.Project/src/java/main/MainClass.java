/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.Implementation.CompanyDaoImplementation;
import java.util.ArrayList;
import java.util.List;
import pojo.Company;

/**
 *
 * @author Aya
 */
public class MainClass {
  
    public static void main(String args[]){
       // List<String> phones = new ArrayList<String>();
       // phones.add("1010");
       // phones.add("121212");
     // phones.add("131111");
      //  Company company =  new Company(2,"yarabbb", "yarabbbbb@gmail.com", "200", "100", "new address", "50", "20-10-2010","17-10-2015" , "kamal", 0,phones);      
       CompanyDaoImplementation implObject = new CompanyDaoImplementation();
        Company Inserted = implObject.getCompany(2);
        System.out.println(Inserted.getCompanyName()+Inserted.getCompanyPhone().get(2));


    }
    
    
    
    
}
