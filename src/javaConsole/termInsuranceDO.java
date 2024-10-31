package javaConsole;

public class termInsuranceDO extends BasePolicyDO{
 private String policySeq;
 private Double premiumAmt;
 private Double sumAssured;
 
 

public termInsuranceDO(String policySeq, Double sumAssured) {
	// TODO Auto-generated constructor stub
	//super();
	
	this.policySeq=policySeq;
	//this.premiumAmt=pr;
	this.sumAssured=sumAssured;
	termInsuranceDO.this.setPremiumAmt(premiumCalculationDO.premiumCalTermIns(sumAssured));
	}
public termInsuranceDO() {
	// TODO Auto-generated constructor stub
}
public String getPolicySeq() {
	return policySeq;
}
@Override
public String toString() {
	return "termInsuranceDO [policySeq=" + policySeq + ", premiumAmt="
			+ premiumAmt + ", sumAssured=" + sumAssured + "]";
}
public void setPolicySeq(String policySeq) {
	this.policySeq = policySeq;
}
public Double getPremiumAmt() {
	return premiumAmt;
}
public void setPremiumAmt(Double premiumAmt) {
	this.premiumAmt = premiumAmt;
}
public Double getSumAssured() {
	return sumAssured;
}
public void setSumAssured(Double sumAssured) {
	this.sumAssured = sumAssured;
}
}
