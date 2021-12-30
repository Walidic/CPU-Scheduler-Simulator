public class AGAT {
    private float v1, v2;
    private int lastindex = -1;
    private int lastQtime = -1;
    public int np;
    public int tw;
    public int tbt;

    public float avgw() {
        return tw / np;
    }

    public float avgt() {
        return (tw + tbt) / np;
    }

    public Process[] Schedule(Process[] processes) {
        Process scratch[] = new Process[processes.length];
        np = processes.length;

        for (int i = 0; i < scratch.length; i++) {
            scratch[i] = null;
        }
        int currentTime = 0;
        int totalTime = 0;
        for (int i = 0; i < processes.length; i++) {
            totalTime = totalTime + processes[i].getBurstTime();
        }
        tbt = totalTime;
        Process result[] = new Process[totalTime];
        v1 = processes[0].getArrivalTime();
        for (int i = 1; i < processes.length; i++) {
            if (processes[i].getArrivalTime() > v1) {
                v1 = processes[i].getArrivalTime();
            }
        }
        if (v1 < 10) {
            v1 = 1;
        } else {
            v1 = v1 / 10;
        }
        while (currentTime < totalTime) {
            v2 = Integer.MIN_VALUE;
            for (int i = 0; i < processes.length; i++) {
                if (processes[processes.length - 1].getArrivalTime() > currentTime) {
                    if (v2 < processes[i].getBurstTime()) {
                        v2 = processes[i].getBurstTime();
                    }
                } else {
                    if (scratch[i] == null) {
                        continue;
                    }
                    if (v2 < scratch[i].getBurstTime()) {
                        v2 = scratch[i].getBurstTime();
                    }
                }
            }
            if (v2 < 10) {
                v2 = 1;
            } else {
                v2 = v2 / 10;
            } // calculating v2

            int availble[] = new int[processes.length];
            for (int i = 0; i < availble.length; i++) {
                availble[i] = -1;
            }
            for (int i = 0; i < availble.length; i++) {
                if (processes[i].getArrivalTime() <= currentTime) {
                    availble[i] = 1;
                }
            } // checking which processes has arrived

            for (int i = 0; i < scratch.length; i++) {
                if (availble[i] == 1) {
                    if (scratch[i] == null) {
                        if (!processes[i].flag) {
                            scratch[i] = processes[i];
                        }
                    }
                }
            } // filling scratch with arrived proceses only

            for (int i = 0; i < scratch.length; i++) {
                if (scratch[i] != null) {
                    scratch[i].setScratch(
                            (int) ((10 - scratch[i].getPriorityNumber()) + (Math.ceil(scratch[i].getArrivalTime() / v1))
                                    + (Math.ceil(scratch[i].getBurstTime() / v2))));
                }
            } // calculating load factor

            int minFactor = Integer.MAX_VALUE;
            int minFactorindex = -1;
            for (int i = 0; i < scratch.length; i++) {
                if (scratch[i] == null) {
                    continue;
                }
                if (scratch[i].getScratch() < minFactor) {
                    minFactor = scratch[i].getScratch();
                    minFactorindex = i;
                }
            }
            if (minFactorindex != lastindex) {
                if (lastQtime > 0) {
                    scratch[lastindex].setQuantam(scratch[lastindex].getQuantam() - lastQtime);
                }
            }
            int pt = scratch[minFactorindex].getQuantam();
            pt = (int) Math.round(pt * 0.4);
            lastQtime = pt;
            lastindex = minFactorindex;
            if (pt >= scratch[minFactorindex].getBurstTime()) {
                int finishTime = currentTime + scratch[minFactorindex].getBurstTime();
                processes[minFactorindex].setWaitingTime(finishTime
                        - (processes[minFactorindex].getArrivalTime() + processes[minFactorindex].getBurstTime()));
                processes[minFactorindex].setTurnAroundTime(
                        processes[minFactorindex].getWaitingTime() + processes[minFactorindex].getBurstTime());
                for (int i = 0; i < scratch[minFactorindex].getBurstTime(); i++) {
                    result[currentTime] = processes[minFactorindex];
                    currentTime++;
                }
                System.out.println(processes[minFactorindex].getName());
                lastQtime = -1;
                lastindex = -1;
                scratch[minFactorindex] = null;
                processes[minFactorindex].flag = true;
                continue;
            }
            for (int i = 0; i < pt; i++) {
                result[currentTime] = processes[minFactorindex];
                currentTime++;
                scratch[minFactorindex].setBurstTime(scratch[minFactorindex].getBurstTime() - 1);
            }
        }
        return result;
    }
}

// class Main {
// public static void main(String[] args) {
// // (String pname, String pcolour, int AT, int BT, int priority, int Quantam)
// Process p1 = new Process("p1", "x", 0, 17, 4, 4);
// Process p2 = new Process("p2", "x", 3, 6, 9, 3);
// Process p3 = new Process("p3", "x", 4, 10, 3, 5);
// Process p4 = new Process("p4", "x", 29, 4, 8, 2);
// // Process p5 = new Process("p5", "x", 5, 1, 0, 100);
// Process arr[] = new Process[] { p1, p2, p3, p4 };
// AGAT x = new AGAT();
// Process y[] = x.Schedule(arr);
// for (int i = 0; i < 37; i++) {
// System.out.print(y[i].getName() + " ");
// }
// }
// }