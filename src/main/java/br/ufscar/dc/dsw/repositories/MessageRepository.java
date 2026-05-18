package br.ufscar.dc.dsw.repositories;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MessageRepository {

    private final IMessageDAO messageDAO;

    public MessageRepository(IMessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public void save(Message message) {

        message.setTimestamp(new Date().toString());

        messageDAO.save(message);
    }

    public List<Message> getMessages() {
        return messageDAO.findAllOrderedByIdDesc();
    }
}