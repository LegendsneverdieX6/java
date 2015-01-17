package stockmarket;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TS {
	static int totalDown = 0, totalUp = 0, correct4 = 0, wrong4 = 0, correct5 = 0, wrong5 = 0, correct7 = 0, wrong7 = 0, correct10 = 0, wrong10 = 0;
	int lineCtr = 0 , lineCtr2 = 0;
	double pct4, pct5, pct7, pct10;
	double body, stick, bottom, quarter, half, sevenFive, top;// variables for
																// candle stick
																// designation
	double[] open = new double[70000];
	double[] close = new double[70000];
	double[] low = new double[70000];
	double[] high = new double[70000];
	double[] sma = new double[70000];
	String[] date = new String[70000];
	String[] candle = new String[70000];
	String[] pattern = new String[70000];
	String[] four = new String[70000];
	String[] five = new String[70000];
	String[] seven = new String[70000];
	String[] ten = new String[70000];
	String file;
	static String file2;
	

	public TS(String fileName) throws IOException {
		file = fileName;
		file2 = fileName;
		fillArrays(); // read the data from the file
		candleStick(); // candle stick designation
		sma();
		pattern(); // Three Soldier pattern recognition
		verify();
		printResults();
		printSheet(); // Print results
	}

// Read file, and populate the arrays
	void fillArrays() throws FileNotFoundException {

		Scanner in = new Scanner(new File("/Users/anastassiyaneznanova/Desktop/" + file + "out.csv"));
	
		in.nextLine(); // skip first line of csv file
	
		while (in.hasNextLine()) // as long as there is a next line of data
		{
			String[] n = in.nextLine().split(","); // split each line and
													// identify token by "CSV"
													// comma-separated values
			close[lineCtr] = Double.parseDouble(n[4]);
			low[lineCtr] = Double.parseDouble(n[3]);
			high[lineCtr] = Double.parseDouble(n[2]);
			open[lineCtr] = Double.parseDouble(n[1]);
			date[lineCtr] = n[0];
			lineCtr++;
		}// close while loop
		in.close(); // close file
	}// End of FillArray

	
// Candlesticks are used to describe the trading structure of the day.
	void candleStick() {

		for (int i = lineCtr; i > 0; i--) {

			stick = (((high[i] - low[i]) / 100));
			bottom = low[i] + (stick * 10);
			quarter = low[i] + (stick * 25);
			half = low[i] + (stick * 50);
			sevenFive = low[i] + (stick * 75);
			top = low[i] + (stick * 90);

			if (close[i] < open[i]) // loss or red candle
			{
				if ((open[i] >= sevenFive && open[i] <= high[i]) && (close[i] >= low[i] && close[i] <= quarter))// bearish
				{
					candle[i] = "bearish"; // LOSS
				} 
				else
					candle[i] = "loss";
			}// end of loss or red candle

			else if (close[i] > open[i])// gain or green candle
			{
				if ((close[i] >= sevenFive && close[i] <= high[i]) && (open[i] >= low[i] && open[i] <= quarter))
				{
					candle[i] = "bullish"; // GAIN
				} 
				else
					candle[i] = "gain";
			}// end of gain or green candle

		}

	}// End of candlestick
	
	
// Calculates the Simple Moving Average
	void sma()
	{
		for (int i = 0; i <= lineCtr; i++)
			sma[i]= (close[i]+close[i+1]+close[i+2]+close[i+3]+close[i+4])/5;
	}// End of SMA
	

// This will check for the Three Soldier pattern
	void pattern() {
		for (int i = lineCtr - 14; i >= 0; i--) {
			if (close[i] < open[i])// loss or red candle
			{
				if (((candle[i] == "bearish") && (candle[i + 1] == "bearish") && (candle[i + 2] == "bearish") && (sma[i+13]<sma[i+3])) &&
					(open[i+1]>close[i+2])&&(open[i]>close[i+1]))
				{
					pattern[i] = "DOWN";
					totalDown++;
				}
				else
					pattern[i] = " ";
			} 
			else if (close[i] > open[i])// gain or green candle
			{
				if (((candle[i] == "bullish") && (candle[i + 1] == "bullish") && (candle[i + 2] == "bullish") && (sma[i+13]>sma[i+3])) &&
						(open[i+1]<close[i+2])&&(open[i]<close[i+1]))
				{
					pattern[i] = "UP";
					totalUp++;
				}
					
				else
					pattern[i] = " ";
			}

		}
	}// End of Pattern
	
	
	
//Checks the prediction at 4, 5, 7, and 10 days after the three soldier pattern is present
	void verify(){
		// Four day check
				for (int i = 5; i < lineCtr; i++){
					if ((pattern[i]=="UP") && (open[i-1]<open[i-5])||(pattern[i]=="DOWN") && (open[i-1]>open[i-5]))
					{
						four[i-5]="Correct";
						correct4++;
					}
					else if ((pattern[i]=="UP") && (open[i-1]>open[i-5])||(pattern[i]=="DOWN") && (open[i-1]<open[i-5]))
					{
						four[i-5]="Wrong";
						wrong4++;
					}
					else
						four[i-5]=" ";
				}
				
		// Five day check
		for (int i = 6; i < lineCtr; i++){
			if ((pattern[i]=="UP") && (open[i-1]<open[i-6])||(pattern[i]=="DOWN") && (open[i-1]>open[i-6]))
			{
				five[i-6]="Correct";
				correct5++;
			}
			else if ((pattern[i]=="UP") && (open[i-1]>open[i-6])||(pattern[i]=="DOWN") && (open[i-1]<open[i-6]))
			{
				five[i-6]="Wrong";
				wrong5++;
			}
			else
				five[i-6]=" ";
		}
		
		// Seven day check
		for (int i = 8; i < lineCtr; i++){
			if ((pattern[i]=="UP") && (open[i-1]<open[i-8])||(pattern[i]=="DOWN") && (open[i-1]>open[i-8]))
			{
				seven[i-8]="Correct";
				correct7++;
			}
			else if ((pattern[i]=="UP") && (open[i-1]>open[i-8])||(pattern[i]=="DOWN") && (open[i-1]<open[i-8]))
			{
				seven[i-8]="Wrong";
				wrong7++;
			}
			else
				seven[i-8]=" ";
		}
		
		// Ten day check
		for (int i = 11; i < lineCtr; i++){
			if ((pattern[i]=="UP") && (open[i-1]<open[i-11])||(pattern[i]=="DOWN") && (open[i-1]>open[i-11]))
			{
				ten[i-11]="Correct";
				correct10++;
			}
			else if ((pattern[i]=="UP") && (open[i-1]>open[i-11])||(pattern[i]=="DOWN") && (open[i-1]<open[i-11]))
			{
				ten[i-11]="Wrong";
				wrong10++;
			}
			else
				ten[i-11]=" ";
		}
	}//end of verify
	
	
	void printResults() throws FileNotFoundException, IOException {

        {
        	pct4 = ((double) correct4 / (correct4 + wrong4)) * 100;
            pct5 = ((double) correct5 / (correct5 + wrong5)) * 100;
            pct7 = ((double) correct7 / (correct7 + wrong7)) * 100;
            pct10 = ((double) correct10 / (correct10 + wrong10)) * 100;
        
            String path = "/Users/anastassiyaneznanova/Desktop/results4.csv";

            // creating file object from given path
            File file3 = new File(path);
            if (!file3.exists()) 
            {
                file3.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file3, true);

            BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
//            fileWriter.append(" " + "," + "4 Day %" + "," +"5 Day %" + "," + "7 Day %" + "," + "10 Day %" + "\n");
            fileWriter.append(file + "," + pct4 + "," +pct5 + "," + pct7 + "," + pct10 + "\n");

            bufferFileWriter.close();

        }

    }//End of printResults

	
	
	
	void printSheet() throws FileNotFoundException, IOException {
		String path = "/Users/anastassiyaneznanova/Desktop/" + file + "out.csv";

		FileWriter NewFile = new FileWriter(path);
		NewFile.append("DATE" + "," + "OPEN" + "," + "HIGH" + "," + "LOW" + ","
				+ "CLOSE" + "," + "SMA" + "," + "CANDLE" + "," + "PATTERN" + "," + "FOUR" + ","  + "FIVE" + "," + "SEVEN" + "," + "TEN" + "\n");
		for (int i = 0; i <= lineCtr; i++) {
			NewFile.append(date[i] + "," + open[i] + "," + high[i] + ","
					+ low[i] + "," + close[i] + "," + sma[i] + "," + candle[i] + ","
					+ pattern[i] + ","+ four[i] + ","+ five[i] + "," + seven[i] + "," + ten[i] + "\n");
		}

	}// End of PrintSheet

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
//		TS d00 = new TS("IBM");
		TS d01 = new TS("google");
		//TS d02 = new TS("YAHOO");
		//TS d03 = new TS("GM");
		//TS d04 = new TS("BOEING");
		//TS d05 = new TS("FORD");
		//TS d3=new TS("AAPL");
		//TS d31=new TS("AKS");
//		TS d32=new TS("AMZN"); 
//		TS d34=new TS("BA");
//		TS d35=new TS("BAC"); 
//		TS d36=new TS("BK"); 
//		TS d37=new TS("BP"); 
//		TS d39=new TS("C");
//		TS d311=new TS("CAT");
//		TS d312=new TS("CSCO");
//		TS d313=new TS("DAL");
//		TS d314=new TS("DGL");
//		TS d319=new TS("EWZ"); 
//		//TS d323=new TS("FXE");
//		TS d326=new TS("GILD");
//		//TS d327=new TS("GLW"); 
//		//TS d329=new TS("HFU");
//		TS d330=new TS("HL");
//		TS d331=new TS("IAU");
//		TS d332=new TS("MAS");
//		TS d333=new TS("MMM");
//		TS d335=new TS("NVDA");
//		TS d336=new TS("PAAS");
//		TS d337=new TS("PCG");
//		TS d338=new TS("POT"); 
//		TS d339=new TS("SH");
//		TS d40=new TS("SHLD");
//		TS d41=new TS("SLV");
//		TS d340=new TS("SLW");
//		TS d341=new TS("TLT");
//		//TS d343=new TS("UNG");
//		TS d347=new TS("VLO"); 
//		TS d348=new TS("WY"); 
//		TS d349=new TS("X"); 
//		TS d350=new TS("XLF"); 
//		TS d351=new TS("XOM");
		

		System.out.println("Process Complete!!");
		System.out.println("Four day correct: " + correct4 + " // Four day wrong: " + wrong4);
		System.out.println("Five day correct: " + correct5 + " // Five day wrong: " + wrong5);
		System.out.println("Seven day correct: " + correct7 + " // Seven day wrong: " + wrong7);
		System.out.println("Ten day correct: " + correct10 + " // Ten day wrong: " + wrong10);
		
		String path = "/Users/anastassiyaneznanova/Desktop/results3.csv";

        // creating file object from given path
        File file3 = new File(path);
        FileWriter fileWriter = new FileWriter(file3, true);
        BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
        double pct4 = Math.round((double) correct4 / (correct4 + wrong4) * 100 * 100.0) / 100.0;
        double pct5 = Math.round((double) correct5 / (correct5 + wrong5) * 100 * 100.0) / 100.0;
        double pct7 = Math.round((double) correct7 / (correct7 + wrong7) * 100 * 100.0) / 100.0;
        double pct10 = Math.round((double) correct10 / (correct10 + wrong10) * 100 * 100.0) / 100.0;
       
//        fileWriter.append(" " + "," + "4 Day Correct" + "," + "4 Day Wrong" + "," + "Win %" + "," + "5 Day Correct" + "," + "5 Day Wrong" + "," + "Win %" + "," +
//        					"7 Day Correct" + "," + "7 Day Wrong" + "," + "Win %" + "," +"10 Day Correct" + "," + "10 Day Wrong" + "," + "Win %" + "," + "\n");
        fileWriter.append("Totals: " + "," + correct4 + "," + wrong4 + "," + pct4);
        fileWriter.append("," + correct5 + "," + wrong5 + "," + pct5);
        fileWriter.append("," + correct7 + "," + wrong7 + "," + pct7);
        fileWriter.append("," + correct10 + "," + wrong10 + "," + pct10 + "\n");
        bufferFileWriter.close();
	}

}
