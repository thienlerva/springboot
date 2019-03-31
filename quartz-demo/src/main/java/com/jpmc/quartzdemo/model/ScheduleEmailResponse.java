package com.jpmc.quartzdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ScheduleEmailResponse {

    boolean success;
    String jobId;
    String jobGroup;
    String message;

    public ScheduleEmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ScheduleEmailResponse(boolean success, String jobId, String jobGroup, String message) {
        this.success = success;
        this.jobId = jobId;
        this.jobGroup = jobGroup;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ScheduleEmailResponse{" +
                "success=" + success +
                ", jobId='" + jobId + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
