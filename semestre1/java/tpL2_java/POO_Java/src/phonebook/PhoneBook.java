package phonebook ;
import java.util.ArrayList;

public class PhoneBook {
   protected ArrayList<Contact> listContact ;
   public PhoneBook(){
    this.listContact = new ArrayList<>() ;
   }
   public void addContact(String nom ,String number){
    Contact nouveau = new Contact(nom, number) ;
    listContact.add(nouveau);
   }

   public ArrayList<String> getPhoneNumbers(String number ){
        ArrayList<String> names = new ArrayList<>() ;
        for(Contact c : listContact){
            if(c.getNumber()==number){
                names.add(c.getName());
            }
        }
        return names ;
   }
}
