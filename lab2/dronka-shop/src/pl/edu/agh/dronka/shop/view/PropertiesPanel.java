package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.ICategory;
import pl.edu.agh.dronka.shop.model.categories.*;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		filter.getItemSpec().setCategory(shopController.getCurrentCategory());

		add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		add(createPropertyCheckbox("Używany", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));


		switch (shopController.getCurrentCategory()) {
			case FOOD:
				filter.setICategory(new Food("-"));
				break;
			case BOOKS:
				filter.setICategory( new Book(0,false));
				add(createPropertyCheckbox("twarda Oprawa", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getICategory().setBoolianPropertie(
								((JCheckBox) event.getSource()).isSelected(),0);
						shopController.filterItems(filter);
					}
				}));
				break;
			case MUSIC:
				filter.setICategory(new Muzyka(false,GatunekMuzyki.HIPHOP));
				add(createPropertyCheckbox("film video", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getICategory().setBoolianPropertie(
								((JCheckBox) event.getSource()).isSelected(),0);
						shopController.filterItems(filter);
					}
				}));
				break;
			case SPORT:
				filter.setICategory(new Sport());
				break;
			case ELECTRONICS:
				filter.setICategory(new Elecrtronics(false,false));
				add(createPropertyCheckbox("mobilny", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getICategory().setBoolianPropertie(
								((JCheckBox) event.getSource()).isSelected(),0);
						shopController.filterItems(filter);
					}
				}));
				add(createPropertyCheckbox("gwarancja", new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getICategory().setBoolianPropertie(
								((JCheckBox) event.getSource()).isSelected(),1);
						shopController.filterItems(filter);
					}
				}));
				break;

		}

	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
