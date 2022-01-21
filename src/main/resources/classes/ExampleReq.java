package ${{groupId}}.${{projectPkg}}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 */
@Data
@ApiModel("模板查询入参")
public class ExampleReq implements Serializable {
    private static final long serialVersionUID = -239903353078591887L;

    @NotNull
    @ApiModelProperty("名称")
    private String name;
}
