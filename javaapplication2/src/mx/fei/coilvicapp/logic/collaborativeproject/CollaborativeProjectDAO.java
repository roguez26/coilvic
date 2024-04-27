package mx.fei.coilvicapp.logic.collaborativeproject;


import mx.fei.coilvicapp.dataaccess.DatabaseManager;
import mx.fei.coilvicapp.logic.collaborativeproject.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvicapp.logic.implementations.DAOException;
import mx.fei.coilvicapp.logic.implementations.Status;

/*
 * @author d0ubl3_d
 */

public class CollaborativeProjectDAO implements ICollaborativeProject{
    
    public CollaborativeProjectDAO() {        
    }
    
    @Override
    public int insertCollaborativeProject(CollaborativeProject collaborativeProject) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "insert into ProyectoColaborativo (nombre, estado,"
        + " descripcion,  objetivoGeneral, modalidad, codigo, contrasena, rutaSyllabus)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet resultSet = null;
        int result = -1;
        
        try {
            connection = databaseManager.getConnection();
            preparedStatement = connection.prepareCall(statement);
            
            preparedStatement.setString(1,collaborativeProject.getName());
            preparedStatement.setString(2,collaborativeProject.getStatus());
            preparedStatement.setString(3,collaborativeProject.getDescription());
            preparedStatement.setString(4,collaborativeProject.getGeneralObjective());
            preparedStatement.setString(5,collaborativeProject.getModality());
            preparedStatement.setString(6,collaborativeProject.getIdentifier());
            preparedStatement.setString(7,collaborativeProject.getPassword());
            preparedStatement.setString(8,collaborativeProject.getSyllabusPath());
            
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            Logger.getLogger(CollaborativeProjectDAO.class.getName()).log(Level.SEVERE, null, exception);
            throw new DAOException("No fue posible registrar el proyecto colaborativo", Status.WARNING);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                Logger.getLogger(CollaborativeProjectDAO.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        return result;                
    }
    
    @Override
    public List<CollaborativeProject> getCollaborativeProjectsByStatus(String state) throws DAOException {
        List<CollaborativeProject> collaborativeProjects; 
        CollaborativeProject collaborativeProject = new CollaborativeProject();
        
    }
}
