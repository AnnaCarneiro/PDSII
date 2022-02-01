package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Bug
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-04-18T16:20:25.506Z")

public class Bug   {
  @JsonProperty("causa")
  private String causa = null;

  public Bug causa(String causa) {
    this.causa = causa;
    return this;
  }

  /**
   * Get causa
   * @return causa
  **/
  @ApiModelProperty(example = "Falha ao selecionar metodo de pagamento", value = "")


  public String getCausa() {
    return causa;
  }

  public void setCausa(String causa) {
    this.causa = causa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bug bug = (Bug) o;
    return Objects.equals(this.causa, bug.causa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(causa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bug {\n");
    
    sb.append("    causa: ").append(toIndentedString(causa)).append("\n");
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

