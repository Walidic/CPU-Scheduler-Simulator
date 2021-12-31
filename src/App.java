import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of procesess you want the scheduler to simulate: ");
        int NoOfP = sc.nextInt();
        Process p[] = new Process[NoOfP];
        for (int i = 0; i < NoOfP; i++) {
            System.out.println("Process number: " + i);
            System.out.println("enter name: ");
            String pname = sc.next();
            System.out.println("Enter colour(hex): ");
            String pcolour = sc.next();
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
        GUI testgGui = new GUI();
        switch (choice) {
            case (1):
                priority x = new priority();
                Process result[] = x.schedule(p);
                w = x.avgWaitingTime();
                t = x.avgTurnAroundTime();
                testgGui.print(result, NoOfP, "Priority", w, t);
                break;
            case (2):
                SJF y = new SJF();
                Process result1[] = y.schedule(p, p.length);
                w = y.getAvgWT(p.length);
                t = y.getAvgTT(p.length);
                testgGui.print(result1, NoOfP, "Shortest job first", w, t);
                break;
            case (3):
                shortestRemainingTime z = new shortestRemainingTime();
                Process result2[] = z.Schedule(p);
                w = z.getAverageWaitingTime();
                t = z.getAverageTurnAroundTime();
                testgGui.print(result2, NoOfP, "Shortest temaining time", w, t);
                break;
            case (4):
                AGAT a = new AGAT();
                Process result3[] = a.Schedule(p);
                w = a.avgw();
                t = a.avgt();
                testgGui.print(result3, result3.length, "AGAT", w, t);
                break;
        }
        sc.close();
    }
}
