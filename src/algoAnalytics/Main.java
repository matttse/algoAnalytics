package algoAnalytics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import javax.swing.*;
public class Main extends JComponent {
		
		//selection sort
		public static long segmentedSearching(int[] selectData) {
			long startTime = System.currentTimeMillis();
			algorithm.segmentedSearch(selectData, 0, selectData.length);
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;

			System.out.print("Segmented Searching Every4th then preceding 3: ");
			System.out.println(elapsedTime);
			return elapsedTime;
		}

		public static int[] generateData(int min, int max, int elements) {
			int[] data = new int[elements];
			for (int i = 0; i < elements; i++) {
				data[i] = (int) (Math.random() * (max - min) + min);
				
			}
			return data;
		}

		public static void main(String[] args) {
			int upper = 1000000;
			int lower = 1;
			int[] data1, data2, data3, data4, data5, data6, data7, data8, data9, data10;
			Object sTime1, sTime2, sTime3, sTime4, sTime5, sTime6, sTime7, sTime8, sTime9, sTime10;

			long[] selectionETime = new long[10];
			//10000
			int numEle = 10000;
			data1 = generateData(lower, upper, numEle);
			int[] selectData = new int[numEle];
			System.arraycopy(data1, 0, selectData, 0, numEle);
			
			sTime1 = Long.toString(segmentedSearching(selectData));

			//20000
			numEle = 20000;
			data2 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			System.arraycopy(data2, 0, selectData, 0, numEle);
			
			sTime2 = Long.toString(segmentedSearching(selectData));
			
			//30000
			numEle = 30000;
			data3 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime3 = Long.toString(segmentedSearching(selectData));
			
			//40000
			numEle = 40000;
			data4 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime4 = Long.toString(segmentedSearching(selectData));
			
			//50000
			numEle = 50000;
			data5 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime5 = Long.toString(segmentedSearching(selectData));
			
			//60000
			numEle = 60000;
			data6 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime6 = Long.toString(segmentedSearching(selectData));
			
			//70000
			numEle = 70000;
			data7 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime7 = Long.toString(segmentedSearching(selectData));
			
			//80000
			numEle = 80000;
			data8 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime8 = Long.toString(segmentedSearching(selectData));
			
			//90000
			numEle = 90000;
			data9 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime9 = Long.toString(segmentedSearching(selectData));
			
			//100000
			numEle = 100000;
			data10 = generateData(lower, upper, numEle);
			selectData = new int[numEle];
			
			sTime10 = Long.toString(segmentedSearching(selectData));
			
			Object[][] tableData =
			{
		            {"Selection", sTime1, sTime2, sTime3, sTime4 , sTime5, sTime6, sTime7, sTime8, sTime9, sTime10 }

			};
			String[] columnNames = {"Algorithms", "10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000"};
		    //build table
			JTable table = new JTable(tableData, columnNames);
			JScrollPane scrollPane = new JScrollPane(table);
			JFrame elapsedTimeTable = new JFrame();
			
			elapsedTimeTable.add(scrollPane, BorderLayout.CENTER);
			elapsedTimeTable.setSize(700, 200);
			elapsedTimeTable.setVisible(true);
			elapsedTimeTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//create time arrays
			for (int i = 0; i < selectionETime.length; i++) {
				selectionETime[i] = Long.parseLong(String.valueOf(tableData[0][i+1]));
			}  
			//display elapsed time graphs
			GraphingData gd = new GraphingData();
			//selection
			JFrame selectionGraph = new JFrame();
			selectionGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			selectionGraph.setSize(800, 800);
	        selectionGraph.setLocation(200,200);        
	        gd.setData(selectionETime);
	        selectionGraph.add(gd);
	        selectionGraph.setVisible(true);
	        			 
		}
		
		
		
		
	}

}
