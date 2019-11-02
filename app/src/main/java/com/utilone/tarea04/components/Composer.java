package com.utilone.tarea04.components;

public class Composer {
  String firstName;
  String middleName;
  String lastName;
  String country;
  String DOB;
  String imageURL;
  String desc;

  public Composer(String name, String middleName, String lastName, String country, String DOB, String imageURL, String desc) {
    this.firstName = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.country = country;
    this.DOB = DOB;
    this.imageURL = imageURL;
    this.desc = desc;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDOB() {
    return DOB;
  }

  public void setDOB(String DOB) {
    this.DOB = DOB;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String imageURL) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return "Composer{" +
        "name='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", country='" + country + '\'' +
        ", DOB='" + DOB + '\'' +
        ", imageURL='" + imageURL + '\'' +
        ", desc='" + desc + '\'' +
        '}';
  }
}