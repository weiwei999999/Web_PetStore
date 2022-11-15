package src.domain;

import java.math.BigDecimal;

public class Pet {
    int petId;
    String petName;
    BigDecimal petPrice;
    int petInventory;
    String petDescription;

    public Pet() {

    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetPrice(BigDecimal petPrice) {
        this.petPrice = petPrice;
    }

    public void setPetInventory(int petInventory) {
        this.petInventory = petInventory;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public int getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public BigDecimal getPetPrice() {
        return petPrice;
    }

    public int getPetInventory() {
        return petInventory;
    }

    public String getPetDescription() {
        return petDescription;
    }

    @Override
    public String toString() {
        return "宠物id：" + petId + "\t宠物名称：" + petName + "\t宠物价格：" + petPrice + "\t宠物库存：" + petInventory + "\n宠物描述：" + petDescription;
    }
}
