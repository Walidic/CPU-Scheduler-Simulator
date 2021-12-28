public class shortestJobFirst {
    public void Schedule(Process[] processes) {
        int count = processes.length;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (processes[i].getBurstTime() > processes[j].getBurstTime()) {
                    Process temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (processes[i].getArrivalTime() > processes[j].getArrivalTime()) {
                    Process temp = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temp;
                }

            }
        }
    }

}
