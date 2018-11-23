import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {

    public static void main (String[] args) {

        // parameters recives from command line
        final int customerServiceDepartment = 3;
        final int ResolversDepartment = 2;
        final int complaints = 5;

        // creates complaints
        Queue<Complaint> complaintsQueue = new LinkedList<>();
        for (int i = 0; i < complaints; i++) {
            ((LinkedList<Complaint>) complaintsQueue).push(new Complaint("0509667566", "Yael", "ex1"));
        }

        // creates a thread pool with customer service department size of threads as the fixed pool size (step 2)
        ExecutorService pool = Executors.newFixedThreadPool(customerServiceDepartment);

        // passes the Task objects to the pool to execute (Step 3)
        for (int i = 0; i < complaints; i++) {
            pool.execute(((LinkedList<Complaint>) complaintsQueue).pop());
        }

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
