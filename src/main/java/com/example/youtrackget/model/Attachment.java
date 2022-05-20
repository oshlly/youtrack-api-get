package com.example.youtrackget.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "thumbnailURL",
    "$type"
})
@Generated("jsonschema2pojo")
public class Attachment {

    @JsonProperty("url")
    private String url;
    @JsonProperty("$type")
    private String $type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumbnailURL")
    public String getUrl() {
        return url;
    }

    @JsonProperty("thumbnailURL")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("$type")
    public String get$type() {
        return $type;
    }

    @JsonProperty("$type")
    public void set$type(String $type) {
        this.$type = $type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
