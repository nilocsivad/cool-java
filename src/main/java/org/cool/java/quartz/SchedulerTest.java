/**
 * 
 */
package org.cool.java.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Colin
 * 		
 */
public class SchedulerTest {
	
	public static final DateFormat FMT_DEFAULT = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	
	
	/**
	 * 
	 */
	public SchedulerTest() {}
	
	@Test
	public void run() throws Exception {
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		
		JobDetail job = JobBuilder.newJob( CallerJob.class ).withIdentity( "callerID1", "group" ).build();
		
		// SimpleScheduleBuilder sch = SimpleScheduleBuilder.repeatMinutelyForever( 1 ).withRepeatCount( 3 );
		SimpleScheduleBuilder sch = SimpleScheduleBuilder.repeatSecondlyForever( 10 ).withRepeatCount( 3 );
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity( "simpleTrigger", "triggerGroup" ).withSchedule( sch ).startNow().build();
		
		scheduler.scheduleJob( job, trigger );
		
		scheduler.start();
	}
	
	
	class CallerJob implements Job {
		
		/* (non-Javadoc)
		 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
		 */
		@Override
		public void execute( JobExecutionContext context ) throws JobExecutionException {
			
			System.out.println( FMT_DEFAULT.format( new Date() ) );
			
		}
		
	}
	
}
