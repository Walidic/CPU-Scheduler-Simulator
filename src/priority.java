import java.util.Arrays;
public class priority{
int totalTime;
int currentTime=0;
Process procs[];
    public void waitingTime()
    {
        for (int i = 0; i < procs.length; i++)
        {
            procs[i].setWaitingTime(procs[i].getExecutionTime()-procs[i].getArrivalTime()); //wait=start-arrival
        }
    }
    public void startTime()
    {
        procs[0].setExecutionTime(0);
        for (int i = 1; i < procs.length; i++)
        {
            procs[i].setExecutionTime( procs[i-1].getExecutionTime() + procs[i-1].getBurstTime()); //wait=start-arrival
        }
    }
    public int avgWaitingTime()
    {   int sum=0;
        int avg;
        for (int i = 0; i < procs.length; i++)
        {
            sum=sum+procs[i].getWaitingTime();
        }
        avg=sum/procs.length;
        return avg;
    }
    public void turnAroundTime()
    {
        for (int i = 0; i < procs.length; i++)
        {
            procs[i].setTurnAroundTime( procs[i].getWaitingTime() + procs[i].getBurstTime() );
        }
    }
    public int avgTurnAroundTime()
    {
        int sum=0;
        int avg;
        for (int i = 0; i < procs.length; i++)
        {
            sum=sum+procs[i].getTurnAroundTime();
        }
        avg=sum/procs.length;
        return avg;
    }
    public void totalTime()
    {   totalTime=0;
        for(int i = 0; i < procs.length; i++)
        {    
            totalTime= totalTime + procs[i].getBurstTime();
        }
    }
    public void adjustPriority()
    {
        for (int i = 0; i < procs.length; i++)
        {
            if(procs[i]!=null)
            {
                procs[i].setPriorityNumber(procs[i].getPriorityNumber()+1); // inc priority for all processes by 1 as time passes
            }
        }
    }
    void bubbleSort()
    {
        int n = procs.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (procs[j].getArrivalTime() > procs[j+1].getArrivalTime())
                {
                    // swap arr[j+1] and arr[j]
                    Process temp = procs[j];
                    procs[j] = procs[j+1];
                    procs[j+1] = temp;
                }
                else if(procs[j].getArrivalTime() == procs[j+1].getArrivalTime())
                {
                    if(procs[j].getPriorityNumber() > procs[j+1].getPriorityNumber()) //higher priority no = higher priority
                    {
                        // swap arr[j+1] and arr[j]
                        Process temp = procs[j];
                        procs[j] = procs[j+1];
                        procs[j+1] = temp;
                    }
                }
    }

    public Process []Schedule(Process processes[]) {
         //set local variable so data is shared
        procs = new Process[totalTime];
        int j=0;
        for (int i = 0; i < processes.length; i++)
        {
            int bT = processes[i].getBurstTime();
            for( j=j; j < j+bT; j++ )
            {
                procs[j]=processes[i];
                currentTime++;
                adjustPriority();
            }
        }
        bubbleSort();
        return procs;
    }
}
