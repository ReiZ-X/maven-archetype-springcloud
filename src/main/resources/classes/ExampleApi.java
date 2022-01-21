package ${{groupId}}.${{projectPkg}}.api;
import ${{groupId}}.${{projectPkg}}.dto.ExampleReq;
import ${{groupId}}.${{projectPkg}}.dto.ExampleRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 */
@FeignClient("${{projectName}}")
public interface ExampleApi {

    @PostMapping("urlPath")
    Object r(@RequestBody ExampleReq req);
}
