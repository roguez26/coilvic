package mx.fei.coilvicapp.logic.collaborativeproject;

/*
 * @author d0ubl3_d
 */

public class CollaborativeProject {
    
    private int idCollaborativeProject = 0;
    private String name;
    private String status;
    private String description;
    private String generalObjective;
    private String modality;
    private String identifier;
    private String password;
    private String syllabusPath;
    
    public CollaborativeProject() { 
    }
    
    public int getIdCollaborativeProject() {
        return idCollaborativeProject;
    }
    
    public void setIdCollaborativeProject(int idCollaborativeProject) {
        this.idCollaborativeProject = idCollaborativeProject;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getGeneralObjective() {
        return generalObjective;
    }
    
    public void setGeneralObjective(String generalObjective) {
        this.generalObjective = generalObjective;
    }
    
    public String getModality() {
        return modality;
    }
    
    public void setModality(String modality) {
        this.modality = modality;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSyllabusPath() {
        return syllabusPath;
    }
    
    public void setSyllabusPath(String syllabusPath) {
        this.syllabusPath = syllabusPath;
    }
}
