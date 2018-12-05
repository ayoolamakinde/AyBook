package com.example.makinde.aybook;

import java.util.ArrayList;

public class Contact {


    String First_Name;
    String Last_Name;
    String Email;
    String Phn_Number;
    boolean IsAvailable;

    public Contact() {

    }

    public Contact(String first_Name, String last_Name, String email, String phn_Number) {
        this.First_Name = first_Name;
        this.Last_Name = last_Name;
        this.Email = email;
        this.Phn_Number = phn_Number;
    }


}
