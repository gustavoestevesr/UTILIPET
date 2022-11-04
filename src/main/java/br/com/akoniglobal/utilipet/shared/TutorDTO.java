package br.com.akoniglobal.utilipet.shared;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.akoniglobal.utilipet.model.Pet;

public class TutorDTO {
    
    private String id;
    @NotEmpty(message = "O campo nome não pode ser vazio")
    @Size(min = 3, max = 40, message = "O campo nome contém o tamanho minimo de 3 e maximo de 40")
    private String name;
    @NotBlank(message = "O campo email não pode estar em branco")
    private String email;
    @Pattern(regexp = "^[0-9]{11}")
    private String phone;
    @NotBlank(message = "A senha não pode ser nulo")
    @Size(min = 6, max = 20, message = "A senha contém o tamanho minimo de 6 e maximo de 20")
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
