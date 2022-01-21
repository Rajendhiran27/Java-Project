import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Main {
	static Scanner sc =new Scanner(System.in);
	static Admin admin=new Admin();
	
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        
    }
   public static void main(String[] args) {
       System.out.println("Welcome to Amazon");
       System.out.println("*******************");
       System.out.println();
	   boolean end=false;
	    while(!end) {
	        System.out.println("1.Admin");
	        System.out.println("2.Merchant");
	        System.out.println("3.Exit");
	        System.out.println();
	        System.out.println("enter your choice");
	    	int a=sc.nextInt();
	    	switch(a) {
	    	case 1:
	    	    clearConsole();
	    	    System.out.println("Welcome Admin");
	    	    System.out.println("*****************");
	    	    System.out.println();
	    	    System.out.println("1.Pending Request");
	    	    System.out.println("2.Remove Merchant");
	    	    System.out.println("3.Exit");
	    	    System.out.println();
	    	    System.out.println("Enter your choise");
	    	    int b=sc.nextInt();
	    	    if(b==1){
	    	        clearConsole();
	    	       admin.display();
	    	       System.out.println();
	    	       System.out.println("Press 1 to accept the request");
	    	       System.out.println("press 2 to ignore the request");
	    	       admin.approvemerch();
	    	    }
	    	 break;
	     	case 2:
	    	    clearConsole();
	    	    System.out.println("Welcome Merchant");
	    	    System.out.println("******************");
	    	    System.out.println();
	    	    System.out.println("1.create an account");
	    	    System.out.println("2.already have an account");
	    	    System.out.println();
	    	    int d=sc.nextInt();
	    	    if(d==1){
	    	        clearConsole();
	    	        System.out.println("Creat your name and Password");
	    	        System.out.println();
	    	        System.out.println("Enter the Merchant Name");
	    	        String e=sc.next();
	    	        System.out.println("Enter the Merchant Password");
	    	        int f=sc.nextInt();
	    	     //   if(e.equals("raj") && f==1234){
	    	        System.out.println();
	    	        System.out.println("Enter the merchant details");
	    	        System.out.println();
    	    	    admin.addmerchent(addMer());
    	    	    System.out.println("Admin will processing your work");
    	    	    System.out.println();
    	    	    System.out.println("Stay tuned");
	    	     //   }
	    	    }
	    	    if(d==2){
	    	        clearConsole();
	    	        System.out.println("Welcome Merchent");
	    	        System.out.println("******************");
	    	        System.out.println();
	    	        System.out.println("Enter the Merchant Name");
	    	        String e=sc.next();
	    	        System.out.println("Enter the Merchant Password");
	    	        int f=sc.nextInt();
	    	        if(e.equals("raj") && f==1234){
	    	            System.out.println();
	    	            System.out.println("Welcome "+e);
	    	            admin.merchreq();
	    	            System.out.println();
	    	            
	    	        }
	    	    }
    	    	break;

	    	case 3:end=true;
	    	       break;

	    	}

	    }
   }
   public static Java addMer() {
	   System.out.println("Enter the Merchent_Name");
	   String Merch_name=sc.next();
	  // System.out.println();
	   System.out.println("Enter the Product");
	   String product=sc.next();
	   System.out.println("Enter the Price of the Single product");
	   int price=sc.nextInt();
	   System.out.println("Enter the Single product of the Offer");
	   int offer=sc.nextInt();
	    return new Java(Merch_name,product,price,offer);

   }
}
class Java{
   private String Merch_name;
   private String product;
   private int price;
   private int offer;
  public Java(String Merch_name,String product, int price,int offer) {
	this.Merch_name =Merch_name;
	this.product = product;
	this.price = price;
	this.offer = offer;
  }
    public  String getMerch_name() {
    	return Merch_name;
    }
    
    public void setName(String Merch_name) {
    	this.Merch_name = Merch_name;
    }
    
    public String getProduct() {
    	return product;
    }
    
    public void setProduct(String product) {
    	this.product = product;
    }
    
    public int getPrice() {
    	return price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }
    
    public int getOffer() {
    	return offer;
    }
    
    public void setOffer(int offer) {
    	this.offer =offer;
    }
}
class Admin {
    static final Scanner sc=new Scanner(System.in);
	ArrayList<Java>li=new ArrayList<Java>();
    boolean add=true;
    boolean ignore=false;
     int m=1,n=0;
	public void addmerchent(Java java) {

		  if(li.size()<2) {
			li.add(java);
		  }
	} 
	public void display() {
		  for(Java java:li) {
			  System.out.println("Merch_Name:"+java.getMerch_name()+" , "+"Product:"+java.getProduct()+" , "+"Price:"+java.getPrice()+" , "+"Offer:"+java.getOffer()+"%");
		  }

	}
	public boolean removemerch(){
	    for(Java java:li){
	    li.remove(java);
	    return true;
	    }
	    return false;
	}
	public boolean approvemerch(){
	  //  int c=1;
	    for(Java java:li){
	       System.out.println("press 1 to contine");
	       System.out.println("press 2 to exit");
	        int f=sc.nextInt();
	        if(f==1){

	            System.out.println();
	            System.out.println("Merchent added successfully");
	           
	           return true;
	        }
	        else{
	            System.out.println("your request was removed by admin");
	        }
	    }
	    return false;
	}
	public void merchreq(){
	   if(approvemerch()==true){ 
	       System.out.println("Welcome Merchant");
	       System.out.println("*****************");
	       System.out.println("1.view product");
	       System.out.println("2.exit");
	       int g=sc.nextInt();
	       if(g==1){
	           display();
	       }
	       else if(g==2){
	           System.out.println("Exited Successfully");
	       }
	   }
	   else if(approvemerch()==false){
	       System.out.println("Account not found");
	   }
	}
}
