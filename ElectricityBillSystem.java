import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectricityBillSystem extends Frame implements ActionListener {
    private TextField nameField, unitsField, billAmountField;
    private Button calculateButton;

    public ElectricityBillSystem() {
        Label nameLabel = new Label("Consumer Name:");
        Label unitsLabel = new Label("Units Consumed:");
        Label billAmountLabel = new Label("Bill Amount:");

        nameField = new TextField();
        unitsField = new TextField();
        billAmountField = new TextField();
        billAmountField.setEditable(false);

        calculateButton = new Button("Calculate Bill");

        setLayout(new GridLayout(4, 2));

        add(nameLabel);
        add(nameField);
        add(unitsLabel);
        add(unitsField);
        add(billAmountLabel);
        add(billAmountField);
        add(new Label());
        add(calculateButton);

        calculateButton.addActionListener(this);

        setTitle("Electricity Bill System");
        setSize(300, 150);
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateBill();
        }
    }

    private void calculateBill() {
        try {
            String consumerName = nameField.getText();
            double unitsConsumed = Double.parseDouble(unitsField.getText());

            double ratePerUnit = 8.0; // Change this rate based on your electricity provider

            double billAmount = unitsConsumed * ratePerUnit;

            billAmountField.setText(String.valueOf(billAmount));
        } catch (NumberFormatException ex) {
            billAmountField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new ElectricityBillSystem();
    }
}
