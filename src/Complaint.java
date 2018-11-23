import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint implements Runnable {

    static private int ids = 0;

    private int id;
    private String contactPhone;
    private String contactName;
    private String description;
    private Boolean isResolved;

    public Complaint (String contactPhone, String contactName, String description){
        id = ids++;
        this.contactPhone = contactPhone;
        this.contactName = contactName;
        this.description = description;
        this.isResolved = false;
    }

    @Override
    public void run() {
        for (int i=0; i<5 ; i++) {
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
            System.out.println("complaint id-" + id + " creation time" + ft.format(d));

            // customer service call...
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // call ended
        }
        System.out.println("call ended");
    }
}
