package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum State {

    @JsonProperty("COMPLETED")
    COMPLETED,
    @JsonProperty("ABORTED")
    ABORTED,
    @JsonProperty("IMPROVED")
    IMPROVED,
    @JsonProperty("DESCENDED")
    DESCENDED

}
