package algoAnalytics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;
 
public class GraphingData extends JPanel {
	long[] data;
 /*  
  * Selection	94	344	546	985	1536	2187	2985	3901	4931	6088
  * Insertion	78	296	203	361	561	827	1094	1453	1858	2268
  * Merge	0	0	0	0	16	0	15	16	16	17
  * Quicksort	0	0	0	16	0	15	0	0	0	0
  * Heapsort	15	16	1	0	0	0	1	15	1	32
*/
    
    
    final int PAD = 20;
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        // Draw y
        g2.draw(new Line2D.Double(PAD, PAD, PAD, height-PAD));
        // Draw x.
        g2.draw(new Line2D.Double(PAD, height-PAD, width-PAD, height-PAD));
        // Draw labels
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
        // y label
        String s = "Elapsed Time";
        float sy = PAD + ((height - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (PAD - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }
        // x label
        s = "Input Size";
        sy = height - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (width - sw)/2;
        g2.drawString(s, sx, sy);
        // Draw lines.
        double xInc = (double)(width - 2*PAD)/(data.length-1);
        double scale = (double)(height - 2*PAD)/getMax();
        Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
        g2.setPaint(randomColor.darker());
        for (int i = 0; i < data.length-1; i++) {
            double x1 = PAD + i*xInc;
            double y1 = height - PAD - scale*data[i];
            double x2 = PAD + (i+1)*xInc;
            double y2 = height - PAD - scale*data[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        // Mark data points.
        g2.setPaint(randomColor.black);
        for (int i = 0; i < data.length; i++) {
            double x = PAD + i*xInc;
            double y = height - PAD - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private int getMax() {
    	
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++) {
            if(data[i] > max)
                max = (int) data[i];
        }
        return max;
    }


	/**
	 * @return the data
	 */
	public long[] getData() {
		return data;
	}

	/**
	 * @param time1 the data to set
	 */
	public void setData(long[] data) {
		this.data = data;
	}

}