package nl.utwente.soa.inventoryApplication.services;


import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private static int currentInventory = 100;

    public int getCurrentInventory(){
        return InventoryService.currentInventory;
    }

    public void addInventory(int amount){
        InventoryService.currentInventory += amount;
    }

    public void subtractInventory(int amount){
        if(amount < InventoryService.currentInventory){
            InventoryService.currentInventory -= amount;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

}
