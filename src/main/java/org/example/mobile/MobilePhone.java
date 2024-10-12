package org.example.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }





    public boolean addNewContact(Contact contact){
        if(!this.myContacts.contains(contact)){
            myContacts.add(contact);
            return true;
        }

        return false;

    }
    public boolean updateContact(Contact prevContact, Contact nextContact){
        for(int i = 0 ; i< myContacts.size(); i++){
            if(myContacts.get(i).equals(prevContact)) {
                myContacts.set(i, nextContact);
                return true;
            }
        }
        return false;
    }
    public boolean removeContact(Contact contact) {
        for(Contact obj : myContacts){
            if(obj.equals(contact)){
                myContacts.remove(contact);
                return true;
            }
        }

        return false;
    }
    public int findContact(Contact contact) {
        if(!myContacts.contains(contact)) {
            return -1;
        }
        return myContacts.indexOf(contact);
    }

    public int findContact(String contact) {
        for(Contact cont : myContacts){
            if(cont.getName().equals(contact)){
                return myContacts.indexOf(cont);
            }
        }
        return -1;

    }
    public Contact queryContact(String contact){

        for(Contact cont : myContacts){
            if(cont.getName().equals(contact)){
                return cont;
            }
        }
        return null;
    }

    public void printContact(){
        for(int i = 0; i<myContacts.size(); i++){
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}
