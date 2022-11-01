package br.com.akoniglobal.utilipet.shared;

import java.util.List;

import br.com.akoniglobal.utilipet.model.Pet;

public class TutorDTO {
    
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String birthdayDate;
    private String zipcode;    
    private String numberHome;
    private List<Pet> pets;

    public String getNumberHome() {
        return numberHome;
    }
    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }    
    public List<Pet> getPets() {
        return pets;
    }
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getBirthdayDate() {
        return birthdayDate;
    }
    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
