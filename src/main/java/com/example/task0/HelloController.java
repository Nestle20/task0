package com.example.task0;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;

public class HelloController {

    @FXML
    private TextField sumInput;  // Поле для ввода суммы

    @FXML
    private Label resultLabel;   // Метка для отображения результата

    @FXML
    private RadioButton radioButton1;  // Радиокнопка для выбора 9%

    @FXML
    private RadioButton radioButton2; // Радиокнопка для выбора 10%

    @FXML
    private ToggleGroup tipToggleGroup; // Группа радиокнопок

    private Procent procent;     // Объект класса Procent

    // Метод для расчета 15%
    @FXML
    protected void onCalculateBigTip() {
        calculateTip(15);
    }

    // Метод для расчета на основе выбранной радиокнопки
    @FXML
    protected void onCalculateTipWithRadio() {
        // Определяем выбранную радиокнопку
        RadioButton selectedRadio = (RadioButton) tipToggleGroup.getSelectedToggle();
        if (selectedRadio == radioButton1) {
            calculateTip(9);
        } else if (selectedRadio == radioButton2) {
            calculateTip(10);
        }
    }
    @FXML
    public void initialize() {
        tipToggleGroup = new ToggleGroup();
        // Привязка радиокнопок к группе
        radioButton1.setToggleGroup(tipToggleGroup);
        radioButton2.setToggleGroup(tipToggleGroup);
    }


    // Метод для расчета 3%
    @FXML
    protected void onCalculateSmallTip() {
        calculateTip(3);
    }

    // Вспомогательный метод для расчета чаевых и вывода результата
    private void calculateTip(int tipPercentage) {
        try {
            // Получаем сумму чека
            float sum = Float.parseFloat(sumInput.getText());
            procent = new Procent(sum);

            // Вычисляем итоговую сумму и округленное значение
            int finalSum = procent.countSumrnd(tipPercentage);

            // Отображаем результат
            resultLabel.setText("Итоговая сумма: " + finalSum + " рублей");

        } catch (NumberFormatException e) {
            // Выводим ошибку, если введено не число
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Пожалуйста, введите правильную сумму!");
            alert.showAndWait();
        }
    }
}
