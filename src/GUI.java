import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;


class block{

}
public class GUI extends JFrame{
    public GUI(Process[] result, int pnumber, String Sname, float waitTime, float turnAroundTime){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setTitle("Task Manager");

        JPanel graph = new JPanel();
        graph.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
        graph.setPreferredSize(new Dimension(800, 600));
        graph.setBackground(Color.GRAY);
        JLabel label1 = new JLabel("graph");
        graph.add(label1);

        JPanel info = new JPanel();
        info.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
        info.setPreferredSize(new Dimension(400, 600));
        info.setBackground(Color.GRAY);
        JPanel title = new JPanel();
        title.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        title.setBackground(Color.GRAY);
        info.add(title, BorderLayout.CENTER);
        JLabel infoLabel = new JLabel("Process Information");
        title.add(infoLabel);
        JPanel headers = new JPanel();
        headers.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        headers.setPreferredSize(new Dimension(380, 40));
        headers.setBackground(Color.GRAY);
        info.add(headers, BorderLayout.LINE_START);
        JLabel processHead = new JLabel("Process");
        processHead.setPreferredSize(new Dimension(50, 40));
        JLabel colorHead = new JLabel("Color");
        colorHead.setPreferredSize(new Dimension(50, 40));
        JLabel nameHead = new JLabel("Name");
        nameHead.setPreferredSize(new Dimension(50, 40));
        JLabel pidHead = new JLabel("PID");
        pidHead.setPreferredSize(new Dimension(50, 40));
        JLabel priorityHead = new JLabel("Priority");
        priorityHead.setPreferredSize(new Dimension(50, 40));
        headers.add(processHead);
        headers.add(colorHead);
        headers.add(nameHead);
        headers.add(pidHead);
        headers.add(priorityHead);
        JPanel[] panelList = new JPanel[pnumber];
        int j = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i].getDisplayed() == false){
                JPanel processPanel = new JPanel();
           	    processPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            	processPanel.setPreferredSize(new Dimension(300, 40));
                processPanel.setBackground(Color.GRAY);
		        JLabel index = new JLabel("" + j);
                index.setPreferredSize(new Dimension(50, 40));
            	JLabel color = new JLabel(result[i].getColour());
                color.setPreferredSize(new Dimension(50, 40));
            	JLabel name = new JLabel(result[i].getName());
                name.setPreferredSize(new Dimension(50, 40));
            	JLabel pid = new JLabel("" + result[i].getPID());
                pid.setPreferredSize(new Dimension(50, 40));
      	        JLabel priority = new JLabel("" + result[i].getPriorityNumber());
                priority.setPreferredSize(new Dimension(50, 40));
                processPanel.add(index);
                processPanel.add(color);
                processPanel.add(name);
                processPanel.add(pid);
                processPanel.add(priority);
                panelList[j] = processPanel;
                j++;
                result[i].setDisplayed(true);
            }
        }

        for(int i = 0; i < pnumber; i++){
            info.add(panelList[i], BorderLayout.CENTER);
        }

        JPanel stats = new JPanel();
        stats.setBorder(BorderFactory.createMatteBorder(1, 10, 10, 10, Color.WHITE));
        stats.setPreferredSize(new Dimension(1200, 200));
        stats.setBackground(Color.GRAY);
        JPanel statTitle = new JPanel();
        statTitle.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        statTitle.setPreferredSize(new Dimension(1150, 30));
        statTitle.setBackground(Color.GRAY);
        stats.add(statTitle, LEFT_ALIGNMENT);
        JLabel statLabel= new JLabel("Statistics");
        statTitle.add(statLabel);
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        content.setPreferredSize(new Dimension(1150, 150));
        content.setBackground(Color.GRAY);
        stats.add(content);
        JLabel name = new JLabel("Scheduler Used: " + Sname);
        name.setPreferredSize(new Dimension(1140, 40));
        JLabel WT = new JLabel("Average Waiting Time: " + waitTime);
        WT.setPreferredSize(new Dimension(1140, 40));
        JLabel TT = new JLabel("Average Turn Around Time: " + turnAroundTime);
        TT.setPreferredSize(new Dimension(1140, 40));
        content.add(name, LEFT_ALIGNMENT);
        content.add(WT, LEFT_ALIGNMENT);
        content.add(TT, LEFT_ALIGNMENT);
        
        frame.add(graph, BorderLayout.LINE_START);
        frame.add(info, BorderLayout.AFTER_LINE_ENDS);
        frame.add(stats, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

