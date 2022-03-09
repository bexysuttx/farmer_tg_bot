package bexysuttx.farmerTGBot.command;


import org.telegram.telegrambots.meta.api.objects.Update;


import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class ContactCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;

	private final String[] text = new String[] {
			"CAACAgEAAxkBAAECxb5hHXoHrPAfSNiky2XAdnXbiZb5zwACBQkAAuN4BAABRCSrhL41Bb8gBA", "Новостной канал: XXX",
			"Отзывы: XXX", "Админ: XXX" };

	public ContactCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId = update.getMessage().getChatId().toString();
		sendBotMessageService.sendSticker(chatId, text[0]);

		for (int i = 1; i < text.length - 1; i++) {
			sendBotMessageService.sendMessage(chatId, text[i]);
		}
		sendBotMessageService.contactSendMessage(chatId, text[text.length - 1]);

	}

}
