package bexysuttx.farmerTGBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class RefCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;

	private final String[] text = new String[] {
			"CAACAgEAAxkBAAECyZ5hIXaDToBRNSljmR-xvX4JdowJpgAC_wgAAuN4BAABRm18DV8ewB0gBA",
			", у тебя есть отличная возможность заработать $$$, которые сможешь вывести или использовать как скидку.\n"
					+ "Думаю, ты и так знаешь, что такое рефералка и зачем она нужна.\n" + "\n"
					+ "За каждого, который купит программу по полной стоимости, ты разово получишь <b>20$</b>\n" + "\n"
					+ "Если твой реферал оформит партнёрские условия то с каждого кошелька, не зависимо от суммы, ты будешь получать <b>20%</b>\n"
					+ "\n"
					+ "Оставляй ссылку  на этот бот в инстаграм сторис, чатах и комментариях на ютубе и за хороший результат будешь приглашён в команду 🔥"
			+"\n" + "Если заинтересовало, то пиши на /contact" };

	public RefCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId = update.getMessage().getChatId().toString();
		sendBotMessageService.sendSticker(chatId, text[0]);

		for (int i = 1; i < text.length; i++) {
			sendBotMessageService.sendMessage(chatId, update.getMessage().getFrom().getFirstName() + text[i]);
		}
	}

}
