package bexysuttx.farmerTGBot.command;



import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class AdmSpamCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;
	
	private final String text2 = "Отправить всем сообщение👆\n";
	

	public AdmSpamCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId =update.getMessage().getChatId().toString();
		sendBotMessageService.sendMessage(chatId, text2);
		sendBotMessageService.setActionUser("Spam", chatId);
	
	}
	@Override
	protected void getMessage(ReplyKeyboardMarkup replyKeyboardMarkup) {
		List<KeyboardRow> keyboard = new ArrayList<>();
		KeyboardRow row1 = new KeyboardRow();
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);
		keyboard.clear();
		row1.clear();
		row1.add("Все понятно");
		keyboard.add(row1);
		replyKeyboardMarkup.setKeyboard(keyboard);
	}
	
}
