package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class utils extends TestBase{
	
	
	public static long PageLoadoutTime = 30;
	public static long ImplicitLoadoutTime = 30;
	
	
	public String CurrentDatePlus() {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm");
		Date currentDate = new Date();
        //System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);


        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        
        String customdate = dateFormat.format(currentDatePlusOne);
        
        
		return customdate;
	}
	
	
}
