package src.message;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Message {
    String text;
    String from;
    String to;
    GregorianCalendar date = new GregorianCalendar();
    
    public Message(String from, String to, String text) {
        this.text = text;
        this.from = from;
        this.to = to;
    }

    public Message(String message) {
        String[] lines = message.split("[|]");
        from = lines[1];
        to = lines[3];
        String[] tempDate = lines[5].split("[.]");
        int day = Integer.parseInt(tempDate[0]);
        int month = Integer.parseInt(tempDate[1]);
        int year = Integer.parseInt(tempDate[2]);
        date = new GregorianCalendar(year, month, day);
        text = lines[7];
    }

    public String getText() { return text; }
    
    public String getNameTo() { return to; }
    
    public String getNameFrom() { return from; }
    
    public void showMessage() {
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);

        System.out.println("Date:" + day + "." + month + "." + year);
        System.out.println("From: " + from + "\nText:\n" + text);
    }
    public String toString() {
        StringBuilder temp = new StringBuilder();

        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        
        temp.append("From:|" + from + "|To:|" + to + "|");
        temp.append("Date:|" + day + "." + month + "." + year + "|");
        temp.append("Message:|" + text);
        return temp.toString();
    }
}
