package bexysuttx.farmerTGBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.repository.NewUserDAO;
import bexysuttx.farmerTGBot.repository.NewUserDAOImpl;
import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class StopCommand implements Command {

	private final SendBotMessageService sendBotMessageService;

	public static final String STOP_MESSAGE = "Деактивирован \uD83D\uDE1F.";
	private NewUserDAO newUserHandler = new NewUserDAOImpl();

	public StopCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
		newUserHandler.removeUser(update.getMessage().getChatId().toString());

	}
}