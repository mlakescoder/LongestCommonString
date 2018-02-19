package com.sample.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 7845156245739789803L;

    private List<Value> lcs;


    public List<Value> getLcs() {
        return lcs;
    }

    public void setLcs(List<Value> lcs) {
        this.lcs = lcs;
    }

    public static Builder newBuilder() { return new Builder(); }

    public static final class Builder {
        private List<Value> lcs;

        private Builder() {
        }

        public Builder withLcs(List<String> lcs) {
            List<Value> values = new ArrayList<>();

            for ( String s : lcs ) {
                values.add(new Value(s) );
            }
            this.lcs = values;
            return this;
        }

        public ResultDTO build() {
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.lcs = this.lcs;
            return resultDTO;
        }
    }
}
