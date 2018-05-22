/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;

/**
 *
 * @author Aya
 */
public class Company {
    private int companyId;
    private String companyName;
    private String companyEmail;
    private String companyLatitude;
    private String companyLongitude;
    private String companyAddress;
    private String companyPackage;
    private String companyStartDate;
    private String companyEndDate;
    private String companyCEO;
    private int insuranceId;
    private List<String> companyPhone;

    public Company(String companyName, String companyEmail, String companyLatitude, String companyLongitude, String companyAddress, String companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyLatitude = companyLatitude;
        this.companyLongitude = companyLongitude;
        this.companyAddress = companyAddress;
        this.companyPackage = companyPackage;
        this.companyStartDate = companyStartDate;
        this.companyEndDate = companyEndDate;
        this.companyCEO = companyCEO;
        this.insuranceId = insuranceId;
    }

    public Company(int companyId, String companyName, String companyEmail, String companyLatitude, String companyLongitude, String companyAddress, String companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId, List<String> companyPhone) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyLatitude = companyLatitude;
        this.companyLongitude = companyLongitude;
        this.companyAddress = companyAddress;
        this.companyPackage = companyPackage;
        this.companyStartDate = companyStartDate;
        this.companyEndDate = companyEndDate;
        this.companyCEO = companyCEO;
        this.insuranceId = insuranceId;
        this.companyPhone = companyPhone;
    }

    public Company(int companyId, String companyName, String companyEmail, String companyLatitude, String companyLongitude, String companyAddress, String companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyLatitude = companyLatitude;
        this.companyLongitude = companyLongitude;
        this.companyAddress = companyAddress;
        this.companyPackage = companyPackage;
        this.companyStartDate = companyStartDate;
        this.companyEndDate = companyEndDate;
        this.companyCEO = companyCEO;
        this.insuranceId = insuranceId;
    }

    public Company(String companyName, String companyEmail, String companyLatitude, String companyLongitude, String companyAddress, String companyPackage, String companyStartDate, String companyEndDate, String companyCEO, int insuranceId, List companyPhone) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyLatitude = companyLatitude;
        this.companyLongitude = companyLongitude;
        this.companyAddress = companyAddress;
        this.companyPackage = companyPackage;
        this.companyStartDate = companyStartDate;
        this.companyEndDate = companyEndDate;
        this.companyCEO = companyCEO;
        this.insuranceId = insuranceId;
        this.companyPhone = companyPhone;
    }

    public Company() { }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyLatitude() {
        return companyLatitude;
    }

    public void setCompanyLatitude(String companyLatitude) {
        this.companyLatitude = companyLatitude;
    }

    public String getCompanyLongitude() {
        return companyLongitude;
    }

    public void setCompanyLongitude(String companyLongitude) {
        this.companyLongitude = companyLongitude;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPackage() {
        return companyPackage;
    }

    public void setCompanyPackage(String companyPackage) {
        this.companyPackage = companyPackage;
    }

    public String getCompanyStartDate() {
        return companyStartDate;
    }

    public void setCompanyStartDate(String companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public String getCompanyEndDate() {
        return companyEndDate;
    }

    public void setCompanyEndDate(String companyEndDate) {
        this.companyEndDate = companyEndDate;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(List companyPhone) {
        this.companyPhone = companyPhone;
    }   
}
