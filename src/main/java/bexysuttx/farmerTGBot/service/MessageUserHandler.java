package bexysuttx.farmerTGBot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageUserHandler {
	
	void FAQMessageHandler(Update update);
	
	void messageHandler(Update update, String status);
	
	void spamMessageHandler(Update update);

}
