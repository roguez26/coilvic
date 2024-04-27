package mx.fei.coilvicapp.logic.collaborativeproject;

import java.util.List;
import mx.fei.coilvicapp.logic.implementations.DAOException;

/*
 * @author d0ubl3_d
 */

public interface ICollaborativeProject {
    
    public int insertCollaborativeProject(CollaborativeProject collaborativeProject) throws DAOException;
    public List<CollaborativeProject> getCollaborativeProjectsByStatus(String state) throws DAOException;
    
}
