
public class PremiumMember extends GymMember{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    

     public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String personalTrainer){
          super(id,name,location,phone,email,gender,DOB,membershipStartDate);
          this.personalTrainer=personalTrainer;
          this.premiumCharge=50000;
          this.paidAmount=0;
          this.isFullPayment=false;
          this.discountAmount=0;
             
             
    }
    
    //accessor method
    public double getPremiumCharge(){
        return premiumCharge;
    }
     public double getPaidAmount(){
        return paidAmount;
    }
     public double getDiscountAmount(){
        return discountAmount;
    }
     public boolean getIsFullPayment(){
        return isFullPayment;
    }
     public String getPersonalTrainer(){
        return this.personalTrainer;
    }
    
    
    //method to keep track of attendance
     public void markAttendance()
    {
        if (super.activeStatus==true){ 
            super.attendance++;
             super.loyaltyPoints+=10;     
    }
    else{
        System.out.println("Membership not active");
    }
    
}

//method to check if the member has paid the full amount or not 
public String payDueAmount(double paidAmount){
    this.paidAmount += paidAmount;
    if (this.paidAmount==premiumCharge){
        isFullPayment=true;
         return "you have paid the full amount of: RS"+premiumCharge;
    }
    else if(this.paidAmount>premiumCharge){
        isFullPayment=true;
        double extraAmount=this.paidAmount-premiumCharge;
        return "you have paid RS" +extraAmount+" extra and will be returned to you shortly";
    }   
    else{
        isFullPayment=false;
            double remainingAmount=premiumCharge-this.paidAmount;
            return "your due amount is: RS" +remainingAmount;
            
        }
    
    }
    
    //method to give discount to the member who has paid full amount
    public String calculateDiscount(){
        if(isFullPayment){
            discountAmount=premiumCharge*0.10;
            return "Due to full payment you get RS"+discountAmount+" discount";
            
        }
        else{
            discountAmount=0;
         return "No discount applied you need to pay the full amount";
        }
       
         }
         
          public void revertPremiumMember(String removalReason) {
        super.resetMember();
        isFullPayment=false;
        personalTrainer="";
        paidAmount=0;
        discountAmount=0;
      
    }
      
    //displaying the values
   public void display() {
    super.display();
    System.out.println("Your personal trainer is: " + this.personalTrainer);
    System.out.println("You've paid: RS" + paidAmount);
    if (isFullPayment) {
        System.out.println("You have paid the full amount, and a discount of RS" + discountAmount + " has been applied.");
    }
    else {
        double remainingAmount = premiumCharge - this.paidAmount;
        
        if (paidAmount > premiumCharge) {
            double extraAmount = this.paidAmount - premiumCharge;
            System.out.println("You have paid an extra amount of RS" + extraAmount + " It will be returned to you shortly.");
        } else {
            System.out.println("You have a due amount of:RS" + remainingAmount + " Please pay it as soon as possible.");
        }
    }
}
}


