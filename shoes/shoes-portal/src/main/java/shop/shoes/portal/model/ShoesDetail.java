package shop.shoes.portal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("shoesDetail")
public class ShoesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("shoesName")
    private String shoesName;

    @TableField("shoesColor")
    private String shoesColor;

    @TableField("price")
    private int price;

    @TableField("size")
    private String size;

    @TableField(exist=false)
    private List<Size> sizes;

}
