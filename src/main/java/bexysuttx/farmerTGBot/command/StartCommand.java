package bexysuttx.farmerTGBot.command;


import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.repository.NewUserDAO;
import bexysuttx.farmerTGBot.repository.NewUserDAOImpl;
import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class StartCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;

	
	private NewUserDAO newUserHandler = new NewUserDAOImpl();

	
	public StartCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	private static final String START_MESSAGE = "Привет, ";
	private static final String text = "👋🏻\n"
			+ "Я - автоматизированный помощник в мире криптобизнеса.🤖\n"
			+ "Выбери в меню интересующий раздел, и я расскажу подробнее!😊";

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
				START_MESSAGE + update.getMessage().getFrom().getFirstName().toString() + text);
		newUserHandler.addUser(update.getMessage().getChatId().toString());

	}

}
