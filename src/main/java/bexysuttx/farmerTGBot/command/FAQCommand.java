package bexysuttx.farmerTGBot.command;



import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import bexysuttx.farmerTGBot.service.SendBotMessageService;

public class FAQCommand extends MainKeyboardDefault implements Command {

	private final SendBotMessageService sendBotMessageService;
	
	private final String[] faq = new String[] {"CAACAgEAAxkBAAECyaRhIXy3y45a9yM8yrZ6QJL3uiCWlAACdAEAAusdUEV0An6f5xrl0CAE","1. <b>Зачем распространять продукт, когда можно зарабатывать самому?</b>\n"
			+ "\n"
			+ "❕ Я и сам пользуюсь своей программой. Эта сфера — неперепаханное  поле, чем быстрее мы отработаем кошельки старого типа, тем быстрее сможем перейти к новым, а для этого нужны ресурсы. К тому же, продажи приносят уверенность в полезности продукта.",
			
	"2. <b>Как быстро я получу свой первый результат?</b>\n"
	+ "\n"
	+ "❕Данная автоматизированная система парсит за сутки больше 1.5 млрд кошельков. Аналогов нет на рынке! Скажу лишь, что вероятность увеличивается пропорционально предпринятым попыткам. Хотя, знаю случаи, что ребята вручную находили аккаунты с балансом. Так что фактор удачи тут тоже присутствует."
	+ "\nСейчас большинство звезд используют криптовалюту для хранения своих активов, что увеличивает вероятность попасть на <b>жирный</b> кошелек.\nНекоторые из звезд: Илон Маск, репер Jay-Z, Линдси Лохан, Пэрис Хилтон и другие.",
	"3. <b>Какие минимальные требования для ПК?</b> \n"
	+ "\n"
	+ "❕Программа написана на C с подключением функционала Python'a. Если ваш компьютер тянет Windows 7 и браузер — потянет и программу",
	"4. <b>Что делать если попался кошелёк с балансом?</b>\n"
	+ "\n"
	+ "❕Выводить через биржу на свою карту или оффлайн обменник. Так же можете воспользоваться услугами миксера\n"
	+ "Пример биржи: https://t.me/BTC_CHANGE_BOT",
	"5. <b>Сильно ли программа грузит компьютер?</b>\n"
	+ "\n"
	+ "❕Стандартные настройки грузят систему, в среднем, на 20% на одном ядре.",
	"6.<b> Можно ли распространять программу?</b>\n"
	+ "\n"
	+ "❕Нет. На одного человека выдается от одного до трех лицензий. Предоставление доступа третьим лицам запрещено.",
	"7. <b> Моего вопроса нету в списке</b>\n"
	+ "\n"
	+ "❕Пиши админу. Вкладка \"Контакты\" /contacts",
	"Свой вопрос ты можешь оставить в поле ниже. Если вопросов нет — нажми, пожалуйста, \"🚫 Все понятно\""
	};
	
	public FAQCommand(SendBotMessageService sendBotMessageService) {
		this.sendBotMessageService = sendBotMessageService;
	}

	@Override
	public void execute(Update update) {
		getMessage(sendBotMessageService.getReplyKeyboardMarkup());
		String chatId=update.getMessage().getChatId().toString();
		sendBotMessageService.sendSticker(chatId, faq[0]);
		for (int i=1; i<faq.length; i++) {
		sendBotMessageService.sendMessage(chatId, faq[i]);
		}
		sendBotMessageService.setActionUser("Question", chatId);
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
