/*
* File: MainController.java
* Author: Berta Péter
* Copyright: 2025, Berta Péter
* Group: Szoft II-2-N
* Date: 2025-04-09
* Github: https://github.com/bp-ter/
* Licenc: MIT
*/

package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField areaField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField radiusField;

    @FXML
    private ListView<String> resultList;

    @FXML
    void onClickCalcButton(ActionEvent event) {
        startCalc();
    }

    @FXML
    void startCalc(){
        String radius = radiusField.getText();
        String height = heightField.getText();

        if (radius.isEmpty() || height.isEmpty()) {
            System.out.println("Please enter both radius and height.");
            return;
        }

        Double r = Double.parseDouble(radius);
        Double h = Double.parseDouble(height);
        Double a = 2 * Math.PI * r * (r + h);
        resultList.getItems().add("Area: " + a);
        areaField.setText(String.valueOf(a));

        
        Result result = new Result(String.valueOf(a));
        Store.saveResults(result.area);
    }
}
