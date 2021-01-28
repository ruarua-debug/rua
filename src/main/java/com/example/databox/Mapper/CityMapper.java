package com.example.databox.Mapper;

import com.example.databox.Entity.CityInfo;
import org.apache.ibatis.annotations.*;
import org.thymeleaf.expression.Lists;

import java.util.List;

@Mapper
public interface CityMapper {

     @Select("select * from city order by CityID")
     List<CityInfo> findAllCity();
//增加
     @Insert("insert into city"+
     "(Image,City,Position, Description,Company)"+
     "values(#{Image},#{City}, #{Position}, #{Description}, #{Company})")
     Integer addCityInfo(CityInfo cityInfo);

     @Select("select * from city where CityID=#{CityID}")
     CityInfo findCityByID(Integer CityID);
//修改
     @Update("update city set Image=#{Image},City=#{City},Position=#{Position},Description=#{Description},Company=#{Company} where CityID=#{CityID};")
     Integer updateCityByID(CityInfo cityInfo);

     //分页返值
     @Select("select * from city")
     List<CityInfo> getAllCity(Integer pageIndex, Integer pageSize);

     @Select("select * from city where City=#{City}")
     List<CityInfo> findCityByCityID(Integer pageIndex, Integer pageSize, @Param("City") String City);
//删除
     @Delete("delete from city where CityID=#{CityID}")
     Integer deleteCityByID(CityInfo cityInfo);

//前端城市返值
     @Select("select * from city where City=#{City}")
     List<CityInfo> getcity(@Param("City") String City);

//查询
     @Select("select * from city")
     List<CityInfo>  getAllPosition();

     @Select("select * from city where City=#{City}")
     List<CityInfo> findAllPosition(@Param("City") String City);

     @Select("select * from city where City=#{City} and Position=#{Position}")
     List<CityInfo> findCityByPositions(@Param("City") String City, @Param("Position") String Position);

}
