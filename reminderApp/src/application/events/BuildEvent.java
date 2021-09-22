package application.events;

import application.AddEventPage;
import application.DbWriter;
import application.DetailedEventPage;
import application.Event;
import application.EventsPage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class BuildEvent {
	
	private int newNumbOfEvents;
	
	//No-arguments constructor
	public BuildEvent() {}
	
	//Method takes inputs from add-event-page window and creates a new event
	//	- creates new event card on events-page
	//	- adds event details to database
	public void buildAnEvent(AddEventPage addEvent, EventsPage eventPage, int eventCount, BorderPane eventPageContainer, Scene homeScene) {
		
		newNumbOfEvents = eventCount;
		
		//Capture details about new event from add-event window
		int eventID = Integer.MIN_VALUE + eventCount + 1;
		String name = addEvent.getEventName();
		String desc= addEvent.getEventDesc();
		
		String classif = addEvent.getEventClass();
		String otherClassif = addEvent.getEventClassOther();
		
		String locate = addEvent.getEventLocation();
		String month = addEvent.getEventMonth();
		String day = addEvent.getEventDay();
		String year = addEvent.getEventYear();
		Boolean noDate = addEvent.getNoDateOption();
		String time = addEvent.getEventTime();
		String AMPM = addEvent.getEventAMPM();
		
		
		Event anEvent;
		
		//Write details from add-event window to database then create new event
		//This "If Else" logic handles two scenarios:
		//		1. classification = preset
		//		2. classification = other
		//
		//Write details from add-event window to database IF CLASSIFICATION IS MANUALLY INPUT
		if(classif.contentEquals("Other")) {
			if(noDate == true && time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + otherClassif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, otherClassif, locate, null, null, null, null, null, eventID);
				
			}
			else if(noDate == true) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + otherClassif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
				
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, otherClassif, locate, null, null, null, time, AMPM, eventID);
				
			}
			else if(time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + otherClassif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, otherClassif, locate, month, day, year, null, null, eventID);
				
			}
			else {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + otherClassif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, otherClassif, locate, month, day, year, time, AMPM, eventID);
			}
		}
		//Write details from add-event window to database IF CLASSIFICATION IS MANUALLY INPUT
		else if(classif.contentEquals("None")) {
			if(noDate == true && time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, null, locate, null, null, null, null, null, eventID);
				
			}
			else if(noDate == true) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
				
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, null, locate, null, null, null, time, AMPM, eventID);
				
			}
			else if(time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, null, locate, month, day, year, null, null, eventID);
				
			}
			else {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, null, locate, month, day, year, time, AMPM, eventID);
			}
		}
		//Write details from add-event window to database IF CLASSIFICATION IS A PRESET OPTION
		else {
			if(noDate == true && time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + classif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, classif, locate, null, null, null, null, null, eventID);
				
			}
			else if(noDate == true) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + classif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
				
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, classif, locate, null, null, null, time, AMPM, eventID);
				
			}
			else if(time.contentEquals("None")) {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + classif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " +
						 "\n" + eventID + " ");
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, classif, locate, month, day, year, null, null, eventID);
				
			}
			else {
				
				DbWriter dbWriter = new DbWriter();
				dbWriter.writeToFile(
								eventID + " " + name +
						 "\n" + eventID + " " + desc +
						 "\n" + eventID + " " + classif +
						 "\n" + eventID + " " + locate +
						 "\n" + eventID + " " + month +
						 "\n" + eventID + " " + day +
						 "\n" + eventID + " " + year +
						 "\n" + eventID + " " + time +
						 "\n" + eventID + " " + AMPM);
				dbWriter.closeWriter();
			
				//Create new Event from details captured from add-event-window
				anEvent = new Event(name, desc, classif, locate, month, day, year, time, AMPM, eventID);
			}
		}
		
		if(classif.contentEquals("None")) {
			anEvent.setClassif(null);
			//anEvent.setClassif("No Classification");
		}
		
		//We are creating a new event, so we increment the event counter
		newNumbOfEvents = newNumbOfEvents + 1;
		
		//Enable delete event button on events-page if disabled
		//(this button is disabled if no events on events-page, once an event is added, the button is re-enabled)
		if(eventPage.getDeleteEventBtn().isDisabled() == true)
			eventPage.setDeleteEventButtonDisabled(false);
		
		
		//Create GUI card on events-page to display new event to the user
		VBox card = new VBox();
		card.setAlignment(Pos.CENTER);
		card.setPadding(new Insets(0, 10, 10, 10));
		card.getStyleClass().add("event-card");
		card.setPrefSize(250, 250);
		
		
		//Create new JavaFX elements (Labels) to display event details on GUI card
		Label theName = new Label(anEvent.getName());
		Label theDesc = new Label(anEvent.getDesc());
		Label theClassif = new Label(anEvent.getClassif());
		Label theLocate = new Label(anEvent.getLocate());
		Label theDate = new Label(anEvent.getMonth() + " " + anEvent.getDay() + ", " + anEvent.getYear());
		Label theTime = new Label(anEvent.getTime() + " " + anEvent.getAMPM());
		Label theID = new Label(Integer.toString(anEvent.getID()));
		Label spacer = new Label(" ");
		
		//Style and add tool tips to the Labels
		if(anEvent.getDesc().length() > 24) {
			String tooltipDesc = anEvent.getDesc().substring(0, 24) + "...";
			Tooltip eventCardTooltip = new Tooltip(
					"Title: " + anEvent.getName() + "\n" +
					"Classification: " + anEvent.getClassif() + "\n" +
					"Description: " + tooltipDesc + "\n" +
					"Location: " + anEvent.getLocate() + "\n" +
					"Date: " + anEvent.getMonth() + " " + anEvent.getDay() + ", " + anEvent.getYear() + "\n" +
					"Time: " + anEvent.getTime() + " " + anEvent.getAMPM()
			);
			eventCardTooltip.getStyleClass().add("tool-tip");
			theName.setTooltip(eventCardTooltip);
		}
		else {
			Tooltip eventCardTooltip = new Tooltip(
					"Title: " + anEvent.getName() + "\n" +
					"Classification: " + anEvent.getClassif() + "\n" +
					"Description: " + anEvent.getDesc() + "\n" +
					"Location: " + anEvent.getLocate() + "\n" +
					"Date: " + anEvent.getMonth() + " " + anEvent.getDay() + ", " + anEvent.getYear() + "\n" +
					"Time: " + anEvent.getTime() + " " + anEvent.getAMPM()
			);
			eventCardTooltip.getStyleClass().add("tool-tip");
			theName.setTooltip(eventCardTooltip);
		}
		theID.getStyleClass().add("hidden-id");
		theName.setWrapText(true);
		theName.setTextAlignment(TextAlignment.CENTER);
		theName.getStyleClass().add("event-card-title");
		theDesc.setWrapText(true);
		theDesc.getStyleClass().add("hidden-id");
		theClassif.setWrapText(true);
		theClassif.setTextAlignment(TextAlignment.CENTER);
		theLocate.setWrapText(true);
		theLocate.getStyleClass().add("hidden-id");
		theDate.setWrapText(true);
		theTime.setWrapText(true);
		theID.setWrapText(true);
		
		//Build effects
		Glow glowEffect = new Glow();
		
		//Add effects to labels
		theName.setEffect(glowEffect);
		
		//Add elements to GUI card
		if(theDate.getText().contentEquals("null null, null") && theTime.getText().contentEquals("null null")) {
			theDate.getStyleClass().add("hidden-id");
			theTime.getStyleClass().add("hidden-id");
		}
		else if(theDate.getText().contentEquals("null null, null")) {
			theDate.getStyleClass().add("hidden-id");
		}
		else if(theTime.getText().contentEquals("null null")) {
			theTime.getStyleClass().add("hidden-id");
		}
		card.getChildren().addAll(theName, spacer, theDesc, theClassif, theLocate, theDate, theTime, theID);
		
		//Add event handling to GUI card, which takes the user to detailed-event page for that specific GUI card
		DetailedEventPage detailedEventPage = new DetailedEventPage();
		detailedEventPage.Build(card, eventPage, eventPageContainer, homeScene);
		
		
		//Add GUI card to events-page
		eventPage.getEventContainer().getChildren().add(card);
		
		//Clear input fields in add-event window
		addEvent.clearEventName();
		addEvent.clearEventDesc();
		addEvent.clearEventLocation();
		addEvent.clearEventDay();
		addEvent.clearEventYear();
		addEvent.clearEventClassOther();
		addEvent.resetEventClass();
		addEvent.resetEventMonth();
		addEvent.resetEventTime();
		addEvent.resetNoDateOption();
		addEvent.resetEventTimeAMPM();
	}
	
	//Method returns integer equal to number of events added 
	public int getNewNumberOfEvents() {
		return newNumbOfEvents;
	}
}