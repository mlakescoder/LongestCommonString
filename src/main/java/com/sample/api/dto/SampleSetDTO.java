package com.sample.api.dto;

import java.io.Serializable;
import java.util.List;

public class SampleSetDTO implements Serializable {

    private static final long serialVersionUID = -692448563679625089L;
    private List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public void addValue(Value value) {
        this.values.add(value);
    }

    public static Builder newBuilder() { return new Builder(); }

    public static final class Builder {
        private List<Value> values;

        private Builder() {
        }

        public Builder withValues(List<Value> values) {
            this.values = values;
            return this;
        }

        public SampleSetDTO build() {
            SampleSetDTO sampleSetDTO = new SampleSetDTO();
            sampleSetDTO.values = this.values;
            return sampleSetDTO;
        }
    }
}
