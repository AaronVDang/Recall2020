package application.events;

import java.io.File;

import application.DbEventRemover;
import application.DbWriter;
import application.DeleteEventPage;
import application.EventsPage;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteEvent {
	
	private int newNumbOfEvents;
	
	//No-arguments constructor
	public DeleteEvent() {}
	
	//Method takes event title input from delete-event-page window and deletes that event
	//	- deletes desired event card on events-page
	//	- deletes desired event details from database
	public void deleteAnEvent(Stage deleteEventStage, DeleteEventPage deleteEvent, EventsPage eventPage, int eventCount) {
		
		newNumbOfEvents = eventCount;
		
		//
		FlowPane eventsContainer = eventPage.getEventContainer();
		String nameInput = deleteEvent.getEventNameInput().getText();
		Boolean foundEventToBeDeleted = false;
		
		//
		for(int x = 0; x < newNumbOfEvents+1; x++) {
			
			//
			VBox test = (VBox) eventsContainer.getChildren().get(x);
			Label label = (Label) test.getChildren().get(0);
			
			//
			if(nameInput.equals(label.getText())) {
				eventPage.getEventContainer().getChildren().remove(x);
				newNumbOfEvents--;
				
				
				//DATABASE EVENT REMOVAL
				Label label2 = (Label) test.getChildren().get(7);
				String label2Contents = label2.getText();
				int numbIDToLookFor = Integer.parseInt(label2Contents);
				
				DbEventRemover eventRemover = new DbEventRemover();
				eventRemover.deleteEventAndRewriteDb(numbIDToLookFor);
				
				File f = new File("eventsDb", "EventsDb.txt");
				f.delete();
				
				eventRemover.renameDbToOriginal();
				deleteEvent.resetEventNameInputTF();
				
				foundEventToBeDeleted = true;
			}
		}
		
		//
		VBox recallDeleteEventSurfaceStack = deleteEvent.getDeleteEventPageSurfaceStack();
		Node theSecondNode = recallDeleteEventSurfaceStack.getChildren().get(3);
		if(foundEventToBeDeleted == false) {
			
			//
			if(theSecondNode instanceof Label != true) {
				deleteEvent.showInvalidTitleInputErrorMessage();
			}
			deleteEvent.clearAndResetAllFields();
		}
		else {
			
			//
			if(theSecondNode instanceof Label == true) {
				deleteEvent.hideInvalidTitleInputErrorMessage();
			}
			deleteEvent.clearAndResetAllFields();
		}
		
		//
		if(newNumbOfEvents == -1) {
			deleteEventStage.close();
			eventPage.setDeleteEventButtonDisabled(true);
		}
	}
	
	//Method deletes ALL EVENTS
	//	- deletes ALL event cards on events-page
	//	- deletes ALL event details from database
	public void deleteAllEvents(Stage thirdStage, EventsPage eventPage, int eventCount) {
		
		newNumbOfEvents = eventCount;
		
		//
		int numberOfEventsToDelete = newNumbOfEvents;
		while(numberOfEventsToDelete > -1){
			eventPage.getEventContainer().getChildren().remove(numberOfEventsToDelete);
			numberOfEventsToDelete--;
			newNumbOfEvents--;
		}
		
		//
		DbWriter deleteAll = new DbWriter("TRASH");
		deleteAll.resetFile();
		
		//
		if(newNumbOfEvents == -1) {
			thirdStage.close();
			eventPage.setDeleteEventButtonDisabled(true);
		}
	}
	
	//Method returns integer equal to number of events remaining after deleting an event 
	public int getNewNumberOfEvents() {
		return newNumbOfEvents;
	}
}