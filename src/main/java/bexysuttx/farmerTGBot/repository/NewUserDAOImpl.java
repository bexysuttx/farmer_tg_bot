package bexysuttx.farmerTGBot.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import bexysuttx.farmerTGBot.bot.CryptoEnvBot;

@Repository
public class NewUserDAOImpl implements NewUserDAO {

	@Override
	public void addUser(String chatId) {
		CryptoEnvBot.chatUsers.add(chatId);
	}

	@Override
	public void removeUser(String chatId) {
		CryptoEnvBot.chatUsers.remove(chatId);
	}
	
	

	@Override
	public Set<String> getUserChatId() {
		return CryptoEnvBot.chatUsers;
	}
	
	

}
