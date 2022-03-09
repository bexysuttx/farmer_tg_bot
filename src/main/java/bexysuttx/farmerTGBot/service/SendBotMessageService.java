package bexysuttx.farmerTGBot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface SendBotMessageService {

	void sendMessage(String chatId, String message);

	ReplyKeyboardMarkup getReplyKeyboardMarkup();

	void setActionUser(String action, String chatId);

	String getActionUser(String chatId);

	void sendSticker(String chatId, String idSticker);

	void contactSendMessage(String chatId, String message);
	
	void sendImgMessage(String chatId, String img);
	
	void sendVideoMessage(String chatId, String video);
	
	void sendSpamMessage(String chatId, String message);
}
