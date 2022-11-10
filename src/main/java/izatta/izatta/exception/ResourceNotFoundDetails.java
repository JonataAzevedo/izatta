package izatta.izatta.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
@Getter
public class ResourceNotFoundDetails {

    private String title;

    private Integer status;

    private String detail;

    private long timestamp;

    private String message;

    private ResourceNotFoundDetails(){

    }
}
