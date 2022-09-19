package shop.shoes.portal.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import shop.shoes.portal.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author shop
* @since 2022-05-18
*/
    @Repository
    public interface UserMapper extends BaseMapper<User> {

        @Select("select * from user where username=#{username}")
        User findUserByUsername(String username);

        @Select("select * from user where phone=#{phone}")
        String findUserByPhone(String phone);

        @Update("update user set password=#{password} where username=#{username}")
        int updateUser(@Param("username") String username, @Param("password") String password);

    }
