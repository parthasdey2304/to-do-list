import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoList extends Frame implements ActionListener {
    private ArrayList<String> tasks;
    private TextField taskInput;
    private TextArea taskDisplay;

    public ToDoList() {
        super("To-Do List");

        tasks = new ArrayList<String>();

        // Create input field and "Add Task" button
        taskInput = new TextField();
        Button addButton = new Button("Add Task");
        addButton.addActionListener(this);

        // Create display area for tasks
        taskDisplay = new TextArea();
        taskDisplay.setEditable(false);

        // Set up layout for input and display areas
        Panel inputPanel = new Panel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.NORTH);
        add(taskDisplay, BorderLayout.CENTER);

        // Set up window size and visibility
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoList();
    }

    public void actionPerformed(ActionEvent e) {
        String task = taskInput.getText();
        tasks.add(task);
        taskInput.setText("");
        taskDisplay.setText("");
        for (String t : tasks) {
            taskDisplay.append(t + "\n");
        }
    }
}
