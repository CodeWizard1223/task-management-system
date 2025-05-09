package sk.malajter.task_management_system.domain;

public enum TaskStatus {

    NEW,

    DONE;

    public static TaskStatus fromString(String status) {
        return switch (status) {
            case "NEW" -> NEW;
            case "DONE" -> DONE;
            default -> throw new IllegalArgumentException("Unknown task status: " + status);
        };
    }
}
