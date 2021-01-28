package com.example.databox.Mapper;

import com.example.databox.Entity.MessageInfo;
import org.apache.ibatis.annotations.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Mapper
public interface MessageMapper {


    @Select("select * from message order by CommessageID")
    List<MessageInfo> findAllCompany();

    @Insert("INSERT INTO databox.message (CommessageID, CompanyName, CompanySign, CompanySize, BaseInformation, BusinessInformation,City,CompanyAddress,CompanyMap,CompanyLogo,CompanyLabel) " +
            "VALUES (#{CommessageID}, #{CompanyName}, #{CompanySign}, #{CompanySize}, #{BaseInformation}, #{BusinessInformation},#{City},#{CompanyAddress},#{CompanyMap},#{CompanyLogo},#{CompanyLabel});\n")
    Integer addMessageInfo(MessageInfo messageInfo);

    @Select("select * from message where CommessageID=#{CommessageID}")
    MessageInfo getCompanyByid(Integer CommessageID);

    @Update("update message set CompanyName=#{CompanyName},CompanySign=#{CompanySign},CompanySize= #{CompanySize},BaseInformation= #{BaseInformation}, BusinessInformation=#{BusinessInformation},City=#{City},CompanyAddress=#{CompanyAddress},CompanyMap=#{CompanyMap},CompanyLogo=#{CompanyLogo},CompanyLabel=#{CompanyLabel}  where CommessageID=#{CommessageID};")
    Integer updateCompanyByID(MessageInfo messageInfo);

    @Select("select * from message order by CommessageID")
    List<MessageInfo> getAllCompany(Integer pageIndex, Integer pageSize);

    @Select("select * from message where CompanyName=#{CompanyName}")
    List<MessageInfo> findCompanyByID(Integer pageIndex, Integer pageSize, @Param("CompanyName") String CompanyName);

    @Delete("delete from message where CommessageID=#{CommessageID}")
    Integer deleteCompanyByID(MessageInfo messageInfo);





    //考拉公司页面
    //根据position页面传过来的值，获取公司的详情页面
    @Select("select * from message where CompanyName=#{CompanyName}")
    List<MessageInfo> getcompany(@Param("CompanyName") String CompanyName);


    //根据company页面传过来的值，获取公司的招聘页面
    @Select("select * from position where CompanyName=#{CompanyName};")
    List<MessageInfo> getcompanypos(@Param("CompanyName") String CompanyName);

    @Select("select * from position where CompanyName=#{CompanyName} and Function=#{Function};")
    List<MessageInfo> getcompanypselect(@Param("CompanyName") String CompanyName, @Param("Function") String Function);

}
