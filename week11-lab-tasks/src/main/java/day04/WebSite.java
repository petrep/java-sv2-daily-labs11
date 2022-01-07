package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebSite {
	private List<Item> items = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public void addItems(Item... items) {
		this.items.addAll(Arrays.asList(items));
	}

	public void addUsers(User... users) {
		this.users.addAll(Arrays.asList(users));
	}

	public void buyItem(String userName, String itemName) {
		User user = getUser(userName);
		Item item = getItem(itemName);
		sellItem(user, item);
	}

	private User getUser(String userName) {
		for (User actual : users) {
			if (actual.getUserName().equals(userName)) {
				return actual;
			}
		}
		throw new IllegalArgumentException("User not found!");
	}

	private Item getItem(String itemName) {
		for (Item actual : items) {
			if (actual.getName().equals(itemName)) {
				return actual;
			}
		}
		throw new IllegalArgumentException("Item not found!");
	}

	private void sellItem(User user, Item item) {
		user.addItem(item);
	}

	public List<Item> getItems() {
		return List.copyOf(items);
	}

	public List<User> getUsers() {
		return List.copyOf(users);
	}
}
