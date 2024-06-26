package mx.fei.coilvicapp.logic.student;

import java.util.Objects;
import mx.fei.coilvicapp.logic.university.University;
import mx.fei.coilvicapp.logic.implementations.FieldValidator;

public class Student { 
    
    private int idStudent = 0;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private String gender;
    private String lineage;
    private University university;
    
    public Student() {
        university = new University();        
    }
    
    public Student(int idStudent, String name, String paternalSurname, String maternalSurname,
            String email, String gender, String lineage, University university) {
        this.idStudent = idStudent;
        this.name = name;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.email = email;
        this.gender = gender;
        this.lineage = lineage;
        this.university = university;
    }
       
    public int getIdStudent() {
        return idStudent;
    }
    
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {        
        FieldValidator fieldValidator = new FieldValidator();
        fieldValidator.checkName(name);
        this.name = name;
    }
    
    public String getPaternalSurname() {
        return paternalSurname;
    }
    
    public void setPaternalSurname(String paternalSurname) {      
        FieldValidator fieldValidator = new FieldValidator();
        fieldValidator.checkName(name);
        this.paternalSurname = paternalSurname;
    }
    
    public String getMaternalSurname() {
        return maternalSurname;
    }
    
    public void setMaternalSurname(String maternalSurname) { 
        FieldValidator fieldValidator = new FieldValidator();
        fieldValidator.checkName(name);
        this.maternalSurname = maternalSurname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail (String email) {
        FieldValidator fieldValidator = new FieldValidator();
        fieldValidator.checkEmail(email);
        this.email = email;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender (String gender) {
        this.gender = gender;
    }
    
    public String getLineage() {
        return lineage;
    }
    
    public void setLineage (String lineage) {
        this.lineage = lineage;
    }
    
    public void setUniversity(University university) {
        this.university = university;
    }
    
    public University getUniversity() {
        return university;
    }
    
    public void setIdUniversity(int idUniversity) {
        this.university.setIdUniversity(idUniversity);
    }
    
    public int getIdUniversity() {
        return university.getIdUniversity();
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }

        Student toCompare = (Student) object;
        return idStudent == toCompare.getIdStudent() &&
                Objects.equals(name, toCompare.getName()) &&
                Objects.equals(paternalSurname, toCompare.getPaternalSurname()) &&
                Objects.equals(maternalSurname, toCompare.getMaternalSurname()) &&
                Objects.equals(email, toCompare.getEmail()) &&
                Objects.equals(gender, toCompare.getGender()) &&
                Objects.equals(lineage, toCompare.getLineage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, paternalSurname, maternalSurname, email, gender, lineage);
    }
        
}
