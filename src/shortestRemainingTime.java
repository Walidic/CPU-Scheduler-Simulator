public class shortestRemainingTime {

    private int totalTime = 0;
    private int currentTime = 0;
    private int totalWaitingTime;
    private int noOfProcesses;

    public Process[] Schedule(Process[] processes) {
        noOfProcesses = processes.length;
        for (int i = 0; i < processes.length; i++) {
            totalTime = totalTime + processes[i].getBurstTime();
        }
        Process result[] = new Process[totalTime];
        // To solve starvation we will creat a limeted pool of processes that have a
        // smaller arrival time
        Process pool[] = new Process[4];
        for (int i = 0; i < 4; i++) {
            pool[i] = null;
        }
        // Sorting the array by arrival time
        for (int i = 0; i < processes.length; i++) {
            for (int j = i; j < processes.length; j++) {
                if (processes[i].getArrivalTime() > processes[j].getArrivalTime()) {
                    Process temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                }
            }
        }
        int mainArrayindex = 0;
        for (currentTime = 0; currentTime < totalTime; currentTime++) {
            boolean deleteFlag = false;
            if (isPoolEmpty(pool)) {
                for (int i = 0; i < pool.length; i++) {
                    pool[i] = processes[mainArrayindex];
                    pool[i].setScratch(pool[i].getBurstTime());
                    mainArrayindex++;
                    if (pool[i] == processes[processes.length - 1]) {
                        break;
                    }
                }
            }
            int availble[] = new int[] { -1, -1, -1, -1 };
            for (int i = 0; i < pool.length; i++) {
                if (pool[i] == null) {
                    continue;
                }
                if (pool[i].getArrivalTime() <= currentTime) {
                    availble[i] = 1;
                }
            }
            int minBurstTime = Integer.MAX_VALUE;
            int minBurstTimeIndex = 0;
            for (int i = 0; i < availble.length; i++) {
                if (availble[i] == 1) {
                    if (minBurstTime > pool[i].getScratch()) {
                        minBurstTime = pool[i].getScratch();
                        minBurstTimeIndex = i;
                    }
                }
            }
            if (pool[minBurstTimeIndex].getScratch() == 1) {
                pool[minBurstTimeIndex].setWaitingTime(currentTime + 1
                        - (pool[minBurstTimeIndex].getArrivalTime() + pool[minBurstTimeIndex].getBurstTime()));
                totalWaitingTime = pool[minBurstTimeIndex].getWaitingTime();
                pool[minBurstTimeIndex].setTurnAroundTime(
                        pool[minBurstTimeIndex].getWaitingTime() + pool[minBurstTimeIndex].getBurstTime());
                deleteFlag = true;
            }
            pool[minBurstTimeIndex].setScratch(pool[minBurstTimeIndex].getScratch() - 1);
            result[currentTime] = pool[minBurstTimeIndex];
            if (deleteFlag) {
                pool[minBurstTimeIndex] = null;
            }
        }
        return result;
    }

    public float getAverageWaitingTime(Process[] result) {
        return totalWaitingTime / noOfProcesses;
    }

    public float getAverageTurnAroundTime(Process[] result) {
        return totalWaitingTime + totalTime / noOfProcesses;
    }

    private boolean isPoolEmpty(Process[] pool) {
        for (int i = 0; i < pool.length; i++) {
            if (pool[i] != null) {
                return false;
            }
        }
        return true;
    }

}

// class Main {
//     public static void main(String[] args) {
//         Process p1 = new Process("p1", "x", 0, 5, 0, 100);
//         Process p2 = new Process("p2", "x", 2, 2, 0, 100);
//         Process p3 = new Process("p3", "x", 2, 4, 0, 100);
//         Process p4 = new Process("p4", "x", 5, 1, 0, 100);
//         Process p5 = new Process("p5", "x", 5, 1, 0, 100);
//         Process arr[] = new Process[] { p1, p2, p3, p4, p5 };
//         shortestRemainingTime x = new shortestRemainingTime();
//         x.Schedule(arr);
//     }
// }