package bexysuttx.farmerTGBot.command;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class MainKeyboardDefault {

	protected void getMessage(ReplyKeyboardMarkup replyKeyboardMarkup) {
		List<KeyboardRow> keyboard = new ArrayList<>();
		KeyboardRow row1 = new KeyboardRow();
		KeyboardRow row2 = new KeyboardRow();
		KeyboardRow row3 = new KeyboardRow();
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);
		keyboard.clear();
		row1.clear();
		row2.clear();
		row3.clear();
		row1.add("Как это работает?");
		row1.add("FAQ");
		row2.add("Купить");
		row3.add("Контакты и отзывы");
		row3.add("Реферальная система");
		keyboard.add(row1);
		keyboard.add(row2);
		keyboard.add(row3);
		replyKeyboardMarkup.setKeyboard(keyboard);

	}
}
