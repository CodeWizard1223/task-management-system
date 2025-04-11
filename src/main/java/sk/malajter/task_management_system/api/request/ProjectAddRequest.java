package sk.malajter.task_management_system.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAddRequest {

    private Long userId;

    private String name;

    private String description;
}
