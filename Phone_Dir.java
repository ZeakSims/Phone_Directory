package Main;
import java.util.*;

import Main. Contact_List;

/*Zeak Sims
MW@11-12:15*/

/*This is the main class where all my methods are implemented and my my main 
method runs the code*/
public class Phone_Dir {
	
	//declaring a new linked list that uses the objects from declared in contact list
		static LinkedList<Contact_List> PhoneBook = new LinkedList<Contact_List>();
		//declaring a scanner for user inputs
		private static Scanner userInputs = new Scanner(System.in);
		//
		private static int currentEntry = 0;
		//a java import to add graphics to output text
		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_WHITE = "\u001B[37m";
		public static final String ANSI_RESET = "\u001B[0m";
		
		//displays the main menu that has 
		public static void displayMainMenu() {
			
			System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE +"\t\tMAIN MENU\t\t"+ANSI_RESET);
			System.out.println("\r\n\t" + "  a     Show all records\r\n" + 
					"\r\n" + 
					"          d     Delete the current record\r\n" + 
					"\r\n" + 
					"          f     Change the first name in the current record\r\n" + 
					"\r\n" + 
					"          l     Change the last name in the current record\r\n" + 
					"\r\n" + 
					"          n    Add a new record\r\n" + 
					"\r\n" + 
					"          p    Change the phone number in the current record\r\n" + 
					"\r\n" + 
					"          q     Quit\r\n" + 
					"\r\n" + 
					"          s     Select a record from the record list to become the current record ");
			System.out.println("\nEnter a command from the list above (q to quit):");
		}
		
		//template for the record display
		public static void recordTemplate() {
		
			System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + 
					"First Name\tLast Name\tPhone Number" 
					+ ANSI_RESET);
			System.out.println("--------------------------------------------");
		}
		
		
		public static void createRecords(Contact_List data) {
			
			String currentPerson = data.getFirstName() + " " + data.getLastName() + " " + data.getPhoneNumber();

		      if (PhoneBook.size() == 0) {
		          
		    	  currentEntry = 0;
		      }
		      
		      else {
		    	  
		    	  for (int i = 0; i < PhoneBook.size(); i++) {
			          
		    		  String compareToPerson = PhoneBook.get(i).getLastName() + " " +
			                  				   PhoneBook.get(i).getFirstName() + " " +
			                  				   PhoneBook.get(i).getPhoneNumber();
			      
			          if (currentPerson.toLowerCase().compareTo( compareToPerson.toLowerCase() ) < 0) {
			              
			        	  currentEntry = i;
			              return;
			          } 
			          
			          else {
			             
			        	  currentEntry = i+1;
			          }
			      }  
		      }
		      
		}
		
		//method to display all the contacts in your record
		public static void displayAllRecords() {
			
			//won't return any records if the list is empty
			if(PhoneBook.isEmpty() == true) {

		          System.out.println("No records currently exist in this pnoe book.");
			}
			
			//if list has any thing in it, it will give your list
			else {
				
				recordTemplate();
				//prints the list and runs for the length of the phonebook
				for (Contact_List list: PhoneBook) {
			        
					//prints first, last, and phone number
					System.out.print(list.getFirstName());
			          
			          for (int i = list.getFirstName().length(); i < 16; i++) {
			              
			        	  System.out.print(" ");
			          }

			          System.out.print(list.getLastName());
			          
			          for (int i = list.getLastName().length(); i < 16; i++) {
			              
			        	  System.out.print(" ");
			          }

			          System.out.print(list.getPhoneNumber());
			          System.out.println();
			          System.out.println();
			      }
			 }
		}
		
		//prints the current record
		private static void currentRecord() {
		      
			System.out.println("Current record: " + PhoneBook.get(currentEntry).getFirstName() + " " 
		              							  + PhoneBook.get(currentEntry).getLastName() + " " 
		              							  + PhoneBook.get(currentEntry).getPhoneNumber());
		  }
		
		//deletes the current record
		public static void deleteCurrentRecord() {
			//only deletes if there is anything in the list
			if (PhoneBook.isEmpty() == true) {
		          
					System.out.println("There are no contacts to delete");
		    }
			
			else {
				
					currentRecord();
					System.out.print("has been deleted");
					System.out.println();
					System.out.println();
					//removes the record from the list
					PhoneBook.remove(currentEntry);
					currentEntry = -1;
			}
		}
		
		//changes the first name
		public static void changeFirstNameCurrent() {
			
			if (PhoneBook.isEmpty() == true) {
		          
				System.out.println("There are no contacts");
	     	}
		
			else {
				
				System.out.println("Enter new first name ");
			    String fn = userInputs.next();
			    Contact_List current = PhoneBook.get(currentEntry);
			    //removes the current first name
			    PhoneBook.remove(currentEntry);
			    //sets the new name and places it in the place of the old name
			    current.setFirstName(fn);
			    createRecords(current);
			    PhoneBook.add(currentEntry, current);
			    currentRecord();
			    System.out.println();
			}
		}
		//changes the last name 
		public static void changeLastNameCurrent() {
			
			if (PhoneBook.isEmpty() == true){
		          
				System.out.println("There are no contacts");
			}
		
			else {
			      
				System.out.print("Enter new last name ");
			    String ln = userInputs.next();
			    Contact_List current = PhoneBook.get(currentEntry);
			    //removes the current last name
			    PhoneBook.remove(currentEntry);
			    //sets the new name and places it in the place of the old name
			    current.setLastName(ln);
			    createRecords(current);
			    PhoneBook.add(currentEntry, current);
			    currentRecord();
			    System.out.println();
			}
		}
		
		//adds record into the list
		public static void addNewRecord() {
			//where you type in your name
			System.out.println("What is the first name?");
			String fn = userInputs.next();
			String s1 = fn.substring(0, 1).toUpperCase();
		    fn = s1 + fn.substring(1);
			System.out.println("What is the last name?");
			String ln = userInputs.next();
			s1 = ln.substring(0,1).toUpperCase();
		    ln = s1 + ln.substring(1);
			System.out.println("What is the phone number?");
			String pn = userInputs.next();
			
			//contactInfo holds all the objects for one element of the list
			Contact_List contactInfo = new Contact_List(fn, ln, pn);
			//passes all the objects in createRecords so it can add it to the list
			createRecords(contactInfo);
			//adds the contact as the last entry
	        PhoneBook.add(currentEntry, contactInfo);
		
			System.out.println("Current Record:\t" + fn+" "+ln+" "+pn);
			System.out.println();
		}
		
		//replaces the phone number
		public static void changeNumberCurrent() {
			
			if (PhoneBook.size() == 0){
		          
				System.out.println("There are no contacts");
			}
		
			else {
				//removes then replace
				System.out.print("Enter new number ");
			    String pn = userInputs.next();
			    Contact_List current = PhoneBook.get(currentEntry);
			    PhoneBook.remove(currentEntry);
			    current.setLastName(pn);
			    createRecords(current);
			    PhoneBook.add(currentEntry, current);
			    currentRecord();
			    System.out.println();
			}
		}
		
		//finds specific contact
		public static void selectSpecificRecord() {
			
			if (PhoneBook.size() == 0) {
		          
				System.out.println("No current record. You must add at least one record.");
		        return;
		      }
			
			else { 
		      
			  //uses the first name and last name to find the contact
			  System.out.print("Enter the first name ");
		      String first = userInputs.next();
		      String s1 = first.substring(0, 1).toUpperCase();
		      first = s1 + first.substring(1);

		      System.out.print("Enter the last name ");
		      String last = userInputs.next();
		      s1 = last.substring(0,1).toUpperCase();
		      last = s1 + last.substring(1);
		      String data=getDetails(first, last);
		     
		      System.out.println(data);
			}
		 }
		
		//runs through the list to find the contact
		private static  String getDetails(String fname, String lname) {
				
			  //runs through the phone book and compares to the first and last names enter to find the contact
		      for (int i = 0; i < PhoneBook.size(); i++) {
		         
		          if(fname.equals(PhoneBook.get(i).getFirstName()) && lname.equals(PhoneBook.get(i).getLastName())) {
		          
		        	  currentEntry = i;
		          return "Current record is: " +PhoneBook.get(i).getFirstName()+" "+ PhoneBook.get(i).getLastName()+" "+ PhoneBook.get(i).getPhoneNumber();           
		          }
		         
		      }
		      return "No matching record found.";
		  }
		
		//main method to run everything
		public static void main (String[]args) {
			
			displayMainMenu();
			
			//will keep prompting you with the main menu until you quit the program
	        while(userInputs.hasNext()) {
	        	
	        	try {
	        		
	        		String mainMenuInput = userInputs.next();
	        		char mainMenuCommands = mainMenuInput.charAt(0);
	        		
	        		//switch case is used to read in inputs of the user and runs that specific method to 
	        		switch (mainMenuCommands) {
	            
	        			case 'a': displayAllRecords();
	        						break;
	        			case 'd': deleteCurrentRecord();
	        						break;
	        			case 'f': changeFirstNameCurrent();
	        						break;
	        			case 'l': changeLastNameCurrent();
	                     			break;
	        			case 'n': addNewRecord();
	                     			break;
	        			case 'p': changeNumberCurrent();
	        						break;
	        			case 'q': System.exit(-1);
	        					  System.out.println("Phone Book has been closed");
	                     			break;
	        			case 's': selectSpecificRecord();
	                     			break;
	            
	            default:  System.out.println("Invalid command");
	                     break;
	        		}
	            		}
	            
	        	catch(InputMismatchException e){
	                
	        		System.out.println("Illegal command");
	            }
	        	
	            finally{
	            	
	            	displayMainMenu();
	            }
	        }
		}

}
