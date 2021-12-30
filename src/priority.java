public class priority {
    int totalTime = 0;
    int t = 0;
    int totalWaitTime = 0;
    int numOfProceses = 0;

    public Process[] schedule(Process[] inputList) {
        numOfProceses = inputList.length;
        for (int i = 0; i < inputList.length; i++) {
            totalTime += inputList[i].getBurstTime();
        }
        Process[] schedule = new Process[totalTime];
        Process[] arriveTemp = new Process[inputList.length];
        for (int i = 0; i < inputList.length; i++) {
            arriveTemp[i] = null;
        }
        for (int i = 0; i < arriveTemp.length; i++) {
            arriveTemp[i] = inputList[i];
        }
        while (t < totalTime) {
            boolean deleteFlag = false;

            int available[] = new int[inputList.length];
            for (int i = 0; i < arriveTemp.length; i++) {
                if (arriveTemp[i] == null) {
                    continue;
                } else if (arriveTemp[i].getArrivalTime() <= t) {
                    available[i] = 1;
                }
            }
            int maxPriority = -1;
            int maxPriorityIndex = 0;
            for (int i = 0; i < available.length; i++) {
                if (available[i] == 1 && arriveTemp[i] != null) {
                    if (arriveTemp[i].getPriorityNumber() > maxPriority) {
                        maxPriority = arriveTemp[i].getPriorityNumber();
                        maxPriorityIndex = i;
                    }
                }
            }
            arriveTemp[maxPriorityIndex].setWaitingTime(t - arriveTemp[maxPriorityIndex].getArrivalTime());
            arriveTemp[maxPriorityIndex].setTurnAroundTime(
                    arriveTemp[maxPriorityIndex].getBurstTime() + arriveTemp[maxPriorityIndex].getWaitingTime());
            totalWaitTime = totalWaitTime + (t - arriveTemp[maxPriorityIndex].getArrivalTime());
            for (int i = 0; i < arriveTemp[maxPriorityIndex].getBurstTime(); i++) {
                schedule[t + i] = arriveTemp[maxPriorityIndex];
            }
            int x = arriveTemp[maxPriorityIndex].getBurstTime();
            deleteFlag = true;
            if (deleteFlag) {
                arriveTemp[maxPriorityIndex] = null;
            }
            t = t + x;

            for (int i = 0; i < arriveTemp.length; i++) {
                if (arriveTemp[i] == null) {
                    continue;
                } else if (arriveTemp[i].getArrivalTime() <= t) {
                    available[i] = 1;
                }
            }
            for (int i = 0; i < arriveTemp.length; i++) {
                if (i != maxPriorityIndex && available[i] == 1 && arriveTemp[i] != null) {
                    arriveTemp[i].setPriorityNumber(
                            arriveTemp[i].getPriorityNumber() + (t - arriveTemp[i].getArrivalTime()));
                }
            }

        }
        return schedule;
    }

    public float avgWaitingTime() {
        return totalWaitTime / numOfProceses;
    }

    public float avgTurnAroundTime() {
        return (totalWaitTime + totalTime) / numOfProceses;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println('a');
        // String pname, String pcolour, int AT, int BT, int priority, int pid
        Process p1 = new Process("p1", "x", 0, 4, 2, 50);
        Process p2 = new Process("p2", "x", 1, 3, 3, 70);
        Process p3 = new Process("p3", "x", 2, 1, 4, 101);
        Process p4 = new Process("p4", "x", 3, 5, 5, 100);
        Process p5 = new Process("p5", "x", 4, 2, 5, 100);
        Process arr[] = new Process[] { p1, p2, p3, p4, p5 };
        priorityDraft x = new priorityDraft();
        Process arr2[] = (x.schedule(arr));
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i].getName());
            System.out.print(" ");
            System.out.println(arr2[i].getPriorityNumber());
        }
        int z = 5;
        int s = 2;
        float y = z / s;
        System.out.println("************");
        System.out.println(y);
        System.out.println(x.avgTurnAroundTime());
        System.out.println(x.avgWaitingTime());
    }
}
