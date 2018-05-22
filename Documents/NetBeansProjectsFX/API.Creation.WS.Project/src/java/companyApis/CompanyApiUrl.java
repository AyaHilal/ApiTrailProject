/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyApis;

/**
 *
 * @author Aya
 */

import dao.Implementation.CompanyDaoImplementation;
import dao.Interface.CompanyDaoInterface;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.Company;
import pojo.Response;


@Path("/company")

public class CompanyApiUrl implements CompanyAPisInterface.CompanyApiUrlInterface{
 static ArrayList<Company> companyList;
    
    static{
        
        companyList=new ArrayList<Company>();
        System.out.println("cons...");
    }
 
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    
 @Override
    public List retrive(){
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        companyList = (ArrayList<Company>) implObject.getAllCompanies();
        return companyList;
    }
    
    
    @GET
    @Path("/getCompany/{id}")
    @Produces(MediaType.APPLICATION_JSON)
 @Override
    public Company retriveCompany(@PathParam("id")int id){
        Company company = new Company();
        CompanyDaoInterface implObject = new CompanyDaoImplementation();
        company = implObject.getCompany(id);
        return company;
    }
    
    
    
//    @POST
//    @Path("/insert")
//    public Response setData(Company company)
//    {
//        Response response = new Response();
//        CompanyDaoImplementation implObject = new CompanyDaoImplementation();
//        boolean isInserted = implObject.insertCompany(company);
//        //System.out.println(isInserted);
//        if(isInserted==true)
//        {
//          response.setError(200);
//          response.setMessage("company is inserted");
//          response.setStatus(true);
//        }
//        else{
//            response.setError(404);
//          response.setMessage("company is not inserted");
//          response.setStatus(false);
//        }
//        return response;
//    }
    
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
 @Override
    public Response setData (@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3){
    
   Response response = new Response();
   List phoneList = new ArrayList<String>();
   phoneList.add(phone1);
   phoneList.add(phone2);
   phoneList.add(phone3);
   Company company = new Company(name, email, latitude, longitude, address, companyPackage, startDate, endDate, ceo, insuranceId,phoneList);
   CompanyDaoInterface implObject = new CompanyDaoImplementation();
    boolean isInserted = implObject.insertCompany(company);
    if(isInserted==true)
     {
      response.setError(200);
      response.setMessage("company is inserted");
      response.setStatus(true);
     }
  else{
       response.setError(404);
       response.setMessage("company is not inserted");
       response.setStatus(false);
        }
   
   return response;
    
}
    
    
    
    
//    @POST
//    @Path("/insertJson")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("text/html")
//    public Response setData(student st)
//    {
//          String result = "student saved : " + st;
//        return Response.status(201).entity(result).build();
//    }
//    
//        
    @PUT
    @Path("/update/{id}")
    @Override
    public Response update(@FormParam("name")String name,@FormParam("email")String email,@FormParam("latitude")String latitude,@FormParam("longitude")String longitude,@FormParam("address")String address,@FormParam("companyPackage")String companyPackage,@FormParam("startDate")String startDate,@FormParam("endDate")String endDate,@FormParam("ceo")String ceo,@FormParam("insuranceId")int insuranceId,@FormParam("phone1")String phone1,@FormParam("phone2")String phone2,@FormParam("phone3")String phone3,@PathParam("id")int id)
    {
      Response response = new Response();
      List phoneList = new ArrayList<String>();
      phoneList.add(phone1);
      phoneList.add(phone2);
      phoneList.add(phone3);  
      Company company = new Company(id, name, email, latitude, longitude, address, companyPackage, startDate, endDate, ceo, insuranceId,phoneList);
      CompanyDaoInterface implObject = new CompanyDaoImplementation();
      boolean isInserted = implObject.updateCompany(company);
      if(isInserted==true)
       {
         response.setError(200);
         response.setMessage("company is updated");
         response.setStatus(true);
       }
     else{
         response.setError(404);
         response.setMessage("company is not updated");
         response.setStatus(false);
         }
      return response;   
    }
    
    
    
    
    @DELETE
    @Path("/delete/{id}")
    @Override
    public Response delete(@PathParam("id")int id)
    {
       Response response = new Response();
       CompanyDaoInterface implObject = new CompanyDaoImplementation();
       boolean isInserted = implObject.deleteCompany(id);
       if(isInserted==true)
       {
         response.setError(200);
         response.setMessage("company is Deleted");
         response.setStatus(true);
       }
     else{
         response.setError(404);
         response.setMessage("company is not Deleted");
         response.setStatus(false);
         }
      return response;   
    }
    

    
    
}
