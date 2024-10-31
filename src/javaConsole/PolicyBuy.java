package javaConsole;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class PolicyBuy {

	//LinkedHashMap<String,BasePolicyDO> policyMap = new LinkedHashMap<String,BasePolicyDO>();
	
	
	//termInsuranceDO t = new termInsuranceDO();
	premiumCalculationDO t = new premiumCalculationDO();
	
	Scanner scanner = new Scanner(System.in);
	
	
	//BasePolicyDO policy;
	
	
	public BasePolicyDO termInsu(BasePolicyDO policy){
		/* System.out.print("Enter PartySeq: ");
         String partySeq = scanner.next();*/
		System.out.println("enter Policy Seq ");
    	String policySeq = scanner.next();
    	System.out.println("enter sum assured amount ");
    	Double sumAssured = scanner.nextDouble();
    	
    	policy = new termInsuranceDO(policySeq, sumAssured);
    	//policyMap.put("termInsurance",policy);
    	//System.out.println(policyMap);
    	return policy;
	}
	
	
	
	public BasePolicyDO termHealth(BasePolicyDO policy){
		 /*System.out.print("Enter PartySeq: ");
         String partySeq = scanner.next();*/
		System.out.println("enter Policy Seq ");
    	String policySeq = scanner.next();
    	System.out.println("enter sum assured amount ");
    	Double sumAssured = scanner.nextDouble();
    	
    	
    	policy = new termHealthInsuranceDO(policySeq, sumAssured);
    
    	//policyMap.put("termHealthInsurance",policy);
    	return policy;
	}
	
	/*public void termInsurElse(LinkedHashMap<String,BasePolicyDO> policyMap){
		//BasePolicyDO policy = new BasePolicyDO();
		System.out.println(" you already have this policy if you buy again than override : 1: for again buy ; 2 for exit");
		int chh = scanner.nextInt();
		if(chh == 1){
			BasePolicyDO ti = termInsu(policy);
    		policyMap.put("termInsurance", ti);
    		System.out.println("Policy overridden successfully.");
		}else{
			System.out.println("no chanegs");
			
		}
	}*/
	public void policy(LinkedHashMap<String,BasePolicyDO> policyMap){
		
		BasePolicyDO s; 
		s= new BasePolicyDO();
		
       // BasePolicyDO policy = new BasePolicyDO();
        double premium = 0.0;
        
         boolean op = true;
        	while(op){
        		System.out.println("Select Policy Type: ");
                System.out.println("1. Term Insurance");
                System.out.println("2. Term Health Insurance");
                System.out.println("3. Exit");
                int policyTypeChoice = scanner.nextInt();
                

               
                switch(policyTypeChoice){
                case 1:
                	s.disclaimerMessage();
//                	if(!policyMap.containsKey("termInsurance"))
                	if(policyMap.isEmpty())
                	{
                		BasePolicyDO ti = termInsu(s);
                		policyMap.put("termInsurance", ti);
                		System.out.println("Policy purchased successfully1.");
                	}
                	else
                	{
	                	for(Entry<String, BasePolicyDO> po: policyMap.entrySet()){
	                		if(!po.getKey().equals("termInsurance")){
	                			BasePolicyDO ti = termInsu(s);
	                    		policyMap.put("termInsurance", ti);
	                    		System.out.println("Policy purchased successfully2.");
	                		}
	                		else{
	                    		System.out.println(" you already have this policy if you buy again than override : 1: for again buy ; 2 for exit");
	                    		int chh = scanner.nextInt();
	                    		if(chh == 1){
	                    			BasePolicyDO ti = termInsu(s);
	                        		policyMap.put("termInsurance", ti);
	                        		System.out.println("Policy overridden successfully.");
	                        		break;
	                    		}else{
	                    			System.out.println("no chanegs");
	                    			break;
	                    		/*termInsurElse(policyMap);*/
	                    		}
	                    	}
	                	}
                	}
//                	if(false==policyMap.co1ntainsKey("termInsurance")){
//                		BasePolicyDO ti = termInsu(s);
//                		policyMap.put("termInsurance", ti);
//                		System.out.println("Policy purchased successfully.");
//                    	}
                	
                	break;
                case 2:
                	s.disclaimerMessage();
                	if(!policyMap.containsKey("termHealthInsurance")){
                		BasePolicyDO th = termHealth(s);
                		policyMap.put("termHealthInsurance", th);
                    	}else{
                    		System.out.println(" you already have this policy if you buy again than override : 1: for again buy ; 2 for exit");
                    		int chh = scanner.nextInt();
                    		if(chh == 1){
                    			BasePolicyDO th = termHealth(s);
                    			policyMap.put("termHealthInsurance", th);
                    			System.out.println("Policy overridden successfully.");
                    		}else{
                    			break;
                    		}
                    	}
                	break;
                case 3:
                	op = false;
                	break;
                	
                }
        	}
			
        	
        
	
}
	
}
