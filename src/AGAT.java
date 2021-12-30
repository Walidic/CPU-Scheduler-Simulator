public class AGAT {
    private int v1,v2;
    
    public void Schedule(Process[] processes){
        Process scratch[] = processes;

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
        int mainArrIndex = 0;
        while(currentTime<totalTime){
            if(mainArrIndex == processes.length-1){
                mainArrIndex = 0;
            }
            v2 = Integer.MIN_VALUE;
            for(int i = 0;i<processes.length;i++){
                if(scratch[i]==null){
                    continue;
                }
                if(v2<scratch[i].getBurstTime()){
                    v2 = scratch[i].getBurstTime();
                }
            }
            int availble[] = new int[scratch.length];
            for(int i = 0;i<availble.length;i++){
                availble[i] = -1;
            }
            for(int i = 0;i<availble.length;i++){
                if(scratch[i]==null){
                    continue;
                }
                if(scratch[i].getArrivalTime()<=currentTime){
                    availble[i] = 1;
                }
            }
        }
    }
}
