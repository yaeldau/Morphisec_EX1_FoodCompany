import java.util.concurrent.atomic.AtomicInteger;

public class Complaint {

    static private AtomicInteger ids = new AtomicInteger(0);

    private int id;
    private String contactPhone;
    private String contactName;
    private String description;
    private Boolean isResolved;


    public Complaint(String contactPhone, String contactName, String description){
        id = ids.getAndIncrement();
        this.contactPhone = contactPhone;
        this.contactName = contactName;
        this.description = description;
        this.isResolved = false;
    }

    public int getId (){
        return id;
    }

    public void resolve (){
        isResolved = true;
    }

    public String toString(){
        return "** \n"
                + "Complaint id: \t" + id + "\n"
                + "contact name: \t" + contactName + "\n"
                + "contact phone: \t" + contactPhone + "\n"
                + "description: \t" + description + "\n"
                + "is resolved: \t" + isResolved + "\n"
                + "**";
    }

    public String msgPrefix (){
        return "complaint id-" + id + ": " ;
    }
}
