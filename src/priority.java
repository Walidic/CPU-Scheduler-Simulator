
public class priority{

    public void Schedule(Process processes[]) {
        int count = processes.length;
        for(int i=0;i<count;i++){
            for (int j=i;j<count;j++){
                if(processes[i].getPriorityNumber()>processes[j].getPriorityNumber()){
                    Process temp = processes[i];
                    processes[i]=processes[j];
                    processes[j]=temp;
                }
            }
        }
    }
}
