import java.util.Scanner;

public class AGAT {
    private int v1,v2;

    public void Schedule(Process[] processes){
        Process scratch[] = new Process[processes.length];
        for (int i = 0; i < scratch.length; i++) {
            scratch[i] = null;
        }
        int currentTime = 0;
        int totalTime = 0;
        for(int i = 0;i<processes.length;i++){
            totalTime = totalTime+processes[i].getBurstTime();
        }
        Process result[] = new Process[totalTime];
        v1 = processes[0].getArrivalTime();
        for(int i=1;i<processes.length;i++){
            if(processes[i].getArrivalTime()>v1){
                v1 = processes[i].getArrivalTime();
            }
        }
        int scratchIndex = 0;
        while (currentTime < totalTime) {
            v2 = Integer.MIN_VALUE;
            for (int i = 0; i < processes.length; i++) {
                if (v2 < processes[i].getBurstTime()) {
                    v2 = processes[i].getBurstTime();
                }
            } // calculating v2

            int availble[] = new int[processes.length];
            for(int i = 0;i<availble.length;i++){
                availble[i] = -1;
            }
            for(int i = 0;i<availble.length;i++){
                if(processes[i].getArrivalTime()<=currentTime){
                    availble[i] = 1;
                }
            } //checking which processes has arrived

            for (int i = 0; i < scratch.length; i++) {
                if (availble[i] == 1) {
                    if(scratch[i]==null){
                        scratch[i]=processes[i];
                    }
                }
            }//filling scratch with arrived proceses only
        }
    }
}
