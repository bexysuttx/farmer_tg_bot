package bexysuttx.farmerTGBot.command;



import org.telegram.telegrambots.meta.api.objects.Update;


import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class ExitCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;
	
	private final String text = "Что я еще могу рассказать?";

	public ExitCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), text);
		

	}
	
}
