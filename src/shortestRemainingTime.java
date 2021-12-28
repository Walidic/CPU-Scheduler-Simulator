public class shortestRemainingTime {

    private int totalTime = 0;
    private int currentTime = 0;

    public void Schedule(Process[] processes) {
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
        for (currentTime = 0; currentTime <= totalTime; currentTime++) {
            if (pool[4] == null) {
                for (int i = 0; i < 4; i++) {
                    pool[i] = processes[mainArrayindex];
                    mainArrayindex++;
                }
            }
            //get least arrival and burst time

        }
    }

}
