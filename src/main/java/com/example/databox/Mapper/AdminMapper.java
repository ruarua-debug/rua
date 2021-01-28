package com.example.databox.Mapper;

import com.example.databox.Entity.AdminInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
   @Select("select * from databox.admin where AdminPhone = ${AdminPhone} and AdminPassword = ${AdminPassword} ;")
    AdminInfo adminLogin(String AdminPhone, String AdminPassword);

    @Select("select * from databox.admin order by AdminID" )
    List<AdminInfo> getAllAdmin(Integer pageIndex, Integer pageSize);

//        @Select("select UserName,UserPhone,Password,User_image_url from databox.user where UserID=#{UserID}")
//        List<ViewUser> getUserByid(Integer UserID);

    @Select("select * from databox.admin where AdminName=#{AdminName} and AdminPhone=#{AdminPhone}")
    List<AdminInfo> getAdminByAdminNameAdminPhone(Integer pageIndex, Integer pageSize, @Param("AdminName") String AdminName, @Param("AdminPhone") String AdminPhone);

    @Select("select * from databox.admin where AdminPhone=#{AdminPhone}")
    List<AdminInfo> getAdminByAdminPhone(Integer pageIndex, Integer pageSize, @Param("AdminPhone") String AdminPhone);

    @Insert({"insert into databox.admin" +
            "(AdminName,AdminPhone,AdminPassword,Admin_image_url)" +
            "VALUES(#{AdminName},#{AdminPhone},#{AdminPassword},#{Admin_image_url})"})
    Integer saveAdminInfo(AdminInfo adminInfo);

    @Update("update databox.admin set AdminName=#{AdminName},AdminPhone=#{AdminPhone},AdminPassword=#{AdminPassword},Admin_image_url=#{Admin_image_url} where AdminID=#{AdminID}")
    Integer updateAdminByID(AdminInfo adminInfo);

    @Select("SELECT * FROM databox.admin where AdminID=#{AdminID}")
    AdminInfo getAdminByID(Integer AdminID);
}
