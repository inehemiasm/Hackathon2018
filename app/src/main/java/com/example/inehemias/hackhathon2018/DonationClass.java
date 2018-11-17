package com.example.inehemias.hackhathon2018;

public class DonationClass {
    private static String name;
    private static String email;
    private static String phoneNumber;
    private int donationAmount;
    private String location;
    private String Company;


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(int donationAmount) {
        this.donationAmount = donationAmount;
    }

    public DonationClass(String name, String email, String phoneNumber, int donationAmount) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.donationAmount = donationAmount;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getCompanyName() {

        return Company;
    }
    public void setCompanyName(String company) {
        this.Company = company;
    }




}
