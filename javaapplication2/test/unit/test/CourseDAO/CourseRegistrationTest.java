package unit.test.CourseDAO;

/*
 * @author d0ubl3_d
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvicapp.logic.course.*;
import mx.fei.coilvicapp.logic.professor.*;
import mx.fei.coilvicapp.logic.implementations.DAOException;
import mx.fei.coilvicapp.logic.university.UniversityDAO;
import mx.fei.coilvicapp.logic.university.University;
import mx.fei.coilvicapp.logic.country.CountryDAO;
import mx.fei.coilvicapp.logic.country.Country;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class CourseRegistrationTest {
    
    private static final CourseDAO COURSE_DAO = new CourseDAO();
    private static final Course COURSE_FOR_TESTING = new Course();
    
    private static final ProfessorDAO PROFESSOR_DAO = new ProfessorDAO();
    private static final Professor AUX_PROFESSOR = new Professor();
    
    private static final UniversityDAO UNIVERSITY_DAO = new UniversityDAO();
    private static final University AUX_UNIVERSITY = new University();
    
    private static final CountryDAO COUNTRY_DAO = new CountryDAO();
    private static final Country AUX_COUNTRY = new Country();
    
    @Before
    public void setUp() throws DAOException {
        int idCountry = 0;
        int idUniversity = 0;
        int idProfessor = 0;
        initializeAuxiliarProfessor();
        intitliazeAuxiliarUniversity();
        initializeAuxiliarCountry();
        intializeCourse();
        
        try {
            idCountry = COUNTRY_DAO.registerCountry(AUX_COUNTRY);
            AUX_UNIVERSITY.setIdCountry(idCountry);
            idUniversity = UNIVERSITY_DAO.registerUniversity(AUX_UNIVERSITY);
            AUX_PROFESSOR.setIdUniversity(idUniversity);
            idProfessor = PROFESSOR_DAO.registerProfessor(AUX_PROFESSOR);
            
        } catch (DAOException exception) {
            Logger.getLogger(CourseRegistrationTest.class.getName()).log(Level.SEVERE, null, exception);
        }
        AUX_COUNTRY.setIdCountry(idCountry);
        AUX_UNIVERSITY.setIdUniversity(idUniversity);
        AUX_PROFESSOR.setIdProfessor(idProfessor);
    }
    
    private void initializeAuxiliarProfessor() {
        AUX_PROFESSOR.setName("Juan Carlos");
        AUX_PROFESSOR.setPaternalSurname("Perez");
        AUX_PROFESSOR.setMaternalSurname("Arriaga");
        AUX_PROFESSOR.setEmail("elRebo@gmail.com");
        AUX_PROFESSOR.setGender("Masculino");
        AUX_PROFESSOR.setPhoneNumber("2286722098");
        AUX_PROFESSOR.setIdUniversity(1);
    }
    
    private void intitliazeAuxiliarUniversity() {
        AUX_UNIVERSITY.setName("Universidad Católica Andrés Bello");
        AUX_UNIVERSITY.setAcronym("UCAB");
        AUX_UNIVERSITY.setJurisdiction("Caracas");
        AUX_UNIVERSITY.setCity("Guayana");
    }
    
    private void initializeAuxiliarCountry() {
        AUX_COUNTRY.setName("Mexico");
    }
    
    private void intializeCourse() {
        COURSE_FOR_TESTING.setProfessor(AUX_PROFESSOR);
        COURSE_FOR_TESTING.setName("Programacion");
        COURSE_FOR_TESTING.setGeneralObjective("Los alumnos comprendan la"
        + " programacion estructurada y orientada a objetos");
        COURSE_FOR_TESTING.setTopicsInterest("Abstraccion, Herencia, Polimorfismo");
        COURSE_FOR_TESTING.setNumberStudents(35);
        COURSE_FOR_TESTING.setStudentsProfile("Ingenieria de software");
        COURSE_FOR_TESTING.setTerm("Febrero-Junio 2024");
        COURSE_FOR_TESTING.setLanguage("Ingles");
        COURSE_FOR_TESTING.setAdditionalInformation("Ademas de la progrmacion"
        + " orientada a objetos veremos el paradigma funcional");
    }

    @Test
    public void testInsertCourseSucces() {
        int result = 0;
        
        try {
            result = COURSE_DAO.insertCourse(COURSE_FOR_TESTING);
        } catch (DAOException exception) {
            Logger.getLogger(CourseRegistrationTest.class.getName()).log(Level.SEVERE, null, exception);
        }
        
        assertTrue(result > 0);     
    }
    
    @After
    public void tearDown() {
        try {
            //delete curso
            PROFESSOR_DAO.deleteProfessorByID(AUX_PROFESSOR.getIdProfessor());
            UNIVERSITY_DAO.deleteUniversity(AUX_UNIVERSITY.getIdUniversity());
            COUNTRY_DAO.deleteCountry(AUX_COUNTRY.getIdCountry());
        } catch (DAOException exception) {
            Logger.getLogger(CourseRegistrationTest.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
    
    
}
