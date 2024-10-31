package javaConsole;


import java.awt.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.c2lbiz.symbiosys.systemcommon.util.DateUtil;
import com.c2lbiz.symbiosys.systemcommon.util.FileUtil;

public class PartyOperation {

	   /*ArrayList<PartyDO> partys = new ArrayList<PartyDO>();*/
	 public static boolean isStringOnlyAlphabet(String str)
	    {
	 
	        return ((str != null) && (!str.equals(""))
	                && (str.matches("^[a-zA-Z]*$")));
	    }
	 private static String setCountryCd(Scanner sc) {
	        String[] countryNames = {"India", "U.S", "Aust"};
	        System.out.println("Select a country:");
	        for (int i = 0; i < countryNames.length; i++) {
	            System.out.println((i + 1) + ". " + countryNames[i]);
	        }
	        int countryChoice = sc.nextInt();
	        if (countryChoice >= 1 && countryChoice <= countryNames.length) {
	            return countryNames[countryChoice - 1];
	        } else {
	            System.out.println("Invalid country choice.");
	            return null;
	        }
	    }
	 private static String setState(Scanner sc, String country) {
	        Map<String, ArrayList<String>> countryToStates = new HashMap<String, ArrayList<String>>();
	        countryToStates.put("India", new ArrayList<String>(Arrays.asList("Maharashtra", "Uttar Pradesh")));
	        countryToStates.put("U.S", new ArrayList<String>(Arrays.asList("Alaska", "Other U.S State")));
	       

	        if (countryToStates.containsKey(country)) {
	            ArrayList<String> validStates = countryToStates.get(country);
	            System.out.println("Select a state:");
	            for (int i = 0; i < validStates.size(); i++) {
	                System.out.println((i + 1) + ". " + validStates.get(i));
	            }
	            int stateChoice = sc.nextInt();
	            if (stateChoice >= 1 && stateChoice <= validStates.size()) {
	                return validStates.get(stateChoice - 1);
	            } else {
	                System.out.println("Invalid state choice.");
	                return null;
	            }
	        } else {
	            System.out.println("No states available for the selected country.");
	            return null;
	        }
	    }
	public PartyDO registerParty(){
		Scanner sc = new Scanner(System.in);
		PartyDO party = new PartyDO();
		
		System.out.println("Press 1 for Individual; Press 2 for Org");
		int ch = sc.nextInt();
		if(ch ==1 ){
			party.setPartyTypeCd("Individual");
		}else{
			party.setPartyTypeCd("Org");
		}
		System.out.println("Enter Part Seq");
		party.setPartySeq(sc.next());
		System.out.println("Press 1. For Mr.; 2. For Ms. 3 For Mrs");
		int chh = sc.nextInt();
		if(chh == 1){
			party.setTitle("Mr");
			party.setGender("Male");
		}else if(chh == 2){
			party.setTitle("Ms");
			party.setGender("Female");
		}else{
			party.setTitle("Mrs");
			party.setGender("Female");
		}
		 String firstName, lastName;
		while (true) {
            System.out.print("Enter your first name: ");
            firstName = sc.next();
            if (!isStringOnlyAlphabet(firstName)) {
                System.out.println("Invalid first name. Please enter only alphabetic characters.");
                continue; 
            }
            break; 
        }
	        
		
		while (true) {
            System.out.print("Enter your last name: ");
            lastName = sc.next();
            if (!isStringOnlyAlphabet(lastName)) {
                System.out.println("Invalid last name. Please enter only alphabetic characters.");
                continue; 
            }
            break; 
        }
		 party.setFirstName(firstName);
	        party.setLastName(lastName);
/// Future date Exception
	        while (true) {
	            System.out.println("Enter D.O.B");
	            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	            try {
	                Date date = sdf.parse(sc.next());
	                java.util.Date today = new java.util.Date();

	                if (date.after(today)) {
	                    throw new FutureDateException();
	                }

	                
	                 party.setBirthDate(date);
	                party.setAge(DateUtil.getAge(date, today));

	                break;
	            } catch (ParseException e) {
	                System.out.println("Invalid date format");
	            } catch (FutureDateException e) {
	                System.out.println(e.getMessage());
	            }
	        }

		
		/*partys.add(party);*/
		/*System.out.println("Enter Party Sequence Address");
		String pas = sc.next();*/
		 ArrayList<PartyAddressDO> addresses = new ArrayList<PartyAddressDO>();
	     ArrayList<partyContactDO> contacts = new ArrayList<partyContactDO>();
	     
	     while(true){
	    	 PartyAddressDO address = new PartyAddressDO();
	    	 System.out.println("enter partyAddressSeq ");
	    	 address.setPartyAddressSeq(sc.next());
	    	 //System.out.println("enter party Seq ");
	    	 address.setPartySeq(party.getPartySeq());
	    	 System.out.println("Address Type: Press 1. For RESIDENTIAL; Press 2. For OFFICE");
	    	 int at = sc.nextInt();
	    	 if(at == 1){
	    		 address.setAddressType("Residential");
	    	 }else{
	    		 address.setAddressType("OFFICE");
	    	 }
	    	 String selectedCountry = setCountryCd(sc);
	            if (selectedCountry == null) {
	                continue;
	            }

	            address.setCountaryCd(selectedCountry);
	    	 /*System.out.println("Select a country:");
	    	 System.out.println("1 . for Bharat:");
	    	 System.out.println("2. For U.S");
	    	 int countryChoice = sc.nextInt();

	            String selectedCountry = "";
	            ArrayList<String> validStates = null;

	            switch (countryChoice) {
	                case 1:
	                    selectedCountry = "India";
	                    validStates = new ArrayList<String>();
	                    validStates.add("Maharashtra");
	                    validStates.add("Uttar Pradesh");
	                    break;
	                case 2:
	                    selectedCountry = "U.S";
	                    validStates = new ArrayList<String>();
	                    validStates.add("U.S 1");
	                    validStates.add("U.S 2");
	                    break;
	                // Add cases for other countries

	                default:
	                    System.out.println("Invalid country choice.");
	            }

	            address.setCountaryCd(selectedCountry);

	            if (validStates != null) {
	                System.out.println("Select a state:");
	                for (int i = 0; i < validStates.size(); i++) {
	                    System.out.println((i + 1) + ". " + validStates.get(i));
	                }

	                int stateChoice = sc.nextInt();

	                if (stateChoice >= 1 && stateChoice <= validStates.size()) {
	                    address.setStateCd(validStates.get(stateChoice - 1));
	                } else {
	                    System.out.println("Invalid state choice.");
	                }
	            }
*/
	            String selectedState = setState(sc, selectedCountry);
	            if (selectedState == null) {
	                continue;
	            }

	            address.setStateCd(selectedState);
	    	 System.out.println("enter address detail");
	    	 
	    	 address.setAddressDetails(sc.next());
	    	 System.out.println("Enter Pin code ");
	    	 address.setPincode(sc.next());
	    	 System.out.println("set Primary address: 1. for Residential; 2. For Office");
	    	 int pa = sc.nextInt();
	    	 if(pa == 1){
	    		 address.setPrimaryAddress(address.getAddressType()); 
	    	 }else{
	    		 address.setPrimaryAddress("Office");
	    	 }
	    	 addresses.add(address);
	    	 System.out.println("Do you want to add another address? (Y/N)");
	    	 String responseA = sc.next();
	    	 if(!responseA.equalsIgnoreCase("Y")){
	    		 break;
	    	 }
	     }
	     party.setAddresses(addresses);
	     
	     while(true){
	    	 partyContactDO contact = new partyContactDO();
	    	 System.out.println("enter partyContactSeq");
	    	 contact.setPartyContactSeq(sc.next());
	    	 contact.setPartySeq(party.getPartySeq());
	    	 System.out.println("enter partyContact Number ");
	    	 contact.setContactNum(sc.next());
	    	 
	    	 System.out.println("press 1. for Home; 2. for Personel");
	    	 int choice = sc.nextInt();
	    	 if(choice == 1){
	    		 contact.setContactType("Home");
	    	 }else{
	    		 contact.setContactType("Personel");
	    	 }
	    	 contacts.add(contact);
	    	 System.out.println("Do you want to add another Contact? (Y/N)");
	            String response = sc.next();
	            if (!response.equalsIgnoreCase("Y")) {
	                break;
	            }
	     }
	     party.setContacts(contacts);
	    	
	    	
	     return party;
	     
	     
		//System.out.println(party.getAddresses());
	}
	public void dis(PartyDO party12){
		System.out.println(party12);
	}

		
	/*public void Display(String partySeq, HashMap<String, PartyDO> partyMap){
		PartyDO party = partyMap.get(partySeq);
		if(party != null ){
			System.out.println(party.getFirstName());
			System.out.println(party);
		}*/
		/*for(Map.Entry<String, PartyDO> an: partyMap.entrySet()){
			//PartyDO partys = an.getValue();
			PartyDO partys = an.setValue(party);
			System.out.println(partys.getAddresses());
			for(PartyAddressDO var: partys.getAddresses()){
				System.out.println(var);
			}
			//System.out.println(partys.getAddresses());
		}
		ArrayList<PartyAddressDO> addresses = party.getAddresses();
		 if (addresses != null && !addresses.isEmpty()) {
             System.out.println("Addresses:");
             for (PartyAddressDO address : addresses) {
                 System.out.println("PartyAddressSeq: " + address.getPartyAddressSeq());
                 System.out.println("AddressDetail: " + address.getAddressDetails());
                 System.out.println(address);
             }
         } else {
             System.out.println("No addresses found for this party.");
         }*/
	
	
	
	
	public void DeleteParty(String partySeq, HashMap<String,PartyDO> partyMap){
		PartyDO partyToDelete = partyMap.get(partySeq);
		if(partyToDelete != null){
			partyMap.remove(partySeq);
			System.out.println("party Deleted Successfully");
		}
	}
	public void partyUpdate(String partySeq, HashMap<String, PartyDO> partyMap){
		PartyDO party = partyMap.get(partySeq);
		 if (party != null) {
		        Scanner sc = new Scanner(System.in);
		        boolean op = true;
		        while(op){
		        	System.out.println("Party Details for PartySeq: " + partySeq);
		        	 System.out.println("1. Update Title");
		            System.out.println("2. Update Firstname");
		            System.out.println("3. Update Lastname");
		            System.out.println("4. Update OwnerType");
		            /*System.out.println("5. Update Address Detail");
		            System.out.println("6. Update Contact Details");*/
		            System.out.println("10. Finish Updating");
		            int ch = sc.nextInt();
		            switch(ch){
		            case 1:
		            	System.out.println("Select Title 1. For Mr, 2 For Mrs, 3 For Ms");
		            	int chh = sc.nextInt();
		        		if(chh == 1){
		        			party.setTitle("Mr");
		        			party.setGender("Male");
		        		}else if(chh == 2){
		        			party.setTitle("Ms");
		        			party.setGender("Female");
		        		}else{
		        			party.setTitle("Mrs");
		        			party.setGender("Female");
		        		}
		            	
		            	break;
		            case 2:
		            	System.out.println("Enter Updated First Name");
		            	party.setFirstName(sc.next());
		            	break;
		            case 3:
		            	System.out.println("Enter Updated Last Name");
		            	party.setLastName(sc.next());
		            	break;
		            case 4:
		            	System.out.println("Press 1 for Individual; Press 2 for Org");
		        		int cha = sc.nextInt();
		        		if(cha ==1 ){
		        			party.setPartyTypeCd("Individual");
		        		}else{
		        			party.setPartyTypeCd("Org");
		        		}
		            	break;
//		            
//		            	
		            case 10:
		            	System.out.println("Exit");
		            	op = false;
		            	
		            	default:
		            		System.out.println("Invalid OP");
		            		break;
		            }
		        }
		 }
	}
	
	public void updateAddressDetail(PartyDO partyToUpdate, String addressSeqToUpdate1) {
	    if (partyToUpdate != null) {
	        ArrayList<PartyAddressDO> addresses = partyToUpdate.getAddresses();
	       // boolean found = false;
          Scanner sc = new Scanner(System.in);
	        for (PartyAddressDO address : addresses) {
	            if (address.getPartyAddressSeq().equals(addressSeqToUpdate1)) {
	         //   	 found = true;
	                while (true) {
	                    System.out.println("Select the detail to update for AddressSeq " + addressSeqToUpdate1 + ":");
	                    System.out.println("1. Update Pin Code");
	                    System.out.println("2. Update Address Detail");
	                    System.out.println("3. Update Country and State");
	                    System.out.println("4. Finish Updating Address");
	                    
	                    int choice = sc.nextInt();
	                    sc.nextLine(); // Consume the newline character
	                    
	                    switch (choice) {
	                        case 1:
	                            System.out.println("Enter the new Pin Code:");
	                            String newPinCode = sc.nextLine();
	                            address.setPincode(newPinCode);
	                            break;
	                        case 2:
	                            System.out.println("Enter the new Address Detail:");
	                            String newAddressDetail = sc.nextLine();
	                            address.setAddressDetails(newAddressDetail);
	                            break;
	                        case 3:
	                            
	                            /*System.out.println("Enter the new Country:");
	                            String newCountry = sc.nextLine();
	                            address.setCountaryCd(newCountry);
	                            System.out.println("Enter the new State:");
	                            String newState = sc.nextLine();
	                            address.setStateCd(newState);*/
	                        	String selectedCountry = setCountryCd(sc);
	            	            /*if (selectedCountry == null) {
	            	                continue;
	            	            }*/

	            	            address.setCountaryCd(selectedCountry);
	            	            String selectedState = setState(sc, selectedCountry);
	            	           /* if (selectedState == null) {
	            	                continue;
	            	            }*/

	            	            address.setStateCd(selectedState);
	            	            
	                            break;
	                        case 4:
	                            return; 
	                        default:
	                            System.out.println("Invalid choice.");
	                    }
	                }
	            }else{
					System.out.println("Party not found.");
				}
	        }

	        /*if (!found) {
	            System.out.println("AddressSeq not found.");
	        }*/
	    } else {
	        System.out.println("Party not found.");
	    }
	}
	
	public void updateContact(PartyDO partySeqCU, String contactSeqToUp){
		Scanner sc = new Scanner(System.in);
		if(partySeqCU != null){
			ArrayList<partyContactDO> contacts = partySeqCU.getContacts();
			for(partyContactDO contact: contacts ){
				if(contactSeqToUp.equals(contact.getPartyContactSeq())){
					while(true){
					System.out.println("press 1 for Contact Type ");
					System.out.println("press 2 for contact No");
					System.out.println("press 3 for Exit");
					int chhh = sc.nextInt();
					switch(chhh){
					case 1:
						System.out.println(": press 1 for Home; Press 2 for Personal ");
						int ch = sc.nextInt();
						if(ch==1){
							contact.setContactType("Home");
						}else{
							contact.setContactType("Personel");
						}
						break;
					case 2:
						System.out.println("Enter Contact No");
						contact.setContactNum(sc.next());
						break;
					case 3:
						return;
						default:
							System.out.println("invalid choice. ");
					}
				}
				}else{
					System.out.println("party contact seq not found");
				}
			}
		}else{
			System.out.println("party not found");
		}
	}
	
	public void download(PartyDO party){
		final String dirPath = "C:\\Users\\anand.chaudhary\\Desktop\\Anand\\";
		 String fileName = ".txt";
		 String abc = party.getFirstName();
		 String s = abc+fileName;
		String and = party.toString();
		//String an = party.getLastName();
		//String full = and.concat(an);
		try {
			FileUtil.createFile(dirPath, s, and);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
