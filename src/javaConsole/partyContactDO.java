package javaConsole;

public class partyContactDO {
private String partyContactSeq;
private String partySeq;
private String contactType;
private String contactNum;
public String getPartyContactSeq() {
	return partyContactSeq;
}
public void setPartyContactSeq(String partyContactSeq) {
	this.partyContactSeq = partyContactSeq;
}
public String getPartySeq() {
	return partySeq;
}
public void setPartySeq(String partySeq) {
	this.partySeq = partySeq;
}
@Override
public String toString() {
	return " partyContactSeq=" + partyContactSeq + "\n\r"+
			" partySeq="+ partySeq + "\n\r"+
			" contactType=" + contactType + "\n\r"+
			" contactNum="+ contactNum + "\n\r";
}
public String getContactType() {
	return contactType;
}
public void setContactType(String contactType) {
	this.contactType = contactType;
}
public String getContactNum() {
	return contactNum;
}
public void setContactNum(String contactNum) {
	this.contactNum = contactNum;
}
}
