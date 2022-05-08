package ua.advanced.practice8.Repository;

import ua.advanced.practice8.Entity.Participant;
import ua.advanced.practice8.EntityDAO.ParticipantDAO;
import ua.advanced.practice8.EntityDAO.PersonDAO;

import java.sql.Connection;
import java.util.List;

public class ParticipantRepositoryImpl {
    private Connection connection;
    private ParticipantDAO participantDAO;

    public ParticipantRepositoryImpl(Connection connection) {
        this.connection = connection;
        participantDAO = new ParticipantDAO(connection);
    }
    public boolean addParticipant(Participant participant){
        if(!participantDAO.findAll().contains(participant)){
            participantDAO.create(participant);
            return true;
        }
        return false;
    }
    public List<Participant> getAllParticipant(){
        return participantDAO.findAll();
    }
}
