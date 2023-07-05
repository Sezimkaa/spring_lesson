
    import java.util.ArrayList;
            import java.util.List;
            import java.util.Scanner;

public class TaskManager1 {
    private List<Task1> tasks;
    private Scanner scanner;

    public TaskManager1() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println(" Task Manager ");
            System.out.println("1. Создать задачу");
            System.out.println("2. Просмотреть список задач");
            System.out.println("3. Редактировать задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Отметить задачу как выполненную");
            System.out.println("6. Установить статус задачи");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение символа новой строки после ввода числа

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    markTaskAsDone();
                    break;
                case 6:
                    setTaskStatus();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }

            System.out.println();
        }
    }

    private void createTask() {
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.print("Введите дату выполнения задачи: ");
        String dueDate = scanner.nextLine();
        System.out.print("Введите приоритет задачи (1 - Низкий, 2 - Средний, 3 - Высокий): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        Task1 task = new Task1(title, description, dueDate, priority);
        tasks.add(task);
        System.out.println("Задача успешно создана.");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Индекс: " + i);
                System.out.println(tasks.get(i));
            }
        }
    }

    private void editTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего редактировать.");
            return;
        }

        System.out.print("Введите индекс задачи для редактирования: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }

        Task1 task = tasks.get(index);
        System.out.print("Введите новое название задачи: ");
        String newTitle = scanner.nextLine();
        System.out.print("Введите новое описание задачи: ");
        String newDescription = scanner.nextLine();
        System.out.print("Введите новую дату выполнения задачи: ");
        String newDueDate = scanner.nextLine();
        System.out.print("Введите новый приоритет задачи (1 - Низкий, 2 - Средний, 3 - Высокий): ");
        int newPriority = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setDueDate(newDueDate);
        task.setPriority(newPriority);
        System.out.println("Задача успешно отредактирована.");
    }

    private void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего удалять.");
            return;
        }

        System.out.print("Введите индекс задачи для удаления: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }

        tasks.remove(index);
        System.out.println("Задача успешно удалена.");
    }

    private void markTaskAsDone() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего отмечать как выполненное.");
            return;
        }

        System.out.print("Введите индекс задачи для отметки как выполненной: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }

        Task1 task = tasks.get(index);
        task.setStatus("Выполнено");
        System.out.println("Задача успешно отмечена как выполненная.");
    }

    private void setTaskStatus() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего редактировать.");
            return;
        }

        System.out.print("Введите индекс задачи для изменения статуса: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }

        Task1 task = tasks.get(index);
        System.out.print("Введите новый статус задачи: ");
        String newStatus = scanner.nextLine();

        task.setStatus(newStatus);
        System.out.println("Статус задачи успешно изменен.");
    }

    public static void main(String[] args) {
        TaskManager1 taskManager = new TaskManager1();
        taskManager.run();
    }
}

class Task1 {
    private String title;
    private String description;
    private String dueDate;
    private int priority;
    private String status;

    public Task1(String title, String description, String dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = "В процессе";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Название: " + title +
                "\nОписание: " + description +
                "\nДата выполнения: " + dueDate +
                "\nПриоритет: " + priority +
                "\nСтатус: " + status +
                "\n";
    }
}

//  наш класс называется Task
//  мы создали поля с модификатором доступа private, далее с типом данных int и String , наши поля называются
    // мы создали конструктор для того что бы он принял значенин полей объекта
// далее нам нужны set чтобы получить доступ к полям
    // мы добавили переопределенный метод toString это нам нужно для вывода информации о задачи в виде строки