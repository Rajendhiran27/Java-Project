import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	static Scanner scanner =new Scanner(System.in);
	static Train train=new Train();
   public static void main(String[] args) {

	   System.out.println("enter your choice");
	   boolean end=false;

	    while(!end) {
	    	int choice=scanner.nextInt();
	    	switch(choice) {
	    	case 1:
	    		   train.bookTicket(generateTicket());	
	    		  break;

	    	case 2: train.cancelTicket(generateTicket());
	    	        break;

	    	case 3:train.displayAllTickets();
	    	       break;

	    	case 4:end=true;
	    	       break;

	    	}

	    }
   }
//   public static void display() {
//	   train.displayTicket();
//   }




   public static Ticket generateTicket() {
	   System.out.println("name");
	   String name=scanner.next();
	   System.out.println("age");
	   int age=scanner.nextInt();
	   System.out.println("gender");
	   String gender=scanner.next();
	   System.out.println("birth preference");
	   String berthpref=scanner.next();
	    return new Ticket(name,age,gender,berthpref);

   }
}
class Berth {
		private int LB=21;
		private int MB=21;
		private int UB=21;


    public void allocateBerth(Ticket ticket) {
    	 if(LB!=0 && ticket.getBirthPreference().equals("LB")) {
    		 LB--;
    		 ticket.setConfirmationStatus("booked LB");
    	 }
    	 else if(MB!=0 && ticket.getBirthPreference().equals("MB")) {
    		 MB--;
    		 ticket.setConfirmationStatus("booked MB");
    	 }
    	else if(UB!=0 && ticket.getBirthPreference().equals("UB")){
    		   UB--;
    		  ticket.setConfirmationStatus("booked UB");
        } 

    	else {
			if(LB!=0) {
				 ticket.setConfirmationStatus("booked LB");
			}
			else if(MB!=0)
			{
				 ticket.setConfirmationStatus("booked MB");
			}
			else {
				 ticket.setConfirmationStatus("booked UB");
			}
		}
    }
}
class Ticket {
   private String name;
   private int age;
   private String gender;
   private String birthPreference;
   private String confirmationStatus;
  public Ticket(String name, int age, String gender, String birthPreference) {
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.birthPreference = birthPreference;
  }
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public String getGender() {
    	return gender;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public String getBirthPreference() {
    	return birthPreference;
    }
    
    public void setBirthPreference(String birthPreference) {
    	this.birthPreference = birthPreference;
    }
    
    public String getConfirmationStatus() {
    	return confirmationStatus;
    }
    
    public void setConfirmationStatus(String confirmationStatus) {
    	this.confirmationStatus = confirmationStatus;
    }
}
class Train {

	ArrayList<Ticket> confirmedTickets=new ArrayList<Ticket>();
	ArrayList<Ticket> racTickets=new ArrayList<Ticket>();
	ArrayList<Ticket> waitingListTickets=new ArrayList<Ticket>();
	Berth berth =new Berth();



	public void bookTicket(Ticket ticket) {

		  if(confirmedTickets.size()<2) {
			  berth.allocateBerth(ticket);
			confirmedTickets.add(ticket);
		  }
		  else if(racTickets.size()<1) {
			  ticket.setConfirmationStatus("In RAC");
			  racTickets.add(ticket);
		  }
		  else if(waitingListTickets.size()<1){
			  ticket.setConfirmationStatus("In Waiting list");
			  waitingListTickets.add(ticket);
		  }
		  else {
			System.out.println("No Tickets Available");
			return;
		}

		  displayTicket(ticket);
	  } 




	  public void cancelTicket(Ticket ticket) {

	   	 if(removeTicket(ticket,confirmedTickets))
	   	 {
	   		 confirmedTickets.add(confirmedTickets.size(),racTickets.get(0));
	   		 racTickets.remove(0);
	   		  if(!waitingListTickets.isEmpty())
	   		  {
			  racTickets.add(racTickets.size(),waitingListTickets.get(0));
			  waitingListTickets.remove(0);
	   		  }
	   	 }else if(removeTicket(ticket,waitingListTickets)) {
	   		 return;
	   	 }
	   	 else if(removeTicket(ticket,racTickets)) {
	   		 if(!waitingListTickets.isEmpty()) {
	   		racTickets.add(racTickets.size()-1,waitingListTickets.get(0));
			  waitingListTickets.remove(0);
	   		 }
	   	 }
		else {
				System.out.println("your search does not match");
				return;
			}



	  }

	  private boolean removeTicket(Ticket ticket,ArrayList<Ticket> ticketBookings ) {
		  for(Ticket tickets:ticketBookings) {
	           if(tickets.getName().equals(ticket.getName()) && tickets.getAge()==ticket.getAge()) {
	        	   racTickets.get(0).setConfirmationStatus(tickets.getConfirmationStatus());
	        	   confirmedTickets.remove(tickets);

	        	   return true;
	           }  		  
	   	  }
		  return false;
	  }



	  private ArrayList<Ticket> findTicketStatus(Ticket ticket) {
		  if(confirmedTickets.contains(ticket))
			  return confirmedTickets;
		  else if(racTickets.contains(ticket))
			  return racTickets;
		  else {
			return waitingListTickets;
		}
	  }

	  public void displayTicket(Ticket ticket) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
		  }



	  public void displayAllTickets() {
		  for(Ticket ticket:confirmedTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
		  }
		  for(Ticket ticket:racTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
			  }
		  for(Ticket ticket:waitingListTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
			  }
	  }
	  }
