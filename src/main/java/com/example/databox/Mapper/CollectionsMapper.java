package com.example.databox.Mapper;

import com.example.databox.Entity.CollectionsInfo;
import com.example.databox.Entity.CompanyInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
    @Mapper
    public interface CollectionsMapper {
        @Insert( "INSERT INTO collections" +
                "(UserID, PositionID) " +
                "VALUES( #{UserID}, #{PositionID})" )
        Integer addshopping(Integer UserID, Integer PositionID);

        @Select("SELECT CollectionsID,collections.PositionID,Company,Position,City,Education,Experience,Salary FROM databox.company join databox.user join databox.collections\n" +
                "on company.PositionID=collections.PositionID and collections.UserID=user.UserID and user.UserID=#{UserID};")
        List<CollectionsInfo> getAllcollections(Integer UserID);

        @Select("select * from databox.collections where PositionID=#{PositionID}")
        CollectionsInfo getCompany(Integer PositionID);

        @Select("SELECT count(Position),Position,Company,Salary FROM databox.company join databox.user join databox.collections\n" +
                "on company.PositionID=collections.PositionID and collections.UserID=user.UserID \n" +
                "group by Position\n" +
                "order by count(Position) DESC,Salary DESC ;")
        List<CollectionsInfo> getcollections(Integer UserID);

        @Delete("delete from collections where CollectionsID=#{CollectionsID}")
        Integer dell(Integer CollectionsID);

        @Select(" select * from collections join company where collections.PositionID=company.PositionID and company.PositionID=#{PositionID}")
        CollectionsInfo getdetailByid(Integer PositionID);

    }

