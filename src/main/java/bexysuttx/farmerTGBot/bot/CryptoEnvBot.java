package bexysuttx.farmerTGBot.bot;

import static bexysuttx.farmerTGBot.command.CommandName.NO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import bexysuttx.farmerTGBot.command.CommandAdminContainer;
import bexysuttx.farmerTGBot.command.CommandContainer;
import bexysuttx.farmerTGBot.service.MessageUserHandler;
import bexysuttx.farmerTGBot.service.MessageUserHandlerImpl;

import bexysuttx.farmerTGBot.service.SendBotMessageService;
import bexysuttx.farmerTGBot.service.SendBotMessageServiceImpl;

@Component
public class CryptoEnvBot extends TelegramLongPollingBot {

	public static final String COMMAND_PREFIX = "/";
	
	public static final String[] ADMINS = new String[] {"473079289"};
	
	public final String MEDIA_PREFIX="static/img/";

	public static final String[] COMMANDS_KEYBOARD = new String[] { "Как это работает?", "FAQ", "Все понятно",
			"Контакты и отзывы", "Реферальная система", "Купить" };
	
	public static Set<String> chatUsers;

	private final MessageUserHandler messageUserHandler;

	private static Map<String, String> actionUsers = new HashMap<>();
	


	@Value("${bot.username}")
	private String userName;

	@Value("${bot.token}")
	private String token;

	private final CommandContainer container;
	private final CommandAdminContainer admContainer;

	public CryptoEnvBot() {
		SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(this);
		this.container = new CommandContainer(sendBotMessageService);
		this.messageUserHandler = new MessageUserHandlerImpl(sendBotMessageService);
		this.admContainer = new CommandAdminContainer(sendBotMessageService);
	}
	
	static {
		initUsrs();
	}

	private static void initUsrs() {
		chatUsers = new HashSet<>();
		File file = new File("user_chat_id.txt");
		try (Stream<String> linesStream = Files.lines(file.toPath())){
			linesStream.forEach(line-> {
				chatUsers.add(line);		
		});
		} catch (IOException e) {
			System.out.println("Files user_chatId not found!");
			e.printStackTrace();
		}
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String message = update.getMessage().getText().trim();
			if (message.startsWith(COMMAND_PREFIX)) {
				String commandIdentifier = message.split(" ")[0].toLowerCase();
				if (commandIdentifier.equals("spam") && Arrays.stream(ADMINS).anyMatch(update.getMessage().getChatId().toString()::equals)) {
					admContainer.retrieveCommand(commandIdentifier).execute(update);
				}
				container.retrieveCommand(commandIdentifier).execute(update);
			} else if (Arrays.stream(COMMANDS_KEYBOARD).anyMatch(message::equals)) {
				container.retrieveCommand(message).execute(update);
			} else if (actionUsers.get(update.getMessage().getChatId().toString()) != "serf"
					&& actionUsers.containsKey(update.getMessage().getChatId().toString())) {
				messageUserHandler.messageHandler(update, actionUsers.get(update.getMessage().getChatId().toString()));
			} else {

				container.retrieveCommand(NO.getCommandName()).execute(update);
			}

		} else if (update.hasCallbackQuery()) {
			String message = update.getCallbackQuery().getData().trim();
			if (message.startsWith(COMMAND_PREFIX)) {
				String commandIdentifier = message.split(" ")[0].toLowerCase();
				container.retrieveCommand(commandIdentifier).execute(update);
			} 
		}
	}

	@Override
	public String getBotUsername() {
		return userName;
	}

	@Override
	public String getBotToken() {
		return token;
	}

	public Map<String, String> getActionUsers() {
		return actionUsers;
	}
	
	public static Map<String, String> getStaticActionUsers() {
		return actionUsers;
	}

}
