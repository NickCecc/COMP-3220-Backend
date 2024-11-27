package com.example.my_backend.model;

/**
 * Represents a house with various attributes such as price, location, size, and other details.
 */
public class House {
    private String brokeredBy;
    private String status;
    private double price;
    private int bed;
    private int bath;
    private double acreLot;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private double houseSize;
    private String prevSoldDate;

    /**
     * Constructs a House object with the specified attributes.
     *
     * @param brokeredBy   the name of the broker managing the house
     * @param status       the status of the house (e.g., "For Sale", "Sold")
     * @param price        the price of the house
     * @param bed          the number of bedrooms in the house
     * @param bath         the number of bathrooms in the house
     * @param acreLot      the lot size in acres
     * @param street       the street address of the house
     * @param city         the city where the house is located
     * @param state        the state where the house is located
     * @param zipCode      the ZIP code of the house
     * @param houseSize    the size of the house in square feet
     * @param prevSoldDate the previous sale date of the house
     */
    public House(String brokeredBy, String status, double price, int bed, int bath, double acreLot, String street, String city, String state, String zipCode, double houseSize, String prevSoldDate) {
        this.brokeredBy = brokeredBy;
        this.status = status;
        this.price = price;
        this.bed = bed;
        this.bath = bath;
        this.acreLot = acreLot;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.houseSize = houseSize;
        this.prevSoldDate = prevSoldDate;
    }

    /**
     * Retrieves the broker managing the house.
     *
     * @return the broker's name
     */
    public String getBrokeredBy() {
        return brokeredBy;
    }

    /**
     * Sets the broker managing the house.
     *
     * @param brokeredBy the broker's name
     */
    public void setBrokeredBy(String brokeredBy) {
        this.brokeredBy = brokeredBy;
    }

    /**
     * Retrieves the status of the house.
     *
     * @return the status of the house
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the house.
     *
     * @param status the status of the house
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the price of the house.
     *
     * @return the price of the house
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the house.
     *
     * @param price the price of the house
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the number of bedrooms in the house.
     *
     * @return the number of bedrooms
     */
    public int getBed() {
        return bed;
    }

    /**
     * Sets the number of bedrooms in the house.
     *
     * @param bed the number of bedrooms
     */
    public void setBed(int bed) {
        this.bed = bed;
    }

    /**
     * Retrieves the number of bathrooms in the house.
     *
     * @return the number of bathrooms
     */
    public int getBath() {
        return bath;
    }

    /**
     * Sets the number of bathrooms in the house.
     *
     * @param bath the number of bathrooms
     */
    public void setBath(int bath) {
        this.bath = bath;
    }

    /**
     * Retrieves the lot size of the house in acres.
     *
     * @return the lot size in acres
     */
    public double getAcreLot() {
        return acreLot;
    }

    /**
     * Sets the lot size of the house in acres.
     *
     * @param acreLot the lot size in acres
     */
    public void setAcreLot(double acreLot) {
        this.acreLot = acreLot;
    }

    /**
     * Retrieves the street address of the house.
     *
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address of the house.
     *
     * @param street the street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Retrieves the city where the house is located.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the house is located.
     *
     * @param city the city name
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the state where the house is located.
     *
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state where the house is located.
     *
     * @param state the state name
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieves the ZIP code of the house's location.
     *
     * @return the ZIP code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the ZIP code of the house's location.
     *
     * @param zipCode the ZIP code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Retrieves the size of the house in square feet.
     *
     * @return the house size
     */
    public double getHouseSize() {
        return houseSize;
    }

    /**
     * Sets the size of the house in square feet.
     *
     * @param houseSize the house size
     */
    public void setHouseSize(double houseSize) {
        this.houseSize = houseSize;
    }

    /**
     * Retrieves the previous sale date of the house.
     *
     * @return the previous sale date
     */
    public String getPrevSoldDate() {
        return prevSoldDate;
    }

    /**
     * Sets the previous sale date of the house.
     *
     * @param prevSoldDate the previous sale date
     */
    public void setPrevSoldDate(String prevSoldDate) {
        this.prevSoldDate = prevSoldDate;
    }
}
