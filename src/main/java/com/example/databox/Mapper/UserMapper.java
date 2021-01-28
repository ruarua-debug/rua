package com.example.databox.Mapper;
import com.example.databox.Entity.UserInfo;
//import com.example.databox.Entity.ViewUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     *
     * @param Password 获取用户密码
     * @param UserPhone 获取用户电话
     * @return
     */
    @Select("select * from databox.user where UserPhone=#{UserPhone} and Password=#{Password}")
    UserInfo userLogin(String UserPhone,String Password);

    /**
     *
     * @param UserPhone 获取用户电话
     * @param Answer 获取用户密保答案
     * @return
     */

    @Select("select * from databox.user where UserPhone = #{UserPhone} and Answer = #{Answer}")
    UserInfo findpassword1(String UserPhone, String Answer);
    //根据用户电话查询
    @Select("SELECT * FROM databox.user where UserPhone = #{UserPhone}")
    UserInfo getUserByPhone(String UserPhone);

    @Select("select * from databox.user order by UserID" )
    List<UserInfo> getAllUser(Integer pageIndex, Integer pageSize);

//        @Select("select UserName,UserPhone,Password,User_image_url from databox.user where UserID=#{UserID}")
//        List<ViewUser> getUserByid(Integer UserID);

    @Select("select * from databox.user where UserName=#{UserName} and UserPhone=#{UserPhone}")
    List<UserInfo> getUserByUserNameUserPhone(Integer pageIndex, Integer pageSize, @Param("UserName") String UserName, @Param("UserPhone") String UserPhone);

    @Select("select * from databox.user where UserPhone=#{UserPhone}")
    List<UserInfo> getUserByUserPhone(Integer pageIndex, Integer pageSize, @Param("UserPhone") String UserPhone);

    @Select("SELECT * FROM databox.user where UserID=#{UserID}")
    UserInfo getUserByID(Integer UserID);

    @Insert({"insert into databox.user" +
            "(UserID,UserName,UserPhone,Password,Answer,User_image_url)" +
            "VALUES(#{UserID},#{UserName},#{UserPhone},#{Password},#{Answer},#{User_image_url})"})
    Integer saveUserInfo(UserInfo userInfo);

    /**
     *
     * @param userInfo 获取用户列表
     * @return
     */
    @Insert("insert into databox.user" +
            "(UserID,UserName,UserPhone,Password,Answer,User_image_url)" +
            "VALUES(#{UserID},#{UserName},#{UserPhone},#{Password},#{Answer},#{User_image_url})")
    Integer getUserInfo(UserInfo userInfo);

    @Update("update databox.user set UserName=#{UserName},UserPhone=#{UserPhone},Password=#{Password},Answer=#{Answer},User_image_url=#{User_image_url} where UserID=#{UserID}")
    Integer updateUserByID(UserInfo userInfo);

    @Update("update databox.user set Password=#{Password} where UserID=#{UserID}")
    Integer findpassword2(String Password, Integer UserID);

    //delectchat删除某条数据
    @Delete("delete from databox.user where UserID=#{UserID}")
    Integer deluser(UserInfo deluser);



}



