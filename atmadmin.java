import java.util.*;
import java.io.*;
class Main{
    public static final Scanner sc=new Scanner(System.in);
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
        
    }
    static int State = 1;
    static Main[] atm;
    static int Current_User = 0;
    public String username,userpin;
    public int userbalance=0;
    public ArrayList<String> User_Statement;
    Main(String username,String userpin,int userbalance){
        this.username=username;
        this.userpin=userpin;
        this.userbalance=userbalance;
    }
    static int curr_2000=10;
    static int curr_500=10;
    static int curr_200=10;
    static int curr_100=10;

    public static int withdraw1(int withdraw,int usrbalance){
        int cuty_2000=curr_2000;
        int cuty_500=curr_500;
        int cuty_200=curr_200;
        int cuty_100=curr_100;

        int car_2000=0;
        int car_500=0;
        int car_200=0;
        int car_100=0;
        if(withdraw<usrbalance){
        while(withdraw>0){
            if(curr_2000>0 && withdraw>=2000){
                withdraw-=2000;
                curr_2000-=1;
                car_2000+=1;
            }
            else if(curr_500>0 && withdraw>=500){
                withdraw-=500;
                curr_500-=1;
                car_500+=1;
            }
            else if(curr_200>0 && withdraw>=200){
                withdraw-=200;
                curr_200-=1;
                car_200+=1;
            }
            else if(curr_100>0 && withdraw>=100){
                withdraw-=100;
                curr_100-=1;
                car_100+=1;
            }          
            else{
                System.out.print("Insuffient");
                curr_2000=cuty_2000;
                curr_500=cuty_500;
                curr_200=cuty_200;
                curr_100=cuty_100;
                car_2000=0;car_500=0;car_200=0;car_100=0;
                break;
            }
        }
        System.out.println("\n****Amount debited****\n2000 rs notes : "+car_2000+"\n500 rs notes : "+car_500+"\n200 rs notes : "+car_200+"\n100 rs notes : "+car_100);
        }
        int usrbal=((2000*curr_2000)+(500*curr_500)+(200*curr_200)+(100*curr_100));
        return usrbal;
    }
    public static int balance1(int n1,int n2,int n3,int n4){
        int curr_2000=0;
        int curr_500=0;
        int curr_200=0;
        int curr_100=0;
        curr_2000=curr_2000+n1;
        curr_500=curr_500+n2;
        curr_200=curr_200+n3;
        curr_100=curr_100+n4;
        int balance=(curr_2000*2000)+(curr_500*500)+(curr_200*200)+(curr_100*100);
        return balance;
    }
    public static boolean adminpass(){
        Boolean b=true;
        for(int x=1;x<=3;x++){
            int a=1;
            System.out.println();  
            System.out.println("******WELCOME******");
            System.out.println();
            System.out.println("Enter your Admin_name : ");     
            String name=sc.nextLine();
            System.out.println("Enter password : ");     
            String password=sc.nextLine();
            if(name.equals("Raj") && password.equals("4321") && a<=3){
                System.out.println("Welcome "+name);
                System.out.println("**********");
                b=true;
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid name and password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("Now You Have 2 Attembts Only");
                }
                else if(x==2){
                    System.out.println("Now You Have 1 Attembt Only");
                }
                else if(x==3){
                    System.out.println("Attempts over!!!!!");
                    break;
                }
            }
        }
        return b;
    }
    public static int userpass(int p1){
        Boolean b=true;
        int currentuser=-1;
        for(int x=1;x<=3;x++){
            int a=1;
            System.out.println();  
            System.out.println("******WELCOME******");
            System.out.println();
            System.out.print("Enter your Username : ");     
            String name=sc.nextLine();
            System.out.print("Enter pin number : ");     
            String password=sc.nextLine();
            if (atm[p1].username.equals(name) && atm[p1].userpin.equals(password)){
                currentuser = p1;                    
                b=true;
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid name and password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("Now you Have 2 Attembts Only");
                }
                else if(x==2){
                    System.out.println("Now you Have 1 Attembt only");
                }
                else if(x==3){
                    System.out.println("Session Expired");
                    break;
                }
            }
        }
        return currentuser;
    }
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int balance=balance1(10,10,10,10);
    int withdraw;
    clearConsole();
    System.out.println("Welcome to ATM");
    if (State == 1) {
        atm = new Main[1];
        atm[0] = new Main("raj", "1234", 5000);
        atm[0].User_Statement = new ArrayList<>();
    }
    while(true){
        System.out.println("*****WELCOME*****");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        System.out.println();
        int n=sc.nextInt();
        switch(n){
            case 1:
            clearConsole();
            if(adminpass()){
            System.out.println("1.Cash deposit");
            System.out.println("2.Check balance");
            System.out.println("3.Logout Admin");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter amount to deposit : ");
                System.out.println();
                System.out.println("Enter 2000 rupee notes : ");
                int z1=sc.nextInt();
                System.out.println("Enter 500 rupee notes : ");  
                int z2=sc.nextInt();     
                System.out.println("Enter 200 rupee notes : ");  
                int z3=sc.nextInt();     
                System.out.println("Enter 100 rupee notes : ");  
                int z4=sc.nextInt();  
                System.out.println();
                balance+=balance1(z1,z2,z3,z4);
                curr_2000+=z1;
                curr_500+=z2;
                curr_200+=z3;
                curr_100+=z4;
                System.out.print("Rs : ");
                System.out.print(balance);
                System.out.println();
                System.out.println("Your money Deposited Successfully...");
            }
            else if(m==2){
                System.out.println("Currect ATM balance : Rs"+balance+"-/");
            }
            else if(m==3){
                clearConsole();
                System.out.println("Logut Successfull!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                break;           
            }
            else{
                System.out.println("Ivalid Input");
            }
            }  
            break;
            case 2:
            clearConsole();
            int p1=0;
            int c=-1;
            boolean b=false;
            int cur=userpass(p1);
            if(cur==0){
                c=0;
                b=true;
            }
            else if(cur==1){
                c=1;
                b=true;
            }
            else if(cur==2){
                c=2;
                b=true;
            }
            if(b==true){
            System.out.println();
            System.out.println("Welcome User");
            System.out.println();
            System.out.println("1.Withdraw Amount");
            System.out.println("2.Check account balance");
            System.out.println("3.Mini Statement");
            System.out.println("4.Exit");
            int o=sc.nextInt();
            if(o==1){
                System.out.print("Enter amount to withdraw : ");
                withdraw=sc.nextInt();
                if(balance>=withdraw && withdraw>0 && atm[c].userbalance>=withdraw && withdraw%100==0){
                    withdraw1(withdraw,atm[c].userbalance);
                    balance=balance-withdraw;
                    atm[c].userbalance=atm[c].userbalance-withdraw;
                    System.out.println("Please collect your cash");
                    String date = java.time.LocalDateTime.now() + "\nWithdrawn Amount -" +withdraw+"\nYour account balance - "+atm[c].userbalance+"\n";
                    atm[c].User_Statement.add(date);    
                }
                else if(balance<withdraw){
                    System.out.println("Insufficient balance");
                    System.out.println("Available amount at ATM - Rs : "+balance+"-/");
                }
                else{
                    System.out.println("Invalid Amount...");
                    System.out.println("Your Account balance - Rs : "+atm[c].userbalance+"-/");                   
                }
            }
            else if(o==2){
                System.out.println("Rs : "+atm[c].userbalance+"-/");
                
            }
            else if(o==3){
                System.out.println("Mini Statement !");
                for (int k = 0; k < atm[c].User_Statement.size(); k++) {
                    System.out.println(atm[c].User_Statement.get(k));
                }
                break;
            }
            else if(o==4){
                clearConsole();
                System.out.println("Exit Successfully!!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                break;
            }
            else{
                System.out.println("Invalid Input");
                System.out.println("Please check the input and try again...");
            }
            }
            break;
            case 3:
                clearConsole();
                System.out.println("Exit Successfully!!!");
                System.out.println();
                System.out.println("Thank you for using ATM");
                System.out.println("****************");
                System.exit(0);
                break;
        }
    }
}
}