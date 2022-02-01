package io.swagger.model;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Soolution
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-04-18T16:20:25.506Z")


@Entity
@Table (name="soolution")
public class Soolution  implements Serializable {
  @JsonProperty("id")
  @Id @NotBlank
  private String id = null;

  @JsonProperty("description")
  @NotBlank
  private String description = null;

  @JsonProperty("causa")
  @NotBlank
  private String causa = null;

  @JsonProperty("solution")
  @NotBlank
  private String solution = null;

  @JsonProperty("status")
  private String status = null;

  public Soolution id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1552", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Soolution description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "Falha ao selecionar [meio] de pagamento", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Soolution causa(String causa) {
    this.causa = causa;
    return this;
  }

  /**
   * Get causa
   * @return causa
  **/
  @ApiModelProperty(example = "Falha de programação", value = "")


  public String getCausa() {
    return causa;
  }

  public void setCausa(String causa) {
    this.causa = causa;
  }

  public Soolution solution(String solution) {
    this.solution = solution;
    return this;
  }

  /**
   * Get solution
   * @return solution
  **/
  @ApiModelProperty(example = "Corrigido bug na versão 2.06.[776]", value = "")


  public String getSolution() {
    return solution;
  }

  public void setSolution(String solution) {
    this.solution = solution;
  }

  public Soolution status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "fixed", value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
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
    Soolution soolution = (Soolution) o;
    return Objects.equals(this.id, soolution.id) &&
        Objects.equals(this.description, soolution.description) &&
        Objects.equals(this.causa, soolution.causa) &&
        Objects.equals(this.solution, soolution.solution) &&
        Objects.equals(this.status, soolution.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, causa, solution, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Soolution {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    causa: ").append(toIndentedString(causa)).append("\n");
    sb.append("    solution: ").append(toIndentedString(solution)).append("\n");
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

