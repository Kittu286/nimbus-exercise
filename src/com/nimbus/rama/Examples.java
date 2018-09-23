package com.nimbus.rama;

public class Examples {
	
	/*{@code Config} is a core execution capability provided by the
	framework. The annotation is used to execute {@code CommandMessage}
	objects built from a provided Command DSL URLs, executed from the context
	of the param represented by the decorated field.*/
	
	//A class with @Config annotation is used to perform an action on button click. 
	//In most cases, the action is to retrieve values via HTTP Rest calls from database (MongoDB), 
	//and display on the web page.
	
	@Config(url="/pageAddEditGoal/tileEditGoal/sectionEditGoal/goalDetailsForm/_nav?pageId=pageCarePlanSummary")
	@Button(type = Button.Type.PLAIN)
	private String cancel;
	
	@Configs({
        @Config(url="/p/ownerview/_new")
   })
   @Button(imgSrc = "add.svg", cssClass ="btn btn-icon green")
   private String addOwner;
	
	
	//Domain is used to tell a record to be inserted or updated
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value=ElementType.TYPE)
	@Model
	public @interface Domain {

		String value();
		
		String lifecycle() default "";
		
		ListenerType[] includeListeners() default { };
		
		
		//Not able to understand what is websocket here
		enum ListenerType {
			none,
			websocket,
			persistence,
			update
			
		}
	}

	
	
	//@Repo is used to determine where the data will be persisted. It is always used along with @Domain.
	//The possible enum values for value are DATABASE.rep_none, DATABASE.rep_rdbms, DATABASE.rep_mongodb, DATABASE.rep_ws
	@Domain(value="cmassessment", includeListeners={ListenerType.persistence})
	@Repo(alias="cmassessment",value=Database.rep_mongodb, cache=Cache.rep_device)
	@Getter @Setter
	public class CMAssessment extends IdString {
	}
	
	//@Getter @Setter - these are lombok project annotations for getter and setter methods
	
	
	
	
	
	
	

}
