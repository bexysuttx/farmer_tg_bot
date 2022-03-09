package bexysuttx.farmerTGBot.command;



import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class NoCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;

	public NoCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	private static final String NO_MESSAGE = "Команда не найдена:( Посмотрите список поддерживаемых комманд - /help";

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);

	}

}
