package com.javaservices;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class JavaFXBrowser extends Application {

    @Override
	public void start(Stage stage) {
		// create the scene
		stage.setTitle("Web View");
        Scene scene = new Scene(new Browser(), 750, 500, Color.web("#666970"));
		stage.setScene(scene);
		stage.show();
	}

	public static void openBrowser() {
		launch();
	}

	@Override
	public void stop() {
		System.exit(3);
	}
}

class Browser extends Region {

	final WebView webView = new WebView();
	final WebEngine webEngine = webView.getEngine();

	public Browser() {
		// apply the styles
		getStyleClass().add("browser");
		// load the web page
		webEngine.load("http://localhost:8080/index.xhtml");
		// add the web view to the scene
		getChildren().add(webView);

	}

	@Override
	protected void layoutChildren() {
		double w = getWidth();
		double h = getHeight();
		layoutInArea(webView, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
	}

	@Override
	protected double computePrefWidth(double height) {
		return 750;
	}

	@Override
	protected double computePrefHeight(double width) {
		return 500;
	}
}