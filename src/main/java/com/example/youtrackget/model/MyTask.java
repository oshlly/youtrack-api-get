
package com.example.youtrackget.model;

import java.util.HashMap;
import java.util.List;
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
    "description",
    "comments",
    "summary",
    "attachments",
    "id",
    "$type"
})
@Generated("jsonschema2pojo")
public class MyTask {

    @JsonProperty("description")
    private String description;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("attachments")
    private List<Attachment> attachments = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("$type")
    private String $type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() { return comments; }

    public int getCommentsSize() { return comments.size(); }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    public int getAttachmentsSize() {
        return attachments.size();
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
