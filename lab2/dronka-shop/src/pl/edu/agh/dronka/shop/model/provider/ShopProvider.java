package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.dronka.shop.model.*;
import pl.edu.agh.dronka.shop.model.categories.*;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Nazwa");
				int price = Integer.parseInt(reader.getValue(dataLine, "Cena"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Ilość"));

				boolean isPolish = Boolean.parseBoolean(reader.getValue(
						dataLine, "Tanie bo polskie"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(
						dataLine, "Używany"));

				ICategory categoryFileds = null;
				switch (category){
					case FOOD:
						String dataPrzydatnosci = reader.getValue(dataLine,"Data");
						categoryFileds = new Food(dataPrzydatnosci);
						break;
					case BOOKS:
						int liczbaStron = Integer.parseInt(reader.getValue(dataLine,
								"Liczba stron"));
						boolean twardaOprawa = Boolean.parseBoolean(reader.getValue(
								dataLine, "Twarda oprawa"));
						categoryFileds = new Book(liczbaStron,twardaOprawa);
						break;
					case MUSIC:
						boolean viedo = Boolean.parseBoolean(reader.getValue(
								dataLine, "Video"));
						GatunekMuzyki gatunek = GatunekMuzyki.parseGatunekMuzyki(reader.getValue(
								dataLine, "Gatunek"
						));
						categoryFileds = new Muzyka(viedo,gatunek);
						break;
					case SPORT:
						categoryFileds = new Sport();
						break;

					case ELECTRONICS:
						boolean mobilny = Boolean.parseBoolean(reader.getValue(
								dataLine, "Mobilny"));
						boolean gwarancja = Boolean.parseBoolean(reader.getValue(
								dataLine, "Gwarancja"));
						categoryFileds = new Elecrtronics(mobilny,gwarancja);
						break;
				}
				Item item = new Item(name, category, price, quantity,categoryFileds);
				item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);

				items.add(item);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
