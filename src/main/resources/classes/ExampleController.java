package ${{groupId}}.${{projectPkg}}.controller;

import ${{groupId}}.${{projectPkg}}.R;
import ${{groupId}}.${{projectPkg}}.api.ExampleApi;
import ${{groupId}}.${{projectPkg}}.dto.ExampleReq;
import ${{groupId}}.${{projectPkg}}.dto.ExampleRsp;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 */
@RestController
public class ExampleController implements ExampleApi {

    @Override
    public Object r(ExampleReq req){
        return R.ok(new ExampleRsp());
    }

}
