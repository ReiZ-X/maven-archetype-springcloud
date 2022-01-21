package ${{groupId}}.${{projectPkg}}.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 *
 */
@Data
@ApiModel("模板返回结果")
@NoArgsConstructor
@AllArgsConstructor
public class ExampleRsp implements Serializable {
    private static final long serialVersionUID = -1911677285454654889L;
    @ApiModelProperty("性别")
    private Integer gender;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("id")
    private Long id;

}
