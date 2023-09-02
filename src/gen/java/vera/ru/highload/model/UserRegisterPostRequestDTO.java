package vera.ru.highload.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UserRegisterPostRequestDTO
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@JsonTypeName("_user_register_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-02T12:49:18.455165800+03:00[Europe/Moscow]")
public class UserRegisterPostRequestDTO {

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("second_name")
  private String secondName;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("birthdate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthdate;

  @JsonProperty("biography")
  private String biography;

  @JsonProperty("city")
  private String city;

  @JsonProperty("password")
  private String password;

  public UserRegisterPostRequestDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  
  @Schema(name = "first_name", example = "Имя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserRegisterPostRequestDTO secondName(String secondName) {
    this.secondName = secondName;
    return this;
  }

  /**
   * Get secondName
   * @return secondName
  */
  
  @Schema(name = "second_name", example = "Фамилия", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public UserRegisterPostRequestDTO age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  */
  
  @Schema(name = "age", example = "18", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public UserRegisterPostRequestDTO birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Дата рождения
   * @return birthdate
  */
  @Valid 
  @Schema(name = "birthdate", example = "Wed Feb 01 03:00:00 MSK 2017", description = "Дата рождения", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public UserRegisterPostRequestDTO biography(String biography) {
    this.biography = biography;
    return this;
  }

  /**
   * Get biography
   * @return biography
  */
  
  @Schema(name = "biography", example = "Хобби, интересы и т.п.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public UserRegisterPostRequestDTO city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  
  @Schema(name = "city", example = "Москва", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public UserRegisterPostRequestDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", example = "Секретная строка", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegisterPostRequestDTO userRegisterPostRequest = (UserRegisterPostRequestDTO) o;
    return Objects.equals(this.firstName, userRegisterPostRequest.firstName) &&
        Objects.equals(this.secondName, userRegisterPostRequest.secondName) &&
        Objects.equals(this.age, userRegisterPostRequest.age) &&
        Objects.equals(this.birthdate, userRegisterPostRequest.birthdate) &&
        Objects.equals(this.biography, userRegisterPostRequest.biography) &&
        Objects.equals(this.city, userRegisterPostRequest.city) &&
        Objects.equals(this.password, userRegisterPostRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, secondName, age, birthdate, biography, city, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegisterPostRequestDTO {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    secondName: ").append(toIndentedString(secondName)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    biography: ").append(toIndentedString(biography)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

