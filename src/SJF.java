import java.util.Scanner;

public class SJF{
    static int totalTime = 0;
    static int t =0;
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
        for(t = 0; t < totalTime; t++){
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
                else if(arrivePool[i].getArrivalTime() <= 0){
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
            deleteFlag = true;
            schedule[t] = arrivePool[minBTix];
            if(deleteFlag){
                arrivePool[minBTix] = null;
            }
        }

        for(int i = 0; i < totalTime; i++){
            System.out.println(i + ": " + schedule[i]);
        }
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

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of processes ");
        int n = sc.nextInt();
        System.out.println("fill processes");
        Process[] processList = new Process[n];
        for (int i = 0; i < n; i++){
            System.out.println("process info for: " + (i+1));
            Process newP = new Process(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), 0, (i+1));
            processList[i] = newP;
        }
        schedule(processList, n);
        sc.close();
    }
}