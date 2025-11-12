package lab_A1;

import java.util.Scanner;
import java.util.Locale;
import static java.lang.System.out;

public class lab1pt2 {

	// input tool
    public static Scanner in = null;

    public static void main(String[] args) {
        out.println("TEMPERATURES\n");

        // create the input tool
        in = new Scanner(System.in);
        in.useLocale(Locale.US); // use . for decimals (e.g. 18.5)

        // enter the number of weeks and measurements
        out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();

        // storage space for temperature data (1-based indexing)
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

        // read the temperatures
        for (int week = 1; week <= nofWeeks; week++) {
            out.println("temperatures - week " + week + ":");
            read(t[week]);
        }
        out.println();

        // show the temperatures
        out.println("the temperatures");
        for (int week = 1; week <= nofWeeks; week++) {
            print(t[week]);
        }
        out.println();

        // the least, greatest and average temperatures - weekly
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];

        for (int week = 1; week <= nofWeeks; week++) {
            minT[week] = min(t[week]); // <-- code added
            maxT[week] = max(t[week]); // <-- code added
            sumT[week] = sum(t[week]); // <-- code added
            avgT[week] = sumT[week] / nofMeasurementsPerWeek; // <-- code added
        }

        // show the least, greatest and average temperatures - weekly
        out.println("the least, greatest and average temperatures - weekly");
        print(minT);
        print(maxT);
        print(avgT);
        out.println();

        // the least, greatest and average temperatures - whole period
        double minTemp = min(minT); // <-- code added
        double maxTemp = max(maxT); // <-- code added
        double sumTemp = sum(sumT); // <-- code added
        double avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek); // <-- code added

        // show the least, greatest and average temperature for the whole period
        out.println("the least, greatest and average temperature - whole period");
        out.println(minTemp + "\n" + maxTemp + "\n" + avgTemp);
    }

    // read reads the temperatures and stores them in a specified array.
    // The temperatures are stored from index 1, inclusive.
    public static void read(double[] temp) {
        if (temp.length < 2) {
            out.println("Error: not enough space for temperatures."); // <-- code added
            return; // <-- code added
        }
        for (int i = 1; i < temp.length; i++) {
            temp[i] = in.nextDouble(); // <-- code added
        }
    }

    // print displays the temperatures in a specified array.
    public static void print(double[] temp) {
        if (temp.length < 2) {
            out.println("Error: no temperatures to print."); // <-- code added
            return; // <-- code added
        }
        for (int i = 1; i < temp.length - 1; i++)
            out.print(temp[i] + " ");
        out.println(temp[temp.length - 1]);
    }

    // min returns the least temperature in a specified array.
    public static double min(double[] temp) {
        if (temp.length < 2) {
            out.println("Error: no temperatures to find min."); // <-- code added
            return 0; // <-- code added
        }
        double m = temp[1]; // <-- code added
        for (int i = 2; i < temp.length; i++) { // <-- code added
            if (temp[i] < m) // <-- code added
                m = temp[i]; // <-- code added
        }
        return m; // <-- code added
    }

    // max returns the greatest temperature in a specified array.
    public static double max(double[] temp) {
        if (temp.length < 2) {
            out.println("Error: no temperatures to find max."); // <-- code added
            return 0; // <-- code added
        }
        double m = temp[1]; // <-- code added
        for (int i = 2; i < temp.length; i++) { // <-- code added
            if (temp[i] > m) // <-- code added
                m = temp[i]; // <-- code added
        }
        return m; // <-- code added
    }

    // sum returns the sum of the temperatures in a specified array.
    public static double sum(double[] temp) {
        if (temp.length < 2)
            return 0.0; // <-- code added
        double s = 0.0; // <-- code added
        for (int i = 1; i < temp.length; i++) // <-- code added
            s += temp[i]; // <-- code added
        return s; // <-- code added
    }
}
	