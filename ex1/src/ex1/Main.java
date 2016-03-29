package ex1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
	public static void main(String[] args) //throws Exception
	{
		try
		{
			long start = new Date().getTime();
			String time = new SimpleDateFormat("HH.mm.ss").format(start);
			System.out.println("Testing...");
			System.out.println("Graph file: " + args[0] + " runing a test " + args[1]);
			String ans = "Solution_" + args[1] + "_" + args[0] + "_" + time + ".txt";

			FileWriter fw = new FileWriter(ans);
			PrintWriter os = new PrintWriter(fw);
			In in = new In(args[0]);
			EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
			long a = new Date().getTime();
			System.out.println("Done loading: " + args[0] + "  in " + (a - start) + "  ms");
			FileReader fr = new FileReader(args[1]);
			BufferedReader is = new BufferedReader(fr);
			String num_of_lines = is.readLine();
			String str = is.readLine();
			int ll = 0;
			os.println(num_of_lines + " Results:");
			while ((str != null) && (ll < 20))
			{
				String[] s = str.split(" ");
				int src = Integer.parseInt(s[0]);
				int t = Integer.parseInt(s[1]);
				int BlackListSize = Integer.parseInt(s[2]);
				int[] BlackList = new int[BlackListSize];
				for (int i = 0; i < BlackListSize; i++) {
					BlackList[i] = Integer.parseInt(s[(i + 3)]);
				}
				double distance = DijkstraSP.sp(G, src, t, BlackList);
				os.println(s + " " + distance);
				ll++;
				s[ll] = is.readLine();
			}
			long b = new Date().getTime();
			System.out.println("Done computing SP on Graph: " + args[0] + "  in " + (b - a) + "  ms");
			System.out.println("Total time: " + (b - start) + "  ms");
			os.close();
			is.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}
