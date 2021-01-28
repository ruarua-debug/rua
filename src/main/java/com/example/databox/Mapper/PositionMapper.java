package com.example.databox.Mapper;

import com.example.databox.Entity.PositionInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PositionMapper {
    @Select("select * from position order by PositionID")
    List<PositionInfo> findAllPosition(Integer pageIndex,Integer pageSize);

    @Insert("INSERT INTO databox.position (PositionID, Position, Salary, Description, CompanyName, Function) " +
            "VALUES (#{PositionID}, #{Position}, #{Salary}, #{Description}, #{Description}, #{Function});\n")
    Integer addPositionInfo(PositionInfo positionInfo);

//    @Insert("insert into position " +
//            "(Position,Salary,Description，CompanyName，Function)" +
//            "values(#{Position},#{Salary},#{Description},#{CompanyName},#{Function})")
  //  Integer addPositionInfo(PositionInfo positionInfo);


    @Select("select * from position where PositionID=#{PositionID}")
    PositionInfo getPositionByid(Integer PositionID);

    @Update("update position set Position=#{Position},Salary=#{Salary},Description=#{Description},CompanyName=#{CompanyName},Function=#{Function} where PositionID=#{PositionID};")
    Integer updatePositionByID(PositionInfo positionInfo);

    @Select("select * from position")
    List<PositionInfo> getAllPosition(Integer pageIndex, Integer pageSize);

    @Select("select * from  where Position=#{Position}")
    List<PositionInfo> findPositionByID(Integer pageIndex, Integer pageSize, @Param("Position") String Position);

    @Delete("delete from position where PositionID=#{PositionID}")
    Integer deletePositionByID(PositionInfo positionInfo);

}


