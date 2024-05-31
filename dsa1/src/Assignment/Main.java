package Assignment;
class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }
}

class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ToDoList {
    private Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Task with title '" + title + "' not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println("-------------------------");
            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Adding tasks
        toDoList.addToDo(new Task("Prayer", "Get up early in the morning for prayer and bible studying"));
        toDoList.addToDo(new Task("Journalling", "10 minutes of reflection"));
        toDoList.addToDo(new Task("house chorus", "cleaning the dishes, cook lunch"));

        // Viewing initial to-do list
        System.out.println("Initial To-Do List:");
        toDoList.viewToDoList();

        // Marking a task as completed
        toDoList.markToDoAsCompleted("Prayer");

        // Viewing updated to-do list
        System.out.println("\nUpdated To-Do List:");
        toDoList.viewToDoList();
    }
}