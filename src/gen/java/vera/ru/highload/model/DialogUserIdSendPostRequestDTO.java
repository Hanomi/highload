package vera.ru.highload.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DialogUserIdSendPostRequestDTO
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@JsonTypeName("_dialog__user_id__send_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-02T12:49:18.455165800+03:00[Europe/Moscow]")
public class DialogUserIdSendPostRequestDTO {

  @JsonProperty("text")
  private String text;

  public DialogUserIdSendPostRequestDTO text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Текст сообщения
   * @return text
  */
  @NotNull 
  @Schema(name = "text", example = "Привет, как дела?", description = "Текст сообщения", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DialogUserIdSendPostRequestDTO dialogUserIdSendPostRequest = (DialogUserIdSendPostRequestDTO) o;
    return Objects.equals(this.text, dialogUserIdSendPostRequest.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DialogUserIdSendPostRequestDTO {\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

