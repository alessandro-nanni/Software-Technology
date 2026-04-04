package nl.utwente.soa.inventoryApplication.commands;

import nl.utwente.soa.inventoryApplication.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class InventoryCommands {

	@Autowired
	private InventoryService inventoryService;

	@ShellMethod("Sell inventory")
	public String sell(int amount) {
		inventoryService.subtractInventory(amount);
		return "Sold inventory";
	}

	@ShellMethod("Buy new inventory")
	public String purchase(int amount) {

		// Request to the Purchase service should be done here!!!
		inventoryService.addInventory(amount);
		return "More " + amount + " items in the inventory";
	}

	@ShellMethod("Get Current inventory")
	public String current() {
		return "Current inventory: " + inventoryService.getCurrentInventory();

	}
}
