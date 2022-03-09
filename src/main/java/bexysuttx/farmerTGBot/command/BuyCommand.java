package bexysuttx.farmerTGBot.command;



import org.telegram.telegrambots.meta.api.objects.Update;


import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class BuyCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;
	
	private final String sticker = "CAACAgEAAxkBAAECyqthIs3anJjZiZfHiBlJSYw_T7uLtgAC6wcAAuN4BAABnwXByysQy_cgBA";
	
	private final String text = "🔥 Актуальная цена:        199$\n"
			+ "🌪 Всего по этой цене будет продано 12 версий.\n"
			+ "☄️ На данный момент продано 7/12.\n"
			+ "\n"
			+ "В стоимость входит: \n"
			+ "🔸 Консультация по установке\n"
			+ "🔸 Пароль к архиву от программы и выдача лицензии\n"
			+ "🔸 Обновления ПО и поддержка клиентов\n"
			+ "\n"
			+ "За покупкой 👉@cryptofarmer_biz";

	public BuyCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId =update.getMessage().getChatId().toString();
		sendBotMessageService.sendSticker(chatId, sticker);
		sendBotMessageService.sendImgMessage(chatId, "price.jpg");
		sendBotMessageService.sendMessage(chatId, text);

	}
	
}
