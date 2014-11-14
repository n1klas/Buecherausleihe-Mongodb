
import com.mongodb.*;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        DB db = null;
        try {
            MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017));
            db = mongoClient.getDB("mydb");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Vorname ...");

        Scanner s = new Scanner(System.in);
        String firstname = s.next();

        System.out.println("Nachname ...");
        String lastname = s.next();

        DBCollection customerColl = db.getCollection("kunden");
        BasicDBObject customer = new BasicDBObject("firstname", firstname).append("lastname", lastname);
        DBCursor customerCursor = customerColl.find(customer);
        DBObject customerObj = null;
        if(customerCursor.hasNext()) {
            customerObj = customerCursor.next();
        } else {
            customerColl.insert(customer);
            customerObj = customer;
        }

        DBCollection bookColl = db.getCollection("bücher");
        DBCursor bookCursor = bookColl.find();

        System.out.println("\nBücher:");

        while(bookCursor.hasNext()) {
            DBObject book = bookCursor.next();
            System.out.println(book.get("title"));
        }

        DBCollection rentColl = db.getCollection("ausleihe");
        BasicDBObject findObj = new BasicDBObject("customerId", customerObj.get("_id"));
        DBCursor rentedBooksCursor = rentColl.find(findObj);

        if(rentedBooksCursor.hasNext()) {
            System.out.println("\nAusgeliehene Bücher:");

            while (bookCursor.hasNext()) {
                
            }
        }

        System.out.println("Welches?");

        String title = s.next();
        BasicDBObject choosenBook = new BasicDBObject("title", title);
        bookCursor = bookColl.find(choosenBook);

        if(bookCursor.hasNext()) {
            DBObject book = bookCursor.next();
            BasicDBObject rentObj = new BasicDBObject("bookId", book.get("_id"))
                                            .append("customerId", customerObj.get("_id"))
                                            .append("date", new Date())
                                            .append("rückgabeDatum", false);
            rentColl.insert(rentObj);
            System.out.println("Buch " + title + " ausgeliehen!");
        } else {
            System.out.println("NEIN!");
        }
    }
}
