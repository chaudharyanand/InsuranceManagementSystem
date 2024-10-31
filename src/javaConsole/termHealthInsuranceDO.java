package javaConsole;

public class termHealthInsuranceDO extends BasePolicyDO{
	@Override
	public String toString() {
		return "termHealthInsuranceDO [policySeq=" + policySeq
				+ ", premiumAmt=" + premiumAmt + ", sumAssured=" + sumAssured
				+ ", healthCover=" + healthCover + "]";
	}
	private String policySeq;
	 private Double premiumAmt;
	 private Double sumAssured;
	 
	
	
	
	

	public termHealthInsuranceDO(String policySeq2, Double sumAssured2) {
		// TODO Auto-generated constructor stub
		this.policySeq=policySeq2;
		this.sumAssured=sumAssured2;
		termHealthInsuranceDO.this.setPremiumAmt(premiumCalculationDO.premiumCalTermHealthIns(sumAssured2));
		this.healthCover=0.05*sumAssured2;
	}



	public String getPolicySeq() {
		return policySeq;
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
	public Double getHealthCover() {
		return healthCover;
	}
	public void setHealthCover(Double healthCover) {
		this.healthCover = healthCover;
	}
	private Double healthCover;
}
