package org.dnyanyog.application;




import org.dnyanyog.addpatient.AddPatient;
import org.dnyanyog.addusers.AddUser;
import org.dnyanyog.dashboard.Dashboard;
import org.dnyanyog.deletePatient.DeletePatient;
import org.dnyanyog.deleteappointment.DeleteAppointment;
import org.dnyanyog.deletecase.DeleteCase;
import org.dnyanyog.login.Login;
import org.dnyanyog.stage.StageMaster;
import org.dnyanyog.updateappointment.UpdateAppointment;
import org.dnyanyog.updatecases.UpdateCases;
import org.dnyanyog.updatepatient.UpdatePatient;
import org.dnyanyog.users.Users;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		StageMaster.setStage(primaryStage);
		new DeletePatient().show();
	
	}
}