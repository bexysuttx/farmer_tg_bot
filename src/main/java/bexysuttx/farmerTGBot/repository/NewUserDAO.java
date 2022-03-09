package bexysuttx.farmerTGBot.repository;

import java.util.Set;

public interface NewUserDAO {
	
	void addUser(String chatId);
	
	void removeUser(String chatId);
	
	
	Set<String> getUserChatId();

}
