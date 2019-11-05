package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransactionInput
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-05T18:03:47.470742+03:00[Europe/Moscow]")

public class TransactionInput   {
  @JsonProperty("senderAccountId")
  private String senderAccountId;

  @JsonProperty("recipientAccountId")
  private String recipientAccountId;

  @JsonProperty("amount")
  private Integer amount;

  public TransactionInput senderAccountId(String senderAccountId) {
    this.senderAccountId = senderAccountId;
    return this;
  }

  /**
   * Get senderAccountId
   * @return senderAccountId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSenderAccountId() {
    return senderAccountId;
  }

  public void setSenderAccountId(String senderAccountId) {
    this.senderAccountId = senderAccountId;
  }

  public TransactionInput recipientAccountId(String recipientAccountId) {
    this.recipientAccountId = recipientAccountId;
    return this;
  }

  /**
   * Get recipientAccountId
   * @return recipientAccountId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRecipientAccountId() {
    return recipientAccountId;
  }

  public void setRecipientAccountId(String recipientAccountId) {
    this.recipientAccountId = recipientAccountId;
  }

  public TransactionInput amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionInput transactionInput = (TransactionInput) o;
    return Objects.equals(this.senderAccountId, transactionInput.senderAccountId) &&
        Objects.equals(this.recipientAccountId, transactionInput.recipientAccountId) &&
        Objects.equals(this.amount, transactionInput.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(senderAccountId, recipientAccountId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionInput {\n");
    
    sb.append("    senderAccountId: ").append(toIndentedString(senderAccountId)).append("\n");
    sb.append("    recipientAccountId: ").append(toIndentedString(recipientAccountId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

