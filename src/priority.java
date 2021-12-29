// import java.util.Arrays;

// public class priority{
// Process procs[];
// public void waitingTime(Process processes[])
// {
// for (int i = 0; i < procs.length; i++)
// {
// procs[i].setW
// }
// }
// void bubbleSort()
// {
// int n = procs.length;
// for (int i = 0; i < n-1; i++)
// for (int j = 0; j < n-i-1; j++)
// if (procs[j].getArrivalTime() > procs[j+1].getArrivalTime())
// {
// // swap arr[j+1] and arr[j]
// Process temp = procs[j];
// procs[j] = procs[j+1];
// procs[j+1] = temp;
// }
// else if(procs[j].getArrivalTime() == procs[j+1].getArrivalTime())
// {
// if(procs[j].getPriorityNumber() > procs[j+1].getPriorityNumber())
// {
// // swap arr[j+1] and arr[j]
// Process temp = procs[j];
// procs[j] = procs[j+1];
// procs[j+1] = temp;
// }
// }
// }

// public Process []Schedule(Process processes[]) {
// procs=Arrays.copyOf(processes,processes.length); //set local variable so data
// is shared
// bubbleSort();
// return procs;
// }
// }
