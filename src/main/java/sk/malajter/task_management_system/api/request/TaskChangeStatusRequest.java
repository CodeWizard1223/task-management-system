package sk.malajter.task_management_system.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.malajter.task_management_system.domain.TaskStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskChangeStatusRequest {
    private TaskStatus status;
}
