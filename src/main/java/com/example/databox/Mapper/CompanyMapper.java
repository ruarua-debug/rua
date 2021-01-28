package com.example.databox.Mapper;

import com.example.databox.Entity.CompanyInfo;
import com.example.databox.Entity.MessageInfo;
import com.example.databox.Entity.PositionInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
  //审核
  //查找所有未通过审核
  @Select("SELECT * FROM company where c_status=0")
  List<CompanyInfo> UnpassPosition(Integer pageIndex, Integer pageSize);
  //查找所有通过审核
  @Select("SELECT * FROM company where c_status=1")
  List<CompanyInfo> passPosition(Integer pageIndex, Integer pageSize);
  //公司名称模糊查询未通过审核
  @Select("SELECT * FROM company where Company like '%${Company}%' and c_status=0")
  List<CompanyInfo> findPosition0(Integer pageIndex, Integer pageSize,String Company);
  //公司名称模糊查询通过审核
  @Select("SELECT * FROM company where Company like '%${Company}%' and c_status=1")
  List<CompanyInfo> findPosition1(Integer pageIndex, Integer pageSize,String Company);



  //审核 修改审核状态
  @Update("UPDATE company SET c_status=#{c_status} WHERE positionID=#{positionID};")
  Integer updatestatus(CompanyInfo companyInfo);
  //根据id查找
  @Select("select * from company where positionID=#{positionID}")
  CompanyInfo findPositionByID(Integer positionID);
  //审核结束

  //职位展示
  @Select("SELECT * FROM company where c_status=1")
  List<CompanyInfo> getallPostion1(Integer pageIndex,Integer pageSize);


  //职位展示结束



  //公司注册
  @Insert("INSERT INTO databox.company (Company, c_password, Email) VALUES (#{Company}, #{c_password}, #{Email});")
  Integer addCompany(CompanyInfo companyInfo);
  //公司登录
  @Select("select * from databox.company where Email = #{Email} and c_password = #{c_password};")
  CompanyInfo companyLogin(String Email, String c_password);

  //根据company页面传过来的值，获取公司的招聘页面
  @Select("select * from position where CompanyName=#{CompanyName};")
  List<MessageInfo> getcompanypos(@Param("CompanyName") String CompanyName);

  @Select("select * from position where CompanyName=#{CompanyName} and Function=#{Function};")
  List<MessageInfo> getcompanypselect(@Param("CompanyName") String CompanyName, @Param("Function") String Function);

  @Insert(
          "INSERT INTO `databox`.`company` (`PositionID`, `Company`, `Url`,`Position`, `City`, `Function`, `Education`, `Experience`, `Description`,`Salary`, `c_status`) "+
                  "VALUES (#{PositionID}, #{Company}, #{Url},#{Position}, #{City}, #{Function}, #{Education}, #{Experience}, #{Description}, #{Salary},#{c_status});"
  )
  Integer savePostJob(CompanyInfo companyInfo);

  @Select("SELECT * FROM company where PositionID=#{PositionID}")
  CompanyInfo getContent(Integer PositionID);

  //找回密码
  @Select("select * from databox.company where Company = #{Company} and Email = #{Email}")
  CompanyInfo findpwd1(String Company, String Email);
  @Update("update databox.company set c_password=#{c_password} where PositionID=#{PositionID}")
  Integer findpwd2(String c_password, Integer PositionID);

  //公司查看已通过
  @Select("select * from databox.company where Company=#{Company} and c_status=1")
  List<CompanyInfo> passallPostion(Integer pageIndex, Integer pageSize,@Param("Company") String Company);

  //公司查看未通过
  @Select("select * from databox.company where Company=#{Company} and c_status =0 ")
  List<CompanyInfo> unpassallPostion(Integer pageIndex, Integer pageSize,@Param("Company") String Company);

  @Delete("delete from databox.company where PositionID=#{PositionID}")
  Integer deleName(CompanyInfo companyInfo);




  //收藏
  @Insert( "INSERT INTO collections" +
          "(UserID, PositionID) " +
          "VALUES( #{UserID}, #{PositionID})" )
  Integer addshopping(Integer UserID, Integer PositionID);


  //职位展示
  @Select("SELECT * FROM company where c_status=1")
  List<CompanyInfo> getallPostion11(Integer pageIndex, Integer pageSize);

  @Select("select * from company where Position=#{Position}")
  List<CompanyInfo> findPositionByPosi(Integer pageIndex, Integer pageSize, String Position);


  //多条件查询
  String QUERY_CODE_SQL="<if  test= \"Position != null and Position != ''\">  AND Position=#{Position} </if>" +
          "<if  test= \"s1 != null and s1 != ''\">  AND Salary Between #{s1} and #{s2} </if>" +
          "<if  test= \"Education != null and Education != ''\">  AND Education=#{Education} </if>" +
          "<if  test= \"Experience != null and Experience != ''\">  AND Experience=#{Experience} </if>" +
          "<if  test= \"City != null and City != ''\">  AND City=#{City} </if>";
  @Select({"<script> SELECT * FROM company WHERE 1=1" + QUERY_CODE_SQL + " </script>"})
  List<CompanyInfo> findByConditions(Integer pageIndex,
                                     Integer pageSize,
                                     @Param("Position") String Position,
                                     @Param("s1") String s1,
                                     @Param("s2") String s2,
                                     @Param("Education") String Education,
                                     @Param("Experience") String Experience,
                                     @Param("City") String City);

  String QUERY_CODE="<if  test= \"Position != null and Position != ''\">  AND Position=#{Position} </if>" +
          "<if  test= \"Education != null and Education != ''\">  AND Education=#{Education} </if>" +
          "<if  test= \"Experience != null and Experience != ''\">  AND Experience=#{Experience} </if>" +
          "<if  test= \"City != null and City != ''\">  AND City=#{City} </if>";
  @Select({"<script> SELECT * FROM company WHERE 1=1" + QUERY_CODE + " </script>"})
  List<CompanyInfo> getnosalary(Integer pageIndex,
                                Integer pageSize,
                                @Param("Position") String Position,
                                @Param("Education") String Education,
                                @Param("Experience") String Experience,
                                @Param("City") String City);



  //职位展示结束

  //考拉公司页面
  //根据position页面传过来的值，获取公司的详情页面
  @Select("select * from databox.company where PositionID=#{PositionID}")
  CompanyInfo getCompany(Integer PositionID);


  //首页热门职位
  @Select("select company.Position,company.Company,company.PositionID,company.Salary,company.City,company.Education,company.Experience from\n" +
          "collections Left join company ON collections.PositionID= company.PositionID\n" +
          "group by company.position\n" +
          "order by count(collections.PositionID) limit 6;")
  List<CompanyInfo> gethotjob();

  //后台管理
  @Select("SELECT * FROM company where c_status=1 and Position=#{Position}")
  List<CompanyInfo> selectPosition(Integer pageIndex, Integer pageSize,String Position);

  @Select("select * from company where PositionID=#{PositionID}")
  CompanyInfo getPositionByid(Integer PositionID);
  //后台新增
  @Insert("INSERT INTO company (PositionID, Company,Url,Position,City,Function,Education,Experience, Description,Salary) " +
          "VALUES (#{PositionID}, #{Company},#{Url},#{Position}, #{City}, #{Function}, #{Education},#{Experience},#{Description},#{Salary});\n")
  Integer addPosition(CompanyInfo companyInfo);
  //后台删除
  @Delete("delete from company where PositionID=#{PositionID}")
  Integer deletePositionByID(CompanyInfo companyInfo);
  //后台修改
  @Update("update company set Company=#{Company},Url=#{Url},Position=#{Position},City=#{City},Function=#{Function},Education=#{Education},Experience=#{Experience}, Description=#{Description},Salary=#{Salary} where PositionID=#{PositionID}")
  Integer updatePositionByID(CompanyInfo companyInfo);


}
