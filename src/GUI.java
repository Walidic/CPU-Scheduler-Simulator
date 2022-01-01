import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.text.html.HTMLDocument.BlockElement;

import java.awt.*;

public class GUI extends JFrame {
    public void print(Process[] result, int pnumber, String Sname, float waitTime, float turnAroundTime) {
        int blockWidth = 720 / result.length;
        int blockHeight = 480 / pnumber;
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setTitle("Task Manager");

        JPanel graph = new JPanel();
        graph.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
        graph.setPreferredSize(new Dimension(800, 600));
        graph.setBackground(Color.GRAY);
        JPanel graphTitle = new JPanel();
        graphTitle.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        graphTitle.setPreferredSize(new Dimension(750, 20));
        graphTitle.setBackground(Color.GRAY);
        graph.add(graphTitle, BorderLayout.CENTER);
        JLabel graphLabel = new JLabel("CPU Scheduling Graph");
        graphTitle.add(graphLabel);

        JPanel Pnames = new JPanel();
        Pnames.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        Pnames.setPreferredSize(new Dimension(50, 500));
        graph.add(Pnames, LEFT_ALIGNMENT);
        JPanel map = new JPanel();
        map.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        map.setPreferredSize(new Dimension(720, 500));
        graph.add(map);
        JPanel[] mapList = new JPanel[pnumber];
        JPanel[] processList = new JPanel[pnumber];
        Process[] schedule = new Process[pnumber];

        int x = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i].getGraphed() == false) {
                JPanel mapPanel = new JPanel();
                mapPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
                mapPanel.setPreferredSize(new Dimension(720, blockHeight));
                JPanel namePanel = new JPanel();
                namePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                namePanel.setPreferredSize(new Dimension(50, blockHeight));
                JLabel nameLabel = new JLabel(result[i].getName());
                nameLabel.setPreferredSize(new Dimension(50, blockHeight));
                namePanel.add(nameLabel, CENTER_ALIGNMENT);
                mapList[x] = mapPanel;
                processList[x] = namePanel;
                schedule[x] = result[i];
                x++;
                result[i].setGraphed(true);
            }
        }
        for (int i = 0; i < pnumber; i++) {
            map.add(mapList[i]);
            Pnames.add(processList[i]);
        }
        JPanel[][] blockList = new JPanel[pnumber][result.length];
        for (int i = 0; i < pnumber; i++) {
            for (int j = 0; j < result.length; j++) {
                JPanel block = new JPanel();
                block.setPreferredSize(new Dimension(blockWidth, blockHeight));
                blockList[i][j] = block;
                mapList[j].add(blockList[i][j]);
            }
        }
        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i < pnumber; i++) {
                if (result[j].getName() == schedule[j].getName()) {
                    blockList[i][j].setBackground(Color.GREEN);
                }
            }
        }

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
        headers.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
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
        for (int i = 0; i < result.length; i++) {
            if (result[i].getDisplayed() == false) {
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

        for (int i = 0; i < pnumber; i++) {
            info.add(panelList[i], BorderLayout.CENTER);
        }

        JPanel stats = new JPanel();
        stats.setBorder(BorderFactory.createMatteBorder(1, 10, 10, 10, Color.WHITE));
        stats.setPreferredSize(new Dimension(1200, 200));
        stats.setBackground(Color.GRAY);
        JPanel statTitle = new JPanel();
        statTitle.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        statTitle.setPreferredSize(new Dimension(1150, 30));
        statTitle.setBackground(Color.GRAY);
        stats.add(statTitle, LEFT_ALIGNMENT);
        JLabel statLabel = new JLabel("Statistics");
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
