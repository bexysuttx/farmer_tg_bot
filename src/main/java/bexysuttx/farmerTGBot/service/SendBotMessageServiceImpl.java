package bexysuttx.farmerTGBot.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import bexysuttx.farmerTGBot.bot.CryptoEnvBot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

	private final CryptoEnvBot cryptoEnvBot;
	private ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

	@Autowired
	public SendBotMessageServiceImpl(CryptoEnvBot cryptoEnvBot) {
		this.cryptoEnvBot = cryptoEnvBot;
	}

	@Override
	public void sendMessage(String chatId, String message) {
		cryptoEnvBot.getActionUsers().put(chatId, "serf");

		SendMessage send = new SendMessage();
		send.setChatId(chatId);
		send.enableHtml(true);
		send.setText(message);

		send.setReplyMarkup(replyKeyboardMarkup);

		try {
			cryptoEnvBot.execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	public void setActionUser(String action, String chatId) {
		cryptoEnvBot.getActionUsers().put(chatId, action);
	}

	public String getActionUser(String chatId) {
		return cryptoEnvBot.getActionUsers().get(chatId);
	}

	public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
		return replyKeyboardMarkup;
	}

	@Override
	public void sendSticker(String chatId, String idSticker) {
		cryptoEnvBot.getActionUsers().put(chatId, "serf");

		SendSticker sendSticker = new SendSticker(chatId, new InputFile(idSticker));
		sendSticker.setReplyMarkup(replyKeyboardMarkup);

		try {
			cryptoEnvBot.execute(sendSticker);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public void contactSendMessage(String chatId, String message) {

		SendMessage send = new SendMessage();
		send.setChatId(chatId);
		send.enableHtml(true);
		send.setText(message);
		InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
		InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
		inlineKeyboardButton.setText("Мне нужна помощь!");
		inlineKeyboardButton.setCallbackData("/helpme");
		List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
		keyboardButtonsRow1.add(inlineKeyboardButton);
		List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
		rowList.add(keyboardButtonsRow1);
		inlineKeyboardMarkup.setKeyboard(rowList);
		send.setReplyMarkup(inlineKeyboardMarkup);
		//send.setReplyMarkup(replyKeyboardMarkup);
		try {
			cryptoEnvBot.execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendImgMessage(String chatId,  String img) {
		cryptoEnvBot.getActionUsers().put(chatId, "serf");
		SendPhoto send = new SendPhoto(chatId,new InputFile(new File(cryptoEnvBot.MEDIA_PREFIX+ img)));
		try {
			cryptoEnvBot.execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sendVideoMessage(String chatId, String video) {
		cryptoEnvBot.getActionUsers().put(chatId, "serf");
		SendVideo send = new SendVideo(chatId,new InputFile(new File(cryptoEnvBot.MEDIA_PREFIX+ video)));
		try {
			cryptoEnvBot.execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendSpamMessage(String chatId, String message) {
		cryptoEnvBot.getActionUsers().put(chatId, "serf");
		SendMessage send = new SendMessage();
		send.setChatId(chatId);
		send.enableHtml(true);
		send.setText(message);
		send.setReplyMarkup(replyKeyboardMarkup);
		try {
			cryptoEnvBot.execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	

}
