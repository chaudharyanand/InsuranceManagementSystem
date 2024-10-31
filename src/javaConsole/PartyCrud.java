package javaConsole;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PartyCrud {
	 PartyOperation p = new PartyOperation();
	 HashMap<String, PartyDO> partyMap = new LinkedHashMap<String, PartyDO>();
	 public  PartyDO findPartyBySeq(String partySeq) {
	        return partyMap.get(partySeq);
	    }
	
	 public ArrayList<BasePolicyDO> getAllPoliciesForParty(String partySeq) {
		 ArrayList<BasePolicyDO> policyList = new ArrayList<BasePolicyDO>();
		    
		    LinkedHashMap<String, BasePolicyDO> innerMap = PartyPolicyMap.get(partySeq);
		    
		    if (innerMap != null) {
		        for (BasePolicyDO policy : innerMap.values()) {
		            policyList.add(policy);
		        }
		    }
		    
		    return policyList;
		}
	 
	  LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>> PartyPolicyMap = new LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>>();
	 
	  public void buyPolicy(LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>> PartyPolicyMap) {
		    Scanner scanner = new Scanner(System.in);

		    System.out.print("Enter PartySeq: ");
		    String partySeq = scanner.next();
		   LinkedHashMap<String, BasePolicyDO> policyMap = null;//= new LinkedHashMap<String, BasePolicyDO>();
		    PolicyBuy policyBuy = new PolicyBuy();

		    if (partyMap.containsKey(partySeq)) {
		        boolean hasTermHealthInsurance = false;
		        boolean hasTermInsurance = false;

		        for (Entry<String, LinkedHashMap<String, BasePolicyDO>> ann : PartyPolicyMap.entrySet()) {
		            if(ann.getKey().equals(partySeq))
		            {
		            	policyMap=ann.getValue();
		            	
			        	for (Entry<String, BasePolicyDO> policyData : policyMap.entrySet()) {
			                if (policyData.getKey().equals("termHealthInsurance")) {
//			                	LinkedHashMap<String, BasePolicyDO> an = ann.getValue();
//			                	PartyPolicyMap.put(partySeq,an);
			                	policyData.getValue();
			                    hasTermHealthInsurance = true;
			                } 
			                if (policyData.getKey().equals("termInsurance")) {
			                    hasTermInsurance = true;
//			                    LinkedHashMap<String, BasePolicyDO> an = ann.getValue();
//			                    PartyPolicyMap.put(partySeq,an);
			                }
			                
			        	}
		            }
		        }
		        
		        if (hasTermHealthInsurance && hasTermInsurance) {
		            System.out.println("You already have both policies.");
		            System.out.println("1. Buy another policy; 2. Exit");
		            int choice = scanner.nextInt();
		            if (choice == 1) {
		                policyBuy.policy(policyMap);
		            	//if(PartyPolicyMap.containsKey("termHealthInsurance"))
		                PartyPolicyMap.put(partySeq, policyMap);
		            } else {
		                // User chose to exit
		                return;
		            }
		        } else if (hasTermHealthInsurance || hasTermInsurance) {
		            String existingPolicy = hasTermHealthInsurance ? "termHealthInsurance" : "termInsurance";
		            System.out.println("You already have " + existingPolicy + " policy.");
		            System.out.println("1. Buy another policy; 2. Exit");
		            int choice = scanner.nextInt();
		            if (choice == 1) {
		                policyBuy.policy(policyMap);
		                PartyPolicyMap.put(partySeq, policyMap);
		            } else {
		                // User chose to exit
		                return;
		            }
		        } else {
		            // User has no policies, so we direct them to the policy method.
		        	policyMap = new LinkedHashMap<String, BasePolicyDO>();
		        	policyBuy.policy(policyMap);
		            PartyPolicyMap.put(partySeq, policyMap);
		        }
		    } else {
		        System.out.println("Party is not registered.");
		    }
		}
	  
	 
	  
	  public void IncreasePre(LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>> PartyPolicyMap){
		  
		  for (Entry<String, LinkedHashMap<String, BasePolicyDO>> ann : PartyPolicyMap.entrySet()){
			  for (Entry<String, BasePolicyDO> policyData : ann.getValue().entrySet()){
				 
					  BasePolicyDO pr = policyData.getValue();
					  if(pr instanceof termInsuranceDO){
						  double pre = ((termInsuranceDO) pr).getPremiumAmt()*1.05;
						  ((termInsuranceDO) pr).setPremiumAmt(pre);
						  
					  }else{
						 // pr instanceof termHealthInsuranceDO
						  double hpamt = ((termHealthInsuranceDO) pr).getPremiumAmt()*1.07;
						  ((termHealthInsuranceDO) pr).setPremiumAmt(hpamt);
					  }
				  
			  }
		  }
	  }

	public void partyCrudOp(){
		Scanner sc = new Scanner(System.in);
		//PartyCrud as = new PartyCrud();
		//as.IncreasePre(PartyPolicyMap);
		while(true){
			System.out.println("------------Menu-----------");
			System.out.println("1. For Register Party");
			System.out.println("2. For Display Party");
			System.out.println("3. For Update Party");
			System.out.println("4. For Delete Party");
			System.out.println("5. For Update Party Address ");
			System.out.println("6. For Update PartyContact ");
			System.out.println("7. enter party seq to Download Party Details");
			System.out.println("8. enter party seq to Buy Policy");
			
			System.out.println("9. enter party seq to View Policy Details");
			System.out.println("10. update premium");
			
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			switch(ch){
			case 1:
				PartyDO party = (PartyDO) p.registerParty();
				partyMap.put(party.getPartySeq(), party);
				//System.out.println(party);//
				for(Map.Entry<String, PartyDO> an: partyMap.entrySet()){
					System.out.println(an.getValue());
				}
				break;
			case 2:
				System.out.println("Enter Party Sequence ");
				String partySeq = sc.next();
				PartyDO findParty=findPartyBySeq(partySeq);
				if(findParty != null){
					//p.Display(partySeq,partyMap);

					p.dis(findParty);

				}else{
					System.out.println("No Party");
				}
				break;
			case 3:
				System.out.println("Enter Party Sequence ");
				String partySeqU = sc.next();
				PartyDO findPartyU=findPartyBySeq(partySeqU);
				if(findPartyU != null){
					p.partyUpdate(partySeqU,partyMap);
				}else{
					System.out.println("No Party");
				}
				    break;
			case 4:
				
				System.out.println("Enter Party Seq");
				String partySeqDelete = sc.next();
				PartyDO find = findPartyBySeq(partySeqDelete);
				if(find != null){
					partyMap.remove(partySeqDelete);
				}else{
					System.out.println("no party");
				}
				break;
			case 5:
				while (true) {
			        System.out.println("Enter the partySeq to update:");
			        String partySeqToUpdate = sc.next();
			        PartyDO partyToUpdate = findPartyBySeq(partySeqToUpdate);
			        
			        if (partyToUpdate != null) {
			            System.out.println("Enter the AddressSeq to update:");
			            String addressSeqToUpdate = sc.next();
			            p.updateAddressDetail(partyToUpdate, addressSeqToUpdate);
			            
			            System.out.println("Do you want to update another address detail? (Y/N)");
			            String response = sc.nextLine();
			            if (!response.equalsIgnoreCase("Y")) {
			                break;
			            }
			        } else {
			            System.out.println("Party not found.");
			        }
			    }
			    break;
			case 6:
				while(true){
					System.out.println("enter party seq to update contact detail");
					String partySeqC = sc.next();
					PartyDO partySeqCU = findPartyBySeq(partySeqC);
					if(partySeqCU != null){
						System.out.println("enter contact seq to update");
						String contactSeqToUp = sc.next();
						p.updateContact(partySeqCU, contactSeqToUp);
						System.out.println("Do you want to update another address detail? (Y/N)");
			            String response = sc.nextLine();
			            if (!response.equalsIgnoreCase("Y")) {
			                break;
			            }
					}else{
						System.out.println("Party not found.");
					}
				}
				break;
			case 7:
				System.out.println("enter party seq to Download Party Details");
				String partSeq = sc.next();
				PartyDO partyD = findPartyBySeq(partSeq);
				if(partyD != null){
					p.download(partyD);
				}else{
					System.out.println(" party Not Found");
				}
				
				break;
			
				
			
			case 8:
				  //LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>> PartyPolicyMap = new LinkedHashMap<String,LinkedHashMap<String,BasePolicyDO>>();

				buyPolicy(PartyPolicyMap);
				break;
			case 9:
				System.out.println("Enter Party Sequence: ");
				String partySeq5 = sc.next();
				/*ArrayList<BasePolicyDO> policies = getAllPoliciesForParty(partySeq5);

				if (!policies.isEmpty()) {
				    System.out.println("Policies for Party " + partySeq5 + ":");
				    for (BasePolicyDO policy : policies) {
				        // Display policy information here
				        System.out.println(policy);
				       
				    }
				} else {
				    System.out.println("No Policies found for Party " + partySeq5);
				}*/
				System.out.println(PartyPolicyMap.get(partySeq5));
				break;
			case 10:
				IncreasePre(PartyPolicyMap);
				break;
			
			}
	}
  }
}
