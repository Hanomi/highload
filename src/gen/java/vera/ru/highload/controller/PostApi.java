/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package vera.ru.highload.controller;

import java.math.BigDecimal;
import vera.ru.highload.model.LoginPost500ResponseDTO;
import vera.ru.highload.model.PostCreatePostRequestDTO;
import vera.ru.highload.model.PostDTO;
import vera.ru.highload.model.PostUpdatePutRequestDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-02T14:32:27.265904500+03:00[Europe/Moscow]")
@Validated
@Tag(name = "post", description = "the post API")
public interface PostApi {

    /**
     * POST /post/create
     *
     * @param postCreatePostRequestDTO  (optional)
     * @return Успешно создан пост (status code 200)
     *         or Невалидные данные ввода (status code 400)
     *         or Неавторизованный доступ (status code 401)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "postCreatePost",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешно создан пост", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные ввода"),
            @ApiResponse(responseCode = "401", description = "Неавторизованный доступ"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/post/create",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<String>> postCreatePost(
        @Parameter(name = "PostCreatePostRequestDTO", description = "") @Valid @RequestBody(required = false) Mono<PostCreatePostRequestDTO> postCreatePostRequestDTO,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "\"1d535fd6-7521-4cb1-aa6d-031be7123c4d\"";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(postCreatePostRequestDTO).then(Mono.empty());

    }


    /**
     * PUT /post/delete/{id}
     *
     * @param id  (required)
     * @return Успешно удален пост (status code 200)
     *         or Невалидные данные ввода (status code 400)
     *         or Неавторизованный доступ (status code 401)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "postDeleteIdPut",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешно удален пост"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные ввода"),
            @ApiResponse(responseCode = "401", description = "Неавторизованный доступ"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/post/delete/{id}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> postDeleteIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }


    /**
     * GET /post/feed
     *
     * @param offset  (optional, default to 0)
     * @param limit  (optional, default to 10)
     * @return Успешно получены посты друзей (status code 200)
     *         or Невалидные данные ввода (status code 400)
     *         or Неавторизованный доступ (status code 401)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "postFeedGet",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешно получены посты друзей", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PostDTO.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные ввода"),
            @ApiResponse(responseCode = "401", description = "Неавторизованный доступ"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/post/feed",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<Flux<PostDTO>>> postFeedGet(
        @DecimalMin("0") @Parameter(name = "offset", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
        @DecimalMin("1") @Parameter(name = "limit", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false, defaultValue = "10") BigDecimal limit,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"author_user_id\" : \"author_user_id\", \"id\" : \"1d535fd6-7521-4cb1-aa6d-031be7123c4d\", \"text\" : \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lectus mauris ultrices eros in cursus turpis massa.\" }, { \"author_user_id\" : \"author_user_id\", \"id\" : \"1d535fd6-7521-4cb1-aa6d-031be7123c4d\", \"text\" : \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lectus mauris ultrices eros in cursus turpis massa.\" } ]";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * GET /post/get/{id}
     *
     * @param id  (required)
     * @return Успешно получен пост (status code 200)
     *         or Невалидные данные ввода (status code 400)
     *         or Неавторизованный доступ (status code 401)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "postGetIdGet",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешно получен пост", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PostDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные ввода"),
            @ApiResponse(responseCode = "401", description = "Неавторизованный доступ"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/post/get/{id}",
        produces = { "application/json" }
    )
    default Mono<ResponseEntity<PostDTO>> postGetIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"author_user_id\" : \"author_user_id\", \"id\" : \"1d535fd6-7521-4cb1-aa6d-031be7123c4d\", \"text\" : \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lectus mauris ultrices eros in cursus turpis massa.\" }";
                result = ApiUtil.getExampleResponse(exchange, mediaType, exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }


    /**
     * PUT /post/update
     *
     * @param postUpdatePutRequestDTO  (optional)
     * @return Успешно изменен пост (status code 200)
     *         or Невалидные данные ввода (status code 400)
     *         or Неавторизованный доступ (status code 401)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "postUpdatePut",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешно изменен пост"),
            @ApiResponse(responseCode = "400", description = "Невалидные данные ввода"),
            @ApiResponse(responseCode = "401", description = "Неавторизованный доступ"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500ResponseDTO.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/post/update",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Mono<ResponseEntity<Void>> postUpdatePut(
        @Parameter(name = "PostUpdatePutRequestDTO", description = "") @Valid @RequestBody(required = false) Mono<PostUpdatePutRequestDTO> postUpdatePutRequestDTO,
        @Parameter(hidden = true) final ServerWebExchange exchange
    ) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(postUpdatePutRequestDTO).then(Mono.empty());

    }

}
