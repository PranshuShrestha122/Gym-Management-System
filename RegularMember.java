


public class RegularMember extends GymMember{
    //attributes
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //accessormethod
    public RegularMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate){
             super(id,name,location,phone,email,gender,DOB,membershipStartDate);
             this.attendanceLimit=30;
             this.isEligibleForUpgrade=false; 
             this.plan="basic";
             this.price=6500;
             this.removalReason="";
             this.referralSource="";
             
             
    }
    
    //accessor methods
    public int getAttendanceLimit(){
        return attendanceLimit;
        
    }
    public boolean getIsEligibleForUpgrade(){
        return isEligibleForUpgrade;
        
    }
    public String getRemovalReason(){
        return removalReason;
    }
    public String getPlan(){
        return plan;
    }
    public double getPrice(){
        return price;
    }
    public String getReferralSource(){
        return referralSource;
    }
    
    //track the attendance of the members
    public void markAttendance()
    {
        if (super.activeStatus==true){ 
            super.attendance++;
             super.loyaltyPoints+=5;
             if(super.attendance>=attendanceLimit){
                 
                 isEligibleForUpgrade=true;
                 System.out.println("you are eligible for an upgrade");
             }
        }
        else{
            System.out.println("you have not yet subscribed to the membership");
        }
       
       
    }
    
    //see the plan and its price
    public double getPlanPrice(String plan){
         switch (plan.toLowerCase()){
         case "basic":
            return 6500;
            
             case "standard":
                 return 12500;
                
                  case "deluxe":
                     return 18500;
                
                  default:
                      System.out.print("invalid plan!");
                      return -1;
                    }       
     } 
     
         //method to let the user upgrade the plan
          public String upgradePlan(String plan){
              if (!isEligibleForUpgrade){
                  return"not eligible for upgrade";
              }
              if (this.plan.equals(plan)){
                  return"you have already subscribe to this plan";
              }
              double newPrice=getPlanPrice(plan);
              if (newPrice== -1){
                return"Invalid plan selected";
                  
              }
              this.plan=plan;
              this.price=newPrice;
              return "you've successfully upgraded to " +this.plan +"plan";
          
          }
          
          //reset the mbembers data
          public void revertRegularMember(String removalReason){
            super.resetMember();
            this.isEligibleForUpgrade=false;
            this.plan="basic";
            this.price=6500;
            this.removalReason=removalReason;
            
            }
            
            //display the required info
         public void display(){
             super.display();
         System.out.println("The plan is: " +plan);
         System.out.println("The price is: " +price);
           if(!removalReason.isEmpty()){
                 System.out.println("Removal Reason: " +removalReason);
              }
    
            }

     }
    
    
    
