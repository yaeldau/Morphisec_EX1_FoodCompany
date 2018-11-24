
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Manager {

    private static ExecutorService resolversPool;
    private static int complaintsRemainToResolve;

    public static void main (String[] args) {

        // parameters recives from command line
        if (args.length < 3 || !(Util.isValidInteger(args[0]) && Util.isValidInteger(args[1]) && Util.isValidInteger(args[2]))){
            System.out.println("The arguments should be: \n"
            + "1. Number of people in customer service department \n"
            + "2. Number of people in Resolvers department \n"
            + "3. Number of complaints that will enter to the customer service department. \n"
            + "Please re-run the program with correct arguments.");

            System.exit(1);
            return;
        }
        final int customerServiceDepartmentSize = Integer.parseInt(args[0]);
        final int ResolversDepartmentSize = Integer.parseInt(args[1]);
        final int complaintsNo = Integer.parseInt(args[2]);
        complaintsRemainToResolve = complaintsNo;

        // generate the customers complaints automatically
        Queue<saveComplaint> complaintsQueue = new LinkedList<>();
        for (int i = 0; i < complaintsNo; i++) {
            String phone = Util.generatePhone();
            String name = Util.generateName();
            String description = Util.generateDescription();
            Complaint complaint = new Complaint(phone, name, description);
            complaintsQueue.add(new saveComplaint(complaint));
        }

        // initialize pools:

        // creates a thread pool.
        // each thread represent one worker in the customer service department.
        // => fixed thread pool size = customer service department size
        ExecutorService customerServicePool = Executors.newFixedThreadPool(customerServiceDepartmentSize);

        // creates another thread pool.
        // each thread represent one worker in the resolvers department.
        // => fixed thread pool size = resolvers department size
        resolversPool = Executors.newFixedThreadPool(ResolversDepartmentSize);

        // customer service department start getting calls:

        // passes the saveComplaint objects to the pool to execute.
        // explain: the customer service worker will get the customer call, save the complain and
        //          pass it to the resolvers department.
        while (!complaintsQueue.isEmpty()) {
            customerServicePool.execute(complaintsQueue.remove());
        }

        // pool shutdown
        customerServicePool.shutdown();

    }

    // resolvers department get new complaint.
    public static void saveComplaint (Complaint c){
        resolversPool.execute(new resolveComplaint(c));

        // when last complaint move to resolve department the pool can shut down.
        complaintsRemainToResolve--;
        if (complaintsRemainToResolve == 0){
            resolversPool.shutdown();
        }
    }



}
