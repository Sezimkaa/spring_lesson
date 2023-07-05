import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class TaskManager {
        private List<Task> tasks;

        public TaskManager() {
            tasks = new ArrayList<>();
        }

        public void createTask(String title, String description, String dueDate, int priority) {
            Task task = new Task(title, description, dueDate, priority);
            tasks.add(task);
            System.out.println("Задача создана: " + task);
        }

        public void viewTasks() {
            if (tasks.isEmpty()) {
                System.out.println("Список задач пуст.");
            } else {
                System.out.println("Список задач:");
                for (Task task : tasks) {
                    System.out.println(task);
                }
            }
        }

        public void editTask(int index, String title, String description, String dueDate, int priority) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.get(index);
                task.setTitle(title);
                task.setDescription(description);
                task.setDueDate(dueDate);
                task.setPriority(priority);
                System.out.println("Задача успешно отредактирована: " + task);
            } else {
                System.out.println("Неверный индекс задачи.");
            }
        }

        public void deleteTask(int index) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.remove(index);
                System.out.println("Задача удалена: " + task);
            } else {
                System.out.println("Неверный индекс задачи.");
            }
        }

        public void markTaskAsDone(int index) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.get(index);
                task.setStatus("Выполнено");
                System.out.println("Задача отмечена как выполненная: " + task);
            } else {
                System.out.println("Неверный индекс задачи.");
            }
        }

        public void setTaskStatus(int index, String status) {
            if (index >= 0 && index < tasks.size()) {
                Task task = tasks.get(index);
                task.setStatus(status);
                System.out.println("Статус задачи изменен: " + task);
            } else {
                System.out.println("Неверный индекс задачи.");
            }
        }

        public void sortByDueDate() {
            tasks.sort((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()));
            System.out.println("Задачи отсортированы по дате выполнения.");
        }

        public void sortByPriority() {
            tasks.sort((t1, t2) -> t2.getPriority() - t1.getPriority());
            System.out.println("Задачи отсортированы по приоритету.");
        }

        public void viewTasksForPeriod(String startDate, String endDate) {
            System.out.println("Задачи на период с " + startDate + " по " + endDate + ":");
            for (Task task : tasks) {
                if (task.getDueDate().compareTo(startDate) >= 0 && task.getDueDate().compareTo(endDate) <= 0) {
                    System.out.println(task);
                }
            }
        }

        public static void main(String[] args) {
            TaskManager taskManager = new TaskManager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Создать задачу");
                System.out.println("2. Просмотреть задачи");
                System.out.println("3. Отредактировать задачу");
                System.out.println("4. Удалить задачу");
                System.out.println("5. Отметить задачу как выполненную");
                System.out.println("6. Изменить статус задачи");
                System.out.println("7. Сортировка задач по дате выполнения");
                System.out.println("8. Сортировка задач по приоритету");
                System.out.println("9. Просмотреть задачи на период");
                System.out.println("0. Выйти");
                System.out.print("Ваш выбор: ");

                int choice = scanner.nextInt();

                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Введите название задачи: ");
                        scanner.nextLine(); // Clear the input buffer
                        String title = scanner.nextLine();
                        System.out.print("Введите описание задачи: ");
                        String description = scanner.nextLine();
                        System.out.print("Введите дату выполнения задачи (в формате ДД.ММ.ГГГГ): ");
                        String dueDate = scanner.nextLine();
                        System.out.print("Введите приоритет задачи (от 1 до 10): ");
                        int priority = scanner.nextInt();
                        taskManager.createTask(title, description, dueDate, priority);
                        break;

                    case 2:
                        taskManager.viewTasks();
                        break;

                    case 3:
                        System.out.print("Введите индекс задачи для редактирования: ");
                        int editIndex = scanner.nextInt();
                        System.out.print("Введите новое название задачи: ");
                        scanner.nextLine(); // Clear the input buffer
                        String newTitle = scanner.nextLine();
                        System.out.print("Введите новое описание задачи: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Введите новую дату выполнения задачи (в формате ДД.ММ.ГГГГ): ");
                        String newDueDate = scanner.nextLine();
                        System.out.print("Введите новый приоритет задачи (от 1 до 10): ");
                        int newPriority = scanner.nextInt();
                        taskManager.editTask(editIndex, newTitle, newDescription, newDueDate, newPriority);
                        break;

                    case 4:
                        System.out.print("Введите индекс задачи для удаления: ");
                        int deleteIndex = scanner.nextInt();
                        taskManager.deleteTask(deleteIndex);
                        break;

                    case 5:
                        System.out.print("Введите индекс задачи для отметки как выполненной: ");
                        int doneIndex = scanner.nextInt();
                        taskManager.markTaskAsDone(doneIndex);
                        break;

                    case 6:
                        System.out.print("Введите индекс задачи для изменения статуса: ");
                        int statusIndex = scanner.nextInt();
                        scanner.nextLine(); // Clear the input buffer
                        System.out.print("Введите новый статус задачи: ");
                        String newStatus = scanner.nextLine();
                        taskManager.setTaskStatus(statusIndex, newStatus);
                        break;

                    case 7:
                        taskManager.sortByDueDate();
                        break;

                    case 8:
                        taskManager.sortByPriority();
                        break;

                    case 9:
                        System.out.print("Введите начальную дату  (в формате Д.М.Г): ");
                        scanner.nextLine(); // Clear the input buffer
                        String startDate = scanner.nextLine();
                        System.out.print("Введите конечную дату  (в формате Д.М.Г): ");
                        String endDate = scanner.nextLine();
                        taskManager.viewTasksForPeriod(startDate, endDate);
                        break;

                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }

            System.out.println("Работа приложения завершена.");
            scanner.close();
        }

        public void run() {
        }
    }

    class Task {
        private String title;
        private String description;

        public Task(String title, String description, String dueDate, int priority) {
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDueDate(String dueDate) {
        }

        public void setPriority(int priority) {

        }

        public void setStatus(String выполнено) {
        }

        public <T> Comparable<T> getDueDate() {

            return null;
        }

        public int getPriority() {
            return 0;
        }
    }





