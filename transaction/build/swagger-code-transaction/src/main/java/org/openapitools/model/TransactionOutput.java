package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.TransactionInput;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransactionOutput
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-05T18:03:47.470742+03:00[Europe/Moscow]")

public class TransactionOutput extends TransactionInput  {
  @JsonProperty("time")
  private String time;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("Pending"),
    
    ACCEPTED("Accepted"),
    
    REJECTED("Rejected");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  public TransactionOutput time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  */
  @ApiModelProperty(value = "")


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public TransactionOutput status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionOutput transactionOutput = (TransactionOutput) o;
    return Objects.equals(this.time, transactionOutput.time) &&
        Objects.equals(this.status, transactionOutput.status) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, status, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionOutput {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

