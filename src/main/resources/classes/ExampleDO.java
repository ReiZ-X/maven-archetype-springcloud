package ${{groupId}}.${{projectPkg}}.mapper.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("table_example")
public class ExampleDO  {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
}