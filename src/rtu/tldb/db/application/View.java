package rtu.tldb.db.application;

import java.math.BigDecimal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import rtu.tldb.db.application.entities.PilotTable;

public class View extends BorderPane {
	
	public static final String PILOT_TABLE_LABEL = "Pilots registered:";
	public static final String PILOT_FORM_LABEL = "Pilot registration form:";
	public static final String WAY_CALCULATE_LABEL = "Input for calculate way:";
	public static final String TITLE = "Flight Plan Domain Application";
	public static final String EMPTY = "";
	
	private Label pilotIdLabel;
	private TextField pilotId;
	private Label pilotNameLabel;
	private TextField pilotName;
	private Label pilotSurnameLabel;
	private TextField pilotSurname;
	private Label pilotAgeLabel;
	private TextField pilotAge;
	private Label pilotLevelLabel;
	private ComboBox<String> pilotLevel;
	
	private Label callsignLabel;
	private ComboBox<String> callsign;
	
	TableView<PilotTable> table;
	
	RetrieveData retrieve = new RetrieveData();
	InsertData insert = new InsertData();
	CallProcedure call = new CallProcedure();
	
	Alert alertDialog;
	
	public View() {
		createMainPane();
	}
	
	public void createMainPane() {
		
		ObservableList<PilotTable> listFlightPlan = retrieve.retrievePilots();
		
        this.setCenter(createCenterPane(listFlightPlan));
        this.setTop(createTopPane());
        this.setRight(createRightPane());
        this.setBottom(createBottomPane());
		
	}

	private Node createBottomPane() {
		Button btnInsert = new Button("Insert New Pilot");
		btnInsert.setPadding(new Insets(5,5,5,5));
		btnInsert.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				PilotTable pilotRegister = getPilotInfo();
				if(pilotRegister != null) {
					insertNewData(pilotRegister);
				}
				cleanFields();
			}

			private void insertNewData(PilotTable pilotRegister) {
				insert.insertNewPilot(pilotRegister);
				updateTable();
				alertDialog = new Alert(AlertType.INFORMATION, "New registration succeded", ButtonType.OK);
				alertDialog.showAndWait();
			}
		});
		
		Button btnCalculateWayLength = new Button("Calculate Way Length");
		btnCalculateWayLength.setPadding(new Insets(5,5,5,5));
		btnCalculateWayLength.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(!callsign.getSelectionModel().isEmpty()) {
					int wayLength = call.callCalculateWay(callsign.getSelectionModel().getSelectedItem());
					String wayLengthInfo = String.format("Flight Plan with Callsign %s will fly for %d NM", callsign.getSelectionModel().getSelectedItem(), wayLength);
					alertDialog = new Alert(AlertType.INFORMATION, wayLengthInfo, ButtonType.OK);
					alertDialog.showAndWait();
				} else {
					alertDialog = new Alert(AlertType.ERROR, "No Callsign Selected", ButtonType.OK);
					alertDialog.showAndWait();
				}
				
			}
		});
		
		GridPane pane = new GridPane();
		pane.add(btnInsert, 0, 0);
		pane.add(btnCalculateWayLength, 1, 0);
		pane.setPadding(new Insets(5,5,5,5));
	    pane.setAlignment(Pos.TOP_CENTER);
	    
	    return pane;
	}

	protected void cleanFields() {
		pilotId.clear();
		pilotName.clear();
		pilotSurname.clear();
		pilotAge.clear();		
	}

	protected void updateTable() {
		table.setItems(retrieve.retrievePilots());
		table.getColumns().get(0).setSortType(TableColumn.SortType.ASCENDING);
		table.getSortOrder().add(table.getColumns().get(0));
		table.sort();
	}

	protected PilotTable getPilotInfo() {
		
		PilotTable pilot = new PilotTable();
		
		try {
			pilot.setPilotId(Integer.valueOf(pilotId.getText()));
			pilot.setPilotName(pilotName.getText());
			pilot.setPilotSurname(pilotSurname.getText());
			pilot.setPilotAge(BigDecimal.valueOf(Double.valueOf(pilotAge.getText())));
			pilot.setPilotLevel(pilotLevel.getSelectionModel().getSelectedItem());
		} catch (Exception e) {
			alertDialog = new Alert(AlertType.ERROR, "Error in the data insertion", ButtonType.OK);
			alertDialog.showAndWait();
			return null;
		}
		
		return pilot;
		
	}

	private Node createRightPane() {
		Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
		
		Label labelInsertion = new Label(PILOT_FORM_LABEL);
	    labelInsertion.setFont(font);
	    labelInsertion.setPadding(new Insets(5,5,5,5));
	    
	    pilotIdLabel = new Label("Pilot ID: ");
	    pilotNameLabel = new Label("Name: ");
	    pilotSurnameLabel = new Label("Surname: ");
	    pilotAgeLabel = new Label("Age: ");
	    pilotLevelLabel = new Label("Level: ");
	    
	    pilotId = new TextField();
	    pilotName = new TextField();
	    pilotSurname = new TextField();
	    pilotAge = new TextField();
	    
	    ObservableList<String> levelOptions = 
	    	    FXCollections.observableArrayList(
	    	        "Beginner",
	    	        "Intermediate",
	    	        "Experient"
	    	    );
	    
	    pilotLevel = new ComboBox<String>(levelOptions);
	    
	    Label labelCalculate = new Label(WAY_CALCULATE_LABEL);
	    labelCalculate.setFont(font);
	    labelCalculate.setPadding(new Insets(5,5,5,5));
	    
	    callsignLabel = new Label("Callsign: ");
	    
	    ObservableList<String> callsignOptions = retrieve.retrieveFPCallsigns();
	    
	    callsign = new ComboBox<String>(callsignOptions);
	    
	    GridPane pane = new GridPane();
	    
	    pane.add(labelInsertion, 1, 0);
	    pane.add(pilotIdLabel, 1, 2);
	    pane.add(pilotId, 2, 2);
	    pane.add(pilotNameLabel, 1, 3);
	    pane.add(pilotName, 2, 3);
	    pane.add(pilotSurnameLabel, 1, 4);
	    pane.add(pilotSurname, 2, 4);
	    pane.add(pilotAgeLabel, 1, 5);
	    pane.add(pilotAge, 2, 5);
	    pane.add(pilotLevelLabel, 1, 6);
	    pane.add(pilotLevel, 2, 6);
	    pane.add(labelCalculate, 1, 7);
	    pane.add(callsignLabel, 1, 8);
	    pane.add(callsign, 2, 8);
	    pane.setPadding(new Insets(5,5,5,5));
	    pane.setAlignment(Pos.TOP_CENTER);
	    
	    return pane;
	    
	}

	private Node createTopPane() {
		Label label = new Label(TITLE);
	    Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18);
	    label.setFont(font);
	    
	    GridPane pane = new GridPane();
	    pane.add(label, 0, 0);
	    pane.setPadding(new Insets(5,5,5,5));
	    pane.setAlignment(Pos.TOP_CENTER);
	    
	    return pane;
	    
	}

	private Node createCenterPane(ObservableList<PilotTable> listFlightPlan) {
		
		table = new TableView<PilotTable>();
		
		Label label = new Label(PILOT_TABLE_LABEL);
	    Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
	    label.setFont(font);
	    
	    Label empty = new Label(EMPTY);
		
		TableColumn flightPlanId = new TableColumn("ID");
		flightPlanId.setCellValueFactory(new PropertyValueFactory<>("pilotId"));
		TableColumn callsign = new TableColumn("Name");
		callsign.setCellValueFactory(new PropertyValueFactory("pilotName"));
		TableColumn ades = new TableColumn("Surname");
		ades.setCellValueFactory(new PropertyValueFactory("pilotSurname"));
		TableColumn adep = new TableColumn("Age");
		adep.setCellValueFactory(new PropertyValueFactory("pilotAge"));
		TableColumn eobt = new TableColumn("Level");
		eobt.setCellValueFactory(new PropertyValueFactory("pilotLevel"));
		
		table.setItems(listFlightPlan);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	    table.getColumns().addAll(flightPlanId, callsign, ades, adep, eobt);
	    
	    table.setMaxSize(400, 200);
	    
	    GridPane pane = new GridPane();
	    pane.add(label, 0, 0);
	    pane.add(empty, 0, 1);
	    pane.add(table, 0, 2);
	    pane.setPadding(new Insets(5,5,5,5));
	    pane.setAlignment(Pos.TOP_CENTER);
	    
		return pane;
	}

}
