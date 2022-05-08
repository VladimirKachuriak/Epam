package ua.advanced.practice8.Repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.advanced.practice8.BasicConnectionPool;
import ua.advanced.practice8.ConnectionPool;
import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.Entity.Participant;
import ua.advanced.practice8.Entity.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantRepositoryImplTest {
    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void  init() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String url = resource.getString("db.url2");
        connectionPool = BasicConnectionPool.create(url, user, pass);
    }
    @Test
    void addParticipant() {
        Connection connection = connectionPool.getConnection();
        ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl(connection);
        assertEquals(12,participantRepository.getAllParticipant().size());
        assertEquals(true,participantRepository.addParticipant(new Participant("Avatar2",2, Person.Type.Actor)));
        assertEquals(false,participantRepository.addParticipant(new Participant("Avatar2",2, Person.Type.Actor)));
        assertEquals(13,participantRepository.getAllParticipant().size());
        connectionPool.releaseConnection(connection);
    }

    @Test
    void getAllParticipant() {
        Connection connection = connectionPool.getConnection();
        ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl(connection);
        assertEquals(12,participantRepository.getAllParticipant().size());
        connectionPool.releaseConnection(connection);
    }
}