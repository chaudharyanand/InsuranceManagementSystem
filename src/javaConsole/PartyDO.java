package javaConsole;

import java.util.ArrayList;
import java.util.Date;

public class PartyDO {
private String partyTypeCd;
private String partySeq;
private String title;
private String firstName;
private String lastName;
private Date birthDate;
private int age;
private String gender;
private ArrayList<PartyAddressDO> addresses;
private ArrayList<partyContactDO> contacts;

    public String getPartyTypeCd(){
	    return partyTypeCd;
   }

	public void setPartyTypeCd(String partyTypeCd){
    	this.partyTypeCd=partyTypeCd;
    }
    @Override
	public String toString() {
		return " partyTypeCd=" + partyTypeCd +"\r\n"+""+
	           " partySeq= " + partySeq +"\r\n"+""+ 
				" title=" + title + "\r\n"+""+
				" firstName=" + firstName+ "\r\n"+""+
				" lastName=" + lastName + "\r\n"+""+
				" birthDate=" + birthDate+"\r\n"+""+
				 " age=" + age + "\r\n"+""+
				" gender=" + gender +"\r\n"+""+
				" addresses=" + addresses + "\r\n"+""+
				" contacts=" + contacts + "\r\n"+"";
	}

	public String getPartySeq(){
    	return partySeq;
    }
    public void setPartySeq(String partySeq){
    	this.partySeq=partySeq;
    }
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName=firstName;
    }
    public String getLastName(){
    	return lastName;
    }
    public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setLastName(String lastName){
    	this.lastName=lastName;
    }
	
    public ArrayList<PartyAddressDO> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<PartyAddressDO> addresses) {
		this.addresses = addresses;
	}
	public ArrayList<partyContactDO> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<partyContactDO> contacts) {
		this.contacts = contacts;
	}

}
