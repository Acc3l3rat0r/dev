package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-05T18:03:47.470742+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.transaction.base-path:}")
public class SenderApiController implements SenderApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SenderApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
