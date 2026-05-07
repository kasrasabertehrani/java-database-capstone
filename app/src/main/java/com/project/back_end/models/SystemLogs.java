package com.project.back_end.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;
import java.util.Map;

@Document(collection = "system_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SystemLogs {

    @Id
    private String id;

    private Instant timestamp;

    @NotNull
    @Field("event_type")
    private String eventType;

    private LogActor actor;

    private LogEntity entity;

    private LogChanges changes;

    @Field("request_context")
    private RequestContext requestContext;

    // --- Nested Classes ---

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LogActor {
        @Field("actor_id")
        private String actorId;
        
        @Field("actor_role")
        private String actorRole;
        
        @Field("actor_name")
        private String actorName;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LogEntity {
        @Field("entity_type")
        private String entityType;
        
        @Field("entity_id")
        private Object entityId; // Using Object because IDs can be INT or String(UUID)
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LogChanges {
        private Map<String, Object> before;
        private Map<String, Object> after;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RequestContext {
        @Field("ip_address")
        private String ipAddress;
        
        @Field("user_agent")
        private String userAgent;
    }
}