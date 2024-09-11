package contacts;

import java.util.*;
import java.util.regex.Pattern;



public class Main {
    private static final List<Record> phoneBook = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "add":
                    addRecord(scanner);
                    break;
                case "list":
                    listRecords(scanner);
                    break;
                case "search":
                    searchRecords(scanner);
                    break;
                case "count":
                    countRecords();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown action");
            }
            System.out.println();
        }
    }

    private static void addRecord(Scanner scanner) {
        System.out.println("Enter the type (person, organization): ");
        String type = scanner.nextLine().toLowerCase();

        if (type.equals("person")) {
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the surname: ");
            String surname = scanner.nextLine();
            System.out.println("Enter the birth date: ");
            String birthDate = scanner.nextLine();
            System.out.println("Enter the gender (M, F): ");
            String gender = scanner.nextLine();
            System.out.println("Enter the number: ");
            String number = scanner.nextLine();
            phoneBook.add(new Person(name, surname, birthDate, gender, number));
        } else if (type.equals("organization")) {
            System.out.println("Enter the organization name: ");
            String organizationName = scanner.nextLine();
            System.out.println("Enter the address: ");
            String address = scanner.nextLine();
            System.out.println("Enter the number: ");
            String number = scanner.nextLine();
            phoneBook.add(new Organization(organizationName, address, number));
        } else {
            System.out.println("Unknown type!");
        }
    }

   private static void listRecords(Scanner scanner) {
    for (int i = 0; i < phoneBook.size(); i++) {
        Record record = phoneBook.get(i);
        System.out.println((i + 1) + ". " + record.getInfo());
    }

    System.out.println("[list] Enter action ([number], back): ");
    String action = scanner.nextLine().toLowerCase();
    if (action.equals("back")) {
        return;
    } else {
        try {
            int index = Integer.parseInt(action) - 1;
            if (index >= 0 && index < phoneBook.size()) {
                showRecord(phoneBook.get(index), scanner);
            } else {
                System.out.println("Invalid index");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }
}

private static void searchRecords(Scanner scanner) {
    System.out.println("Enter search query: ");
    String query = scanner.nextLine().toLowerCase();
    Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

    List<Record> results = phoneBook.stream()
            .filter(record -> pattern.matcher(record.getInfo().toLowerCase()).find())
            .toList();

    System.out.println("Found " + results.size() + " results:");
    for (int i = 0; i < results.size(); i++) {
        Record record = results.get(i);
        if (record instanceof Person person) {
            System.out.println((i + 1) + ". " + person.getName() + " " + person.getSurname());
        } else if (record instanceof Organization organization) {
            System.out.println((i + 1) + ". " + organization.getOrganizationName());
        }
    }

    while (true) {
        System.out.println("[search] Enter action ([number], back, again): ");
        String action = scanner.nextLine().toLowerCase();
        switch (action) {
            case "back" -> {
                return;
            }
            case "again" -> {
                searchRecords(scanner);
                return;
            }
            case "exit" -> {
                System.exit(0);  // Handle exit action
            }
            default -> {
                try {
                    int index = Integer.parseInt(action) - 1;
                    if (index >= 0 && index < results.size()) {
                        showRecord(results.get(index), scanner);
                    } else {
                        System.out.println("Invalid number!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }
        }
    }
}
    private static void showRecord(Record record, Scanner scanner) {
    System.out.println(record.getInfo());
    while (true) {
        System.out.print("[record] Enter action (edit, delete, menu): > ");
        String action = scanner.nextLine().toLowerCase();
        switch (action) {
            case "edit":
                editRecord(record, scanner);
                break;
            case "delete":
                phoneBook.remove(record);
                System.out.println("Record deleted");
                return;
            case "menu":
                return; // Correctly return to the main menu
            default:
                System.out.println("Unknown action");
        }
    }
}

    private static void editRecord(Record record, Scanner scanner) {
        System.out.println("Select a field (" + String.join(", ", record.getEditableFields()) + "): ");
        String field = scanner.nextLine().toLowerCase();
        if (record.getEditableFields().contains(field)) {
            System.out.println("Enter " + field + ": ");
            String value = scanner.nextLine();
            record.setField(field, value);
            System.out.println("Saved");
            System.out.println(record.getInfo());
        } else {
            System.out.println("Invalid field!");
        }
    }

    private static void countRecords() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }
}
