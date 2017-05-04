package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * LoginSuccessResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-05-04T01:53:44.364Z")
public class LoginSuccessResponse {
  @SerializedName("sessionid")
  private String sessionid = null;

  public LoginSuccessResponse sessionid(String sessionid) {
    this.sessionid = sessionid;
    return this;
  }

   /**
   * Unique session ID post successful authentication.
   * @return sessionid
  **/
  @ApiModelProperty(value = "Unique session ID post successful authentication.")
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
    LoginSuccessResponse loginSuccessResponse = (LoginSuccessResponse) o;
    return Objects.equals(this.sessionid, loginSuccessResponse.sessionid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginSuccessResponse {\n");
    
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

