public class shortestRemainingTime {

    public void Schedule(Process[] processes) {
        processes = reorder(processes, 5);
    }

    private Process[] reorder(Process[] processes, int count) {
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (processes[i].getArrivalTime() > processes[j].getArrivalTime()) {
                    Process temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                }
            }
        }
        return processes;
    }
}
