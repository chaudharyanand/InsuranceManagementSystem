package javaConsole;

public class PartyAddressDO {
private String partyAddressSeq;
private String partySeq;
private String addressType;
private String countaryCd;
private String stateCd;
private String addressDetails;
private String pincode;
private String primaryAddress;
public String getPartyAddressSeq() {
	return partyAddressSeq;
}
public void setPartyAddressSeq(String partyAddressSeq) {
	this.partyAddressSeq = partyAddressSeq;
}
public String getPartySeq() {
	return partySeq;
}
public void setPartySeq(String partySeq) {
	this.partySeq = partySeq;
}
@Override
public String toString() {
	return  " partyAddressSeq=" + partyAddressSeq + "\r\n" +
			" partySeq=" + partySeq + "\r\n"+
			" addressType=" + addressType + "\r\n"+
			" countaryCd=" + countaryCd + "\r\n"+
			" stateCd=" + stateCd + "\r\n"+
			" addressDetails="+ addressDetails + "\r\n"+
			" pincode=" + pincode + "\r\n"+
			" primaryAddress=" + primaryAddress + "\r\n";
}
public String getAddressType() {
	return addressType;
}
public void setAddressType(String addressType) {
	this.addressType = addressType;
}
public String getCountaryCd() {
	return countaryCd;
}
public void setCountaryCd(String countaryCd) {
	this.countaryCd = countaryCd;
}
public String getStateCd() {
	return stateCd;
}
public void setStateCd(String stateCd) {
	this.stateCd = stateCd;
}
public String getAddressDetails() {
	return addressDetails;
}
public void setAddressDetails(String addressDetails) {
	this.addressDetails = addressDetails;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getPrimaryAddress() {
	return primaryAddress;
}
public void setPrimaryAddress(String primaryAddress) {
	this.primaryAddress = primaryAddress;
}

}
