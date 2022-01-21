package ${{groupId}}.${{projectPkg}}.service;

import ${{groupId}}.${{projectPkg}}.dto.ExampleReq;
import ${{groupId}}.${{projectPkg}}.dto.ExampleRsp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class ExampleService {

    @Transactional(rollbackFor = Exception.class)
    public ExampleRsp save(ExampleReq req){
        return new ExampleRsp();
    }
}