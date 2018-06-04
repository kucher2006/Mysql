package zad3;

import org.apache.logging.log4j.message.Message;

public interface MessageRepo {

	Iterable<Message> findAll();

}
