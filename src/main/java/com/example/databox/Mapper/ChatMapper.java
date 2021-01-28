package com.example.databox.Mapper;

import com.example.databox.Entity.ChatInfo;
import com.example.databox.Entity.DataInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ChatMapper {
    //chatadmin显示所有数据

    /**
     *
     * @param pageIndex 分页的页面数
     * @param pageSize 每个页面的数据条数
     * @return chat页面查询
     */
    @Select("select * from chat")
    List<ChatInfo> getAllUser(Integer pageIndex, Integer pageSize);

    //后台管理chatadmin的查询功能

    /**
     *
     * @param pageIndex
     * @param pageSize
     * @param UserName
     * @return
     */
    @Select("select * from chat where UserName=#{UserName}")
    List<ChatInfo> findUserByUserID(Integer pageIndex, Integer pageSize, @Param("UserName") String UserName);

    //后台管理addchat增加数据
    @Insert("insert into chat" +
            "(UserID,UserPhone,Password,Topic,Content)" +
            "values(#{UserID},#{UserPhone},#{Password},#{Topic},#{Content});")
    Integer savechat(ChatInfo chat);

    //updatechat，delectchat查询某条数据
    @Select("select * from chat where UserID=#{UserID}")
    ChatInfo getChatByid(Integer UserID);

    //updatechat更新某条数据
    @Update("update chat set UserPhone=#{UserPhone},User_image_url=#{User_image_url},Password=#{Password},Topic=#{Topic},Content=#{Content} where UserID=#{UserID}; ")
    Integer updateUserByID(ChatInfo chat);

    //delectchat删除某条数据
    @Delete("delete from chat where UserID=#{UserID}")
    Integer delchat(ChatInfo delchat);

    //给chat和chat1页面传值，所有数据
    @Select("select * from chat")
    List<ChatInfo> getchatno();

    //chat、chat1根据Topic查询分类
    @Select("select * from chat where Topic=#{Topic}")
    List<ChatInfo> findUserByTopic(@Param("Topic") String Topic);

    //chat页面用户登录判断

    /**
     *
     * @param UserName 获取用户名
     * @param Password 获取用户密码
     * @return chat页面
     */
    @Select("select * from user\n" +
            "where UserName=#{UserPhone} and password=#{Password}  ")
    ChatInfo chatUserLogin(String UserPhone, String Password);

    //chat1用户发帖

    /**
     *
     * @param UserName 获取用户名
     * @param Password 获取用户密码
     * @param Topic 获取用户话题
     * @param Content 获取用户内容
     * @param Title  获取用户标题
     * @return chat1页面
     */
    @Insert("insert into chat (UserPhone,Password,Topic,Content,Title)" +
            "values(#{UserPhone},#{Password},#{Topic},#{Content},#{Title});")
    Integer addchat(String UserPhone, String Password, String Topic, String Content, String Title);

}
