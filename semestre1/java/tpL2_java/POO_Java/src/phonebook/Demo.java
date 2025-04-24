package phonebook ;
public class Demo {
    public static void main(String[] args) {
        PhoneBook reper = new PhoneBook() ;
        reper.addContact("Martin","1234") ;
        reper.addContact("Jean","1234") ;
        reper.addContact("Martine","1234") ;
        reper.addContact("jeanne","4321") ;
        reper.addContact("Martin","4321") ;
        for(String name : reper.getPhoneNumbers("1234")){
            System.out.println(name);
        }


    }
}
