import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of processes ");
        int n = 4;
        //System.out.println("fill processes");
        Process p1 = new Process("p1", "red", 0, 4, 0, 4984);
        Process p2 = new Process("p2", "green", 2, 5, 0, 591);
        Process p3 = new Process("p3", "blue", 3, 2, 0, 3143);
        Process p4 = new Process("p4", "black", 5, 2, 0, 7989);
        Process[] processList = new Process[] {p1, p2, p3, p4};
        /*
        for (int i = 0; i < n; i++){
            System.out.println("process info for: " + (i+1));
            Process newP = new Process(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), 0, (i+1));
            processList[i] = newP;
        }
        */
        sc.close();
        SJF test = new SJF();
        int outSize = 0;
        for(int i = 0; i < n; i++){
            outSize += processList[i].getBurstTime();
        }
        Process[] outputList = new Process[outSize];
        outputList = test.schedule(processList, n);
        float avgWT = test.getAvgWT(n);
        float avgTT = test.getAvgTT(n);
        new GUI(outputList, 4, "SFJ", avgWT, avgTT);
    }
}
