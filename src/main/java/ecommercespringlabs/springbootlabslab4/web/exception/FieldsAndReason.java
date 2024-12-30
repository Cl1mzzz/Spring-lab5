package ecommercespringlabs.springbootlabslab4.web.exception;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class FieldsAndReason {
    String field;
    String reason;
}

