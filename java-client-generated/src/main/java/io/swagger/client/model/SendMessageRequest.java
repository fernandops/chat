package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * SendMessageRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-04T01:53:44.364Z")
public class SendMessageRequest {
  @SerializedName("recipient")
  private String recipient = null;

  @SerializedName("content")
  private String content = null;

  @SerializedName("sessionid")
  private String sessionid = null;

  public SendMessageRequest recipient(String recipient) {
    this.recipient = recipient;
    return this;
  }

   /**
   * Destinatário (userid)
   * @return recipient
  **/
  @ApiModelProperty(example = "fulano", required = true, value = "Destinatário (userid)")
  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public SendMessageRequest content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(example = "Hello World!", required = true, value = "")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public SendMessageRequest sessionid(String sessionid) {
    this.sessionid = sessionid;
    return this;
  }

   /**
   * Get sessionid
   * @return sessionid
  **/
  @ApiModelProperty(example = "ABCD1234", required = true, value = "")
  public String getSessionid() {
    return sessionid;
  }

  public void setSessionid(String sessionid) {
    this.sessionid = sessionid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageRequest sendMessageRequest = (SendMessageRequest) o;
    return Objects.equals(this.recipient, sendMessageRequest.recipient) &&
        Objects.equals(this.content, sendMessageRequest.content) &&
        Objects.equals(this.sessionid, sendMessageRequest.sessionid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipient, content, sessionid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageRequest {\n");
    
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    sessionid: ").append(toIndentedString(sessionid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

