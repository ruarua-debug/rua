package com.example.databox.Mapper;

import com.example.databox.Entity.LogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface LogMapper {


    //从数据库取所有用户日志数据
    @Select("SELECT sl.*,us.UserName FROM user us join sys_log sl on us.UserID=sl.UserID" )
    List<LogInfo> getAllLog(Integer pageIndex, Integer pageSize);


    //根据日期和姓名查询用户日志
    @Select("SELECT sl.*,us.UserName FROM user us join sys_log sl on us.UserID=sl.UserID where sl.CreatDate=#{CreatDate} and us.UserName like '%{UserName}%'\n")
    List<LogInfo> getLogByDateName(Integer pageIndex, Integer pageSize, Date CreatDate, String UserName);

    //根据姓名查询用户日志
    @Select("SELECT sl.*,us.UserName FROM user us join sys_log sl on us.UserID=sl.UserID where us.UserName like '%${UserName}%'")
    List<LogInfo> getLogByName(Integer pageIndex, Integer pageSize, String UserName);

    //根据日期查询日志
   @Select("SELECT sl.*,us.UserName FROM user us join sys_log sl on us.UserID=sl.UserID where sl.CreatDate=#{CreatDate}")
    List<LogInfo> getLogByDate(Integer PageIndex, Integer PageSize, Date CreatDate);

   //插入一条日志信息
    @Insert("INSERT INTO sys_log \n" +
            "(UserID,IP_Address,OS,IE,CreatDate)" +
            "VALUE(#{UserID},#{IP_Address},#{OS},#{IE},sysdate())")
    Integer addLog(LogInfo logInfo);
}
