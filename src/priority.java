import java.util.Arrays;

import javax.xml.stream.events.StartDocument;
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
    public void totalTime(Process processes[])
    {   totalTime=0;
        for(int i = 0; i < processes.length; i++)
        {    
            totalTime= totalTime + processes[i].getBurstTime();
        }
    }
    public void adjustPriority()
    {
        for (int i = 0; i < procs.length; i++)
        {
            if(procs[i]!=null)
            {
                procs[i].setPriorityNumber(procs[i].getPriorityNumber()+procs[i].getWaitingTime()); // inc priority for all processes by 1 as time passes
            }
        }
    }
    void bubbleSort()
    {   
        int n = procs.length;
        
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if(procs[j]!=null && procs[j+1]!=null){
                    if(procs[j].getArrivalTime() !=0 ){
                if (procs[j].getPriorityNumber() < procs[j+1].getPriorityNumber()) //higher priority no = higher priority
                {
                    // swap arr[j+1] and arr[j]
                    Process temp = procs[j];
                    procs[j] = procs[j+1];
                    procs[j+1] = temp;
                }
                else if(procs[j].getPriorityNumber() == procs[j+1].getPriorityNumber())
                {
                    if(procs[j].getArrivalTime() > procs[j+1].getArrivalTime()) 
                    {
                        // swap arr[j+1] and arr[j]
                        Process temp = procs[j];
                        procs[j] = procs[j+1];
                        procs[j+1] = temp;
                    }
                }
            }
            }
            
    }

    public Process []Schedule(Process processes[]) {
         //set local variable so data is shared
        totalTime(processes);
        System.out.print(totalTime);
        procs = new Process[totalTime];
        int j=0; int dummy = 0;

        for (int i = 0; i < processes.length; i++)
        {
            dummy =j;
            int bT = processes[i].getBurstTime();
            for( j=j; j < dummy+bT; j++ )
            {
                procs[j]=processes[i];
                currentTime++;
                // adjustPriority();
            }
            // bubbleSort();
        }
        startTime();
        waitingTime();
        adjustPriority();
        bubbleSort();
        turnAroundTime();
        avgWaitingTime();
        avgTurnAroundTime();
        return procs;
    }
}

class Main {
    public static void main(String[] args) {
        //  String pname, String pcolour, int AT, int BT, int priority, int pid
        Process p1 = new Process("p1", "x", 0, 4, 2, 50);
        Process p2 = new Process("p2", "x", 1, 3, 3, 70);
        Process p3 = new Process("p3", "x", 2, 1, 4, 101);
        Process p4 = new Process("p4", "x", 3, 5, 5, 100);
        Process p5 = new Process("p5", "x", 4, 2, 5, 100);
        Process arr[] = new Process[] { p1, p2, p3, p4,p5 };
        priority x = new priority();
        Process arr2[] = new Process[15];
        arr2=(x.Schedule(arr));
        for (int i=0;i<arr2.length; i++)
        {
            System.out.print(arr2[i].getName());
        }
    }
}
