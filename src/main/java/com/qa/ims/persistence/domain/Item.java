package com.qa.ims.persistence.domain;

public class Item {

    private Long id;
    private String itemName;
    private Float price;

    public Item(String itemName, Float price) {
        this.setitemName(itemName);
        this.setprice(price);
    }

    public Item(Long id, String itemName, Float price) {
        this.setId(id);
        this.setitemName(itemName);
        this.setprice(price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getprice() {
        return price;
    }

    public void setprice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id:" + id + " item name:" + itemName + " price:" + price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (getitemName() == null) {
            if (other.getitemName() != null)
                return false;
        } else if (!getitemName().equals(other.getitemName()))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
    
}
