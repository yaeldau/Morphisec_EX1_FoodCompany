import java.text.SimpleDateFormat;
import java.util.Date;

public class ResolveComplaint implements Runnable {

    private Complaint complaint;

    public ResolveComplaint(Complaint complaint){
        this.complaint = complaint;
    }

    @Override
    public void run() {
        // resolving...
        System.out.println(complaint.msgPrefix() + "resolving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // done resolving the complaint

        complaint.resolved();

        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(complaint.msgPrefix() + "resolved time: " + ft.format(d));

    }
}
