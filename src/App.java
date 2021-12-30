import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of procesess you want the scheduler to simulate: ");
        int NoOfP = sc.nextInt();
        Process p[] = new Process[NoOfP];
        for (int i = 0; i < NoOfP; i++) {
            System.out.print("enter name: ");
            String pname = sc.nextLine();
            System.out.println("Enter colour(hex): ");
            String pcolour = sc.nextLine();
            System.out.println("Enter arrival time: ");
            int AT = sc.nextInt();
            System.out.println("Enter burst time: ");
            int BT = sc.nextInt();
            System.out.println("Enter priority: ");
            int priority = sc.nextInt();
            System.out.println("Enter Quantum time: ");
            int Quantam = sc.nextInt();
            Process temp = new Process(pname, pcolour, AT, BT, priority, Quantam);
            p[i] = temp;
        }
        System.out.println(
                "Choose type of scheduling to simulate'\n'1-Priority'\n'2-Shortest job first'\n'3-Shortest remaining time first'\n'4-AGAT");
        System.out.print("Enter number: ");
        int choice = sc.nextInt();
        float w;
        float t;
        switch (choice) {
            case (1):
                priority x = new priority();
                Process result[] = x.schedule(p);
                w = x.avgWaitingTime();
                t = x.avgTurnAroundTime();
                break;
            case (2):
                SJF y = new SJF();
                Process result1[] = y.schedule(p, p.length);
                w = y.getAvgWT(p.length);
                t = y.getAvgTT(p.length);
                break;
            case (3):
                shortestRemainingTime z = new shortestRemainingTime();
                Process result2[] = z.Schedule(p);
                w = z.getAverageWaitingTime();
                t = z.getAverageTurnAroundTime();
                break;
            case (4):
                AGAT a = new AGAT();
                Process result3[] = a.Schedule(p);
                w = a.avgw();
                t = a.avgt();
                break;
        }
    }
}
