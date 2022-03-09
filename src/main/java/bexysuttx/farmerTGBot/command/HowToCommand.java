package bexysuttx.farmerTGBot.command;



import org.telegram.telegrambots.meta.api.objects.Update;


import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class HowToCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;
	
	private final String sticker = "CAACAgEAAxkBAAECyaJhIXtn0lz1iaVQ-okmlZzSBTW5iQAC8QcAAuN4BAAB4g367hcQETogBA";
	
	private final String text2 = "Работа программы 👆\n"
			+ "\n"
			+ "🔹 Как видно, за одну генерацию проверяется <b>300 000 тысяч кошельков</b>, при среднем времени генерации 8 секунд!"
			+ "\n"
			+ "🔹<b> Максимальные показатели </b>на рынке, без прокси, скрытых установок.";
	
	private final String text = "<b>Что такое приватный и публичный ключ?</b>\n"
			+ "\n"
			+ "При создании биткоин-кошелька создается приватный ключ. Кошелек создает публичные ключи, которые хешируются и используются в качестве адресов для получения биткоинов. Приватный ключ необходим для подтверждения владения биткоинами, хранящимися по соответствующему адресу. Он же предоставляет возможность потратить монеты.\n"
			+ "\n"
			+ "Приватный ключ выглядит примерно так:\n"
			+ "\n"
			+ "<i>5J3nBbAG58CuQ346RNLpPUA</i>\n"
			+ "\n"
			+ "Приватный ключ генерируется не случайным образом, а с помощью мнемонической фразы. Эта фраза состоит из 12 слов. Они взяты из определенного набора из 2048 слов, известного как список слов Bip39.\n"
			+ "\n"
			+"Данная программа генерирует Seed-фразы, приватный ключи и проверяет баланс на кошельках. Когда будет найден кошелек с биткоинами, то программа сообщит и сохранит у Вас на компьютере данные для входа в кошелек."
			+ "\n"
			+ "\n"
			+ "Также можно попробовать сгенерировать кошелек вручную! Для того, чтобы сгенерировать подобную фразу можно воспользоваться сайтом:\n"
			+"https://iancoleman.io/bip39/"
			+"\n"+
			"\nДля ввода фразы и подключения к кошельку можно воспользоваться сайтом:\n"
			+"https://login.blockchain.com/en/#/recover";

	public HowToCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId =update.getMessage().getChatId().toString();
		sendBotMessageService.sendSticker(chatId, sticker);
		sendBotMessageService.sendMessage(chatId, text);
		sendBotMessageService.sendVideoMessage(chatId, "demo.MOV");
		sendBotMessageService.sendMessage(chatId, text2);

	}
	
}
