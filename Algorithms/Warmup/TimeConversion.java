import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args) throws ParseException
	{
		try (Scanner keyboard = new Scanner(System.in))
		{
			String ampm = keyboard.next();

			SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
			Date date = parseFormat.parse(ampm);
			System.out.println(displayFormat.format(date));
		}
	}
}