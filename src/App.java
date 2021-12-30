import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of processes ");
        //int n = sc.nextInt();
        //System.out.println("fill processes");
        Process p1 = new Process("p1", "red", 0, 4, 0, 1);
        Process p2 = new Process("p2", "green", 2, 5, 0, 2);
        Process p3 = new Process("p3", "blue", 3, 2, 0, 3);
        Process p4 = new Process("p4", "black", 5, 2, 0, 4);
        Process[] processList = new Process[] {p1, p2, p3, p4};
        /*
        for (int i = 0; i < n; i++){
            System.out.println("process info for: " + (i+1));
            Process newP = new Process(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), 0, (i+1));
            processList[i] = newP;
        }
        */
        sc.close();
        new GUI(SJF.schedule(processList, 4), 4);
    }
}
