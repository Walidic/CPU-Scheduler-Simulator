import java.util.Random;

public class Process {
    private String name;
    private String colour;
    private int arrivalTime;
    private int burstTime;
    private int priorityNumber;
    private int PID;
    private int waitingTime;
    private int turnAroundTime;
    private int executionTime;
    private int scratch; // used for calculations
    public boolean flag = false;
    private int Quantam;
    private boolean isDisplayed;
    private boolean isGraphed;

    public Process(String pname, String pcolour, int AT, int BT, int priority, int Quantam) {
        Random rand = new Random();
        name = pname;
        colour = pcolour;
        arrivalTime = AT;
        burstTime = BT;
        priorityNumber = priority;
        PID = rand.nextInt(99999);
        scratch = 0;
        isDisplayed = false;
        isGraphed = false;
        this.Quantam = Quantam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriorityNumber() {
        return this.priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public void setScratch(int scratch) {
        this.scratch = scratch;
    }

    public int getScratch() {
        return scratch;
    }

    public int getQuantam() {
        return Quantam;
    }

    public void setQuantam(int Quantam) {
        this.Quantam = Quantam;
    }

    public boolean getDisplayed() {
        return isDisplayed;
    }

    public void setDisplayed(boolean isDisplayed) {
        this.isDisplayed = isDisplayed;
    }

    public boolean getGraphed() {
        return isGraphed;
    }

    public void setGraphed(boolean isGraphed) {
        this.isGraphed = isGraphed;
    }
}
