import java.util.Scanner;

public class SJF{
    static int totalTime = 0;
    static int t = 0;
    static int totalWaitTime = 0;
    static int totalTurnAroundTime = 0;
    public static Process[] schedule(Process[] inputList, int size){
        
        for(int i = 0; i < size; i++){
            totalTime += inputList[i].getBurstTime();
        }
        Process[] schedule = new Process[totalTime];
        Process[] arrivePool = new Process[4];
        for (int i = 0; i < 4; i++){
            arrivePool[i] = null;
        }

        int index = 0;
        while(t < totalTime){
            boolean deleteFlag = false;
            if(isPoolEmpty(arrivePool) == true){
                for(int i = 0; i < arrivePool.length; i++){
                    arrivePool[i] = inputList[index];
                    index++;
                    if(arrivePool[i] == inputList[inputList.length - 1]){
                        break;
                    }
                }
            }

            int available[] = new int[] {-1, -1, -1, -1};
            for(int i = 0; i < arrivePool.length; i ++){
                if(arrivePool[i] == null){
                    continue;
                }
                else if(arrivePool[i].getArrivalTime() <= t){
                    available[i] = 1;
                }
            }
            int minBT = Integer.MAX_VALUE;
            int minBTix = 0;
            for(int i = 0; i < available.length; i++){
                if(available[i] == 1){
                    if(arrivePool[i].getBurstTime() < minBT){
                        minBT = arrivePool[i].getBurstTime();
                        minBTix = i;
                    }
                }
            }

            int WT = t - arrivePool[minBTix].getArrivalTime();
            arrivePool[minBTix].setWaitingTime(WT);
            totalWaitTime += WT;
            int TT = WT + minBT;
            arrivePool[minBTix].setTurnAroundTime(TT);
            totalTurnAroundTime += TT;

            for(int i = 0; i < arrivePool[minBTix].getBurstTime(); i++){
                schedule[t+i] = arrivePool[minBTix];
            }

            int x = arrivePool[minBTix].getBurstTime();
            deleteFlag = true;
            if(deleteFlag){
                arrivePool[minBTix] = null;
            }

            t = t + x;
        }

        for(int i = 0; i < totalTime; i++){
            System.out.println(i + ": " + schedule[i].getName() + " WT: " + schedule[i].getWaitingTime() + " TT: " + schedule[i].getTurnAroundTime());
        }
        float avgWT = average(totalWaitTime, size);
        float avgTT = average(totalTurnAroundTime, size);
        System.out.println("average wait time is: " + avgWT + " and average turnaround time is: " + avgTT);
        return schedule;
    }

    private static boolean isPoolEmpty(Process[] pool) {
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null) {
                return false;
            }
        }
        return true;
    }

    private static float average(int x, int n){
        int AVG = x / n;
        return AVG;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of processes ");
        int n = sc.nextInt();
        System.out.println("fill processes");
        Process p1 = new Process("p1", "r", 0, 4, 0, 1);
        Process p2 = new Process("p2", "r", 2, 5, 0, 2);
        Process p3 = new Process("p3", "r", 3, 2, 0, 3);
        Process p4 = new Process("p4", "r", 5, 2, 0, 4);
        Process[] processList = new Process[] {p1, p2, p3, p4};
        /*
        for (int i = 0; i < n; i++){
            System.out.println("process info for: " + (i+1));
            Process newP = new Process(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), 0, (i+1));
            processList[i] = newP;
        }
        */
        schedule(processList, n);
        sc.close();
    }
}