/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.TransactionInput;
import org.openapitools.model.TransactionOutput;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-05T18:03:47.470742+03:00[Europe/Moscow]")

@Validated
@Api(value = "transaction", description = "the transaction API")
public interface TransactionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "Get status of all transactions within 24 hours", nickname = "getAllTransactions", notes = "", response = TransactionOutput.class, tags={ "GET", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = TransactionOutput.class) })
    @RequestMapping(value = "/transaction",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<TransactionOutput> getAllTransactions() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "null");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @ApiOperation(value = "Make transaction between account", nickname = "makeTransaction", notes = "", tags={ "POST", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Accepted for processing") })
    @RequestMapping(value = "/transaction",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> makeTransaction(@ApiParam(value = "" ,required=true )  @Valid @RequestBody TransactionInput transactionInput) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
