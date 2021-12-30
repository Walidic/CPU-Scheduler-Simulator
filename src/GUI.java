import javax.swing.*;
import java.awt.*;


class block{

}
public class GUI extends JFrame{
    public GUI(Process[] result, int pnumber){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setTitle("Task Manager");

        JPanel graph = new JPanel();
        graph.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        graph.setPreferredSize(new Dimension(800, 600));
        JLabel label1 = new JLabel("graph");
        graph.add(label1);

        JPanel info = new JPanel();
        info.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        info.setPreferredSize(new Dimension(400, 600));
        JLabel infoLabel = new JLabel("Process Information");
        info.add(infoLabel);

        JPanel stats = new JPanel();
        stats.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 10, Color.BLACK));
        stats.setPreferredSize(new Dimension(1200, 200));
        JLabel label3 = new JLabel("stats");
        stats.add(label3);
        
        frame.add(graph, BorderLayout.LINE_START);
        frame.add(info, BorderLayout.AFTER_LINE_ENDS);
        frame.add(stats, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

