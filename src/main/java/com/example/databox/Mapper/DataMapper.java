package com.example.databox.Mapper;

import com.example.databox.Entity.DataInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {

    // @Select("select* from user order by UserID")
    //List<DataInfo> getAlldata;
    @Insert("insert into user (UserID,UserName,UserPhone,Password,User_image_url)\n" +
            "values(#{UserID},#{UserName},#{UserPhone},#{Password},#{User_image_url});\n")
            Integer saveData(DataInfo dataInfo) ;

    @Select("select* from user order by UserID")
            List<DataInfo> getAllUser();


    //chart1图表展示
    @Select("select Company,AvgSalary from city \n" +
            "where Position like '数据挖掘' order by AvgSalary limit 10;")
            List<Integer> getAvgSalary();

}
