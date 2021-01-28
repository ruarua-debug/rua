package com.example.databox.Mapper;

import com.example.databox.Entity.MajorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface MajorMapper {

    @Select("select * from major order by MajorID")
    List<MajorInfo> findAllMajor();

    @Insert("insert into major"+
            "(Image,Major,Position,Description,City,Salary)"+
            "values(#{Image},#{Major},#{Position}, #{Description},#{City},#{Salary})")
    Integer addMajorInfo(MajorInfo majorInfo);

    @Select("select * from major where MajorID=#{MajorID}")
    MajorInfo findMajorByID(Integer MajorID);

    @Update("update major set Image=#{Image}, Major=#{Major},Position=#{Position},Description=#{Description},City=#{City},Salary=#{Salary} where MajorID=#{MajorID};")
    Integer updateMajorByID(MajorInfo majorInfo);

    @Select("select * from major")
    List<MajorInfo> getAllMajor(Integer pageIndex, Integer pageSize);

    @Select("select * from major where Major=#{Major}")
    List<MajorInfo> findMajorByMajorID(Integer pageIndex, Integer pageSize, @Param("Major") String Major);

    @Delete("delete from major where MajorID=#{MajorID}")
    Integer deleteMajorByID(MajorInfo majorInfo);
    //专业返值
    @Select("select * from major where Major=#{Major}")
    List<MajorInfo> getmajor(@Param("Major") String Major);
    //查询
    @Select("select * from major where Major=#{Major} and Position=#{Position}")
    List<MajorInfo> findAllMajors();

    @Select("select * from major where Major=#{Major}")
    List<MajorInfo> getAllPosition(@Param("Major") String Major);

    @Select("select * from major where Major=#{Major} and Position=#{Position}")
    List<MajorInfo> findMajorByPositions(@Param("Major") String Major, @Param("Position") String Position);

}

