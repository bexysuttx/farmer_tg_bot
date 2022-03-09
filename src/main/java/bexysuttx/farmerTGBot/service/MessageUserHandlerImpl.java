package bexysuttx.farmerTGBot.service;

import java.util.Map;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.bot.CryptoEnvBot;
import bexysuttx.farmerTGBot.command.MainKeyboardDefault;

public class MessageUserHandlerImpl extends MainKeyboardDefault implements MessageUserHandler {

	private SendBotMessageService sendBotMessageService;

	private static String FAQTemplate1 = "Вопрос от: ";

	public MessageUserHandlerImpl(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void FAQMessageHandler(Update update) {
		String chatId = update.getMessage().getChatId().toString();
		Message message = update.getMessage();
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		sendBotMessageService.sendMessage("473079289",
				FAQTemplate1 + "@" + message.getFrom().getUserName() + ":  \n " + message.getText());
		sendBotMessageService.sendMessage(chatId,
				message.getFrom().getFirstName() + ", вопрос принят! Скоро с Вами свяжутся.");
		sendBotMessageService.setActionUser("serf", chatId);
	}

	@Override
	public void messageHandler(Update update, String status) {
		if (status.equals("Question")) {
			FAQMessageHandler(update);
		} else if (status.equals("Spam")) {
			spamMessageHandler(update);
		}
	}

	@Override
	public void spamMessageHandler(Update update) {
		String message = update.getMessage().getText();
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		Map<String, String> allUsers = CryptoEnvBot.getStaticActionUsers();
		for (String user : allUsers.keySet()) {
			sendBotMessageService.sendSpamMessage(user, message);
		}

	}

}
