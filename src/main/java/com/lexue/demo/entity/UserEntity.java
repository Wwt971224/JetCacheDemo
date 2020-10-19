package com.lexue.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author wentai
 * @since 2020-10-18
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserEntity {

    /**
     * 主键用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 乐学id
     */
    private String leId;

    /**
     * 用户手机号
     */
    private Long userMobile;


}
