package com.example.databox.Mapper;

import com.example.databox.Entity.ChartInfo;
import com.example.databox.Entity.CityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommendMapper {
    //根据城市和职位查询
    @Select("select * from chart where City = #{City} and Position = #{Position}")
    List<ChartInfo> getCityPosition(Integer pageIndex, Integer pageSize, @Param("City") String City, @Param("Position") String Position);

    @Select("select * from chart where City = #{City}")
    List<ChartInfo> getCity(Integer pageIndex, Integer pageSize,@Param("City") String City);

    @Select("select * from chart order by CityID")
    List<ChartInfo> getAllCityPosition(Integer pageIndex, Integer pageSize);

//根据经验和学历查询
    @Select("select * from chart where Experience =#{Experience} and Education = #{Education}")
    List<ChartInfo> getExperienceEducation(String Experience,String Education);

    @Select("select * from chart where Experience =#{Experience}")
    List<ChartInfo> getExperience(String Experience);

    @Select("select * from chart where CityID = #{CityID}")
    List<ChartInfo> getAllExperienceEducation();

//根据工资查询
    @Select("select * from city where AvgSalary between MinSalary=#{MinSalary} and MaxSalary=#{MaxSalary}")
    List<ChartInfo> getSalary(String Salary);


}
