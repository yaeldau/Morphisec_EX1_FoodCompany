import java.text.SimpleDateFormat;
import java.util.Date;

public class saveComplaint implements Runnable {

    private Complaint complaint;

    public saveComplaint(Complaint complaint){
        this.complaint = complaint;
    }

    @Override
    public void run() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(complaint.msgPrefix() + "creation time " + ft.format(d));

        // customer service call...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Manager.saveComplaint(this.complaint);

        // call ended
        System.out.println(complaint.msgPrefix() + "call ended");
    }
}
