package com.example.databox.Mapper;
import com.example.databox.Entity.ChartInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChartMapper {



     //数据挖掘
     //chart1图表展示  柱状图
     @Select("select AvgSalary from databox.chart where Position = \"数据挖掘\" order by AvgSalary  DESC limit 10;")
     List<Integer> getAvgSalary11();
     @Select("select PositionID from databox.company where Position = \"数据挖掘\" order by Salary  DESC limit 10;")
     List<Integer> getAvgSalary111();
     @Select("select Company from databox.company where Position = \"数据挖掘\" order by Salary  DESC limit 10;")
     List<String> getAvgSalary1111();

     //chart2 图表展示  饼状图
     @Select(" select count(Education) from databox.company where Position = \"数据挖掘\" group by Education;")
     List<Integer> getAvgSalary12();

     //chart3 图表展示  散点图
     @Select(" select count(City) from databox.company where Position = \"数据挖掘\"  group by City order by City;")
     List<Integer> getAvgSalary13();

     /**
      *
      * @return
      */
     //chart4 图表展示   倒置柱状图 position1
     @Select(" select Salary,Experience,Company from databox.company  where position =\"数据挖掘\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary141();
     @Select(" select Experience from databox.company  where position =\"数据挖掘\"  group by Experience order by Experience  DESC;")
     List<String> getAvgSalary143();
     @Select("select Salary,Experience,Company from databox.company  where position =\"人事经理\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary142();
//    @Select(" select Experience from databox.company  where position =\"人事经理\"  group by Experience order by Experience  DESC;")
//    List<String> getAvgSalary144();

     //chart5  南丁格尔玫瑰图
     @Select("select avg(Salary),City from databox.company where Position = \"数据挖掘\" group by City;\n")
     List<Integer> getSalary1City();

     @Select("select avg(Salary),City from databox.company where Position = \"人事经理\" group by City;\n")
     List<Integer> getSalary4City();

     @Select("select avg(Salary),City from databox.company where Position = \"C++游戏开发工程师\" group by City;\n")
     List<Integer> getSalary3City();

     @Select("select avg(Salary),City from databox.company where Position = \"web前端开发\" group by City;\n")
     List<Integer> getSalary2City();


     //chart6  南极坐标下的柱状图

     /**
      *
      * @return
      */
     //极坐标下柱状图  数据挖掘
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"上海\" group by City;\n")
     List<ChartInfo> getSalary411();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"北京\" group by City;\n")
     List<ChartInfo> getSalary412();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"南京\" group by City;\n")
     List<ChartInfo> getSalary413();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"广州\" group by City;\n")
     List<ChartInfo> getSalary414();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"成都\" group by City;\n")
     List<ChartInfo> getSalary415();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"杭州\" group by City;\n")
     List<ChartInfo> getSalary416();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"武汉\" group by City;\n")
     List<ChartInfo> getSalary417();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"数据挖掘\" and City = \"深圳\" group by City;\n")
     List<ChartInfo> getSalary418();
     //极坐标下柱状图  数据挖掘

     //极坐标下柱状图  人事经理
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"人事经理\" and City = \"上海\" group by City;\n")
     List<ChartInfo> getSalary441();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"人事经理\" and City = \"北京\" group by City;\n")
     List<ChartInfo> getSalary442();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"人事经理\" and City = \"南京\" group by City;\n")
     List<ChartInfo> getSalary443();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"人事经理\" and City = \"广州\" group by City;\n")
     List<ChartInfo> getSalary444();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"人事经理\" and City = \"成都\" group by City;\n")
     List<ChartInfo> getSalary445();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"人事经理\" and City = \"杭州\" group by City;\n")
     List<ChartInfo> getSalary446();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"人事经理\" and City = \"武汉\" group by City;\n")
     List<ChartInfo> getSalary447();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"人事经理\" and City = \"深圳\" group by City;\n")
     List<ChartInfo> getSalary448();
     //极坐标下柱状图  人事经理

     //极坐标下柱状图  C++
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"上海\" group by City;\n")
     List<ChartInfo> getSalary431();
     //极坐标下柱状图
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"北京\" group by City;\n")
     List<ChartInfo> getSalary432();
     //极坐标下柱状图
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"南京\" group by City;\n")
     List<ChartInfo> getSalary433();
     //极坐标下柱状图
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"广州\" group by City;\n")
     List<ChartInfo> getSalary434();
     //极坐标下柱状图
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"成都\" group by City;\n")
     List<ChartInfo> getSalary435();
     //极坐标下柱状图
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"杭州\" group by City;\n")
     List<ChartInfo> getSalary436();
     //极坐标下柱状图
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"武汉\" group by City;\n")
     List<ChartInfo> getSalary437();
     //极坐标下柱状图
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"C++游戏开发工程师\" and City = \"深圳\" group by City;\n")
     List<ChartInfo> getSalary438();
     //极坐标下柱状图  C++

     //极坐标下柱状图  Web
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"上海\" group by City;\n")
     List<ChartInfo> getSalary421();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"北京\" group by City;\n")
     List<ChartInfo> getSalary422();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"南京\" group by City;\n")
     List<ChartInfo> getSalary423();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"广州\" group by City;\n")
     List<ChartInfo> getSalary424();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"成都\" group by City;\n")
     List<ChartInfo> getSalary425();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"杭州\" group by City;\n")
     List<ChartInfo> getSalary426();
     @Select("select chart.MinSalary,chart.MaxSalary,chart.AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"武汉\" group by City;\n")
     List<ChartInfo> getSalary427();
     @Select("select MinSalary,MaxSalary,AvgSalary from databox.chart where Position = \"web前端开发\" and City = \"深圳\" group by City;\n")
     List<ChartInfo> getSalary428();
     //极坐标下柱状图  Web


     //总图
     @Select("select avg(Salary) from databox.company where Position = \"数据挖掘\" group by City")
     List<Integer> getAvgSalary1ByCity();
     @Select("select City from databox.company where Position = \"数据挖掘\" group by City")
     List<String> getAvgSalary11ByCity();//纵轴对应
     @Select("select avg(Salary) from databox.company where Position = \"C++游戏开发工程师\" group by City")
     List<Integer> getAvgSalary2ByCity();
     @Select("select avg(Salary) from databox.company where Position = \"web前端开发\" group by City")
     List<Integer> getAvgSalary3ByCity();
     @Select("select avg(Salary) from databox.company where Position = \"人事经理\" group by City")
     List<Integer> getAvgSalary4ByCity();




     //chart7  堆积面积图


     //chart8





//数据挖掘




     //2  人事经理
     @Select("select AvgSalary from databox.chart where Position = \"人事经理\"  order by AvgSalary  DESC limit 10;")
     List<Integer> getAvgSalary21();
     @Select("select Company from databox.company where Position = \"人事经理\" order by Salary  DESC limit 10;")
     List<String> getAvgSalary211();

//     @Select("select AvgSalary from databox.chart order by AvgSalary  DESC limit 10;")
//     List<Integer> getAvgSalary11();
//     @Select("select PositionID from databox.company order by Salary  DESC limit 10;")
//     List<Integer> getAvgSalary111();
//     @Select("select Company from databox.company order by Salary  DESC limit 10;")
//     List<String> getAvgSalary1111();
     @Select(" select count(Education) from databox.company where Position = \"人事经理\" group by Education;")
     List<Integer> getAvgSalary22();


     //chart3 图表展示  散点图
     @Select(" select count(City) from databox.company where Position = \"人事经理\"  group by City order by City;")
     List<Integer> getAvgSalary23();

     //chart4 图表展示  倒置柱状图
     @Select(" select Salary,Experience,Company from databox.company  where position =\"数据挖掘\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary241();

     @Select("select Salary,Experience,Company from databox.company  where position =\"人事经理\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary242();




     //3  C++游戏开发工程师
     @Select("select AvgSalary from databox.chart where Position = \"C++游戏开发工程师\"  order by AvgSalary  DESC limit 10;")
     List<Integer> getAvgSalary31();
     @Select("select Company from databox.company where Position = \"C++游戏开发工程师\" order by Salary  DESC limit 10;")
     List<String> getAvgSalary311();

     @Select(" select count(Education) from databox.company where Position = \"C++游戏开发工程师\" group by Education;")
     List<Integer> getAvgSalary32();


     //chart3 图表展示  散点图
     @Select(" select count(City) from databox.company where Position = \"C++游戏开发工程师\"  group by City order by City;")
     List<Integer> getAvgSalary33();

     //chart4 图表展示   倒置柱状图
     @Select(" select Salary,Experience,Company from databox.company  where position =\"C++游戏开发工程师\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary341();
     @Select("select Salary,Experience,Company from databox.company  where position =\"web前端开发\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary342();



     //4  web前端开发
     @Select("select AvgSalary from databox.chart where Position = \"web前端开发\"  order by AvgSalary  DESC limit 10;")
     List<Integer> getAvgSalary41();
     @Select("select Company from databox.company where Position = \"web前端开发\" order by Salary  DESC limit 10;")
     List<String> getAvgSalary411();

     @Select(" select count(Education) from databox.company where Position = \"web前端开发\" group by Education;")
     List<Integer> getAvgSalary42();


     //chart3 图表展示  散点图
     @Select(" select count(City) from databox.company where Position = \"web前端开发\"  group by City order by City;")
     List<Integer> getAvgSalary43();

     //chart4 图表展示   倒置柱状图
     @Select(" select Salary,Experience,Company from databox.company  where position =\"C++游戏开发工程师\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary441();
     @Select("select Salary,Experience,Company from databox.company  where position =\"web前端开发\"  group by Experience order by Experience  DESC;")
     List<Integer> getAvgSalary442();





     //后台管理
     @Select("select * from chart order by CityID")
     List<ChartInfo> findAllChart();
     //增加

     /**
      *
      * @param chartInfo chart页面字段的定义
      * @return
      */
     @Insert("insert into chart"+
             "(City,Position,Description,Company,MinSalary,MaxSalary,AvgSalary,Education,Experience,Number)"+
             "values(#{City}, #{Position}, #{Description}, #{Company}, #{MinSalary}, #{MaxSalary}, #{AvgSalary}, #{Education}, #{Experience},#{Number})")
     Integer addChartInfo(ChartInfo chartInfo);

     @Select("select * from chart where CityID=#{CityID}")
     ChartInfo findChartByID(Integer CityID);

     /**
      *
      * @param chartInfo chart页面字段的定义
      * @return
      */
     //
     @Update("update chart set City=#{City},Position=#{Position},Description=#{Description},Company=#{Company},MinSalary=#{MinSalary},MaxSalary=#{MaxSalary},AvgSalary=#{AvgSalary},Education=#{Education},Experience=#{Experience},Number=#{Number} where CityID=#{CityID};")
     Integer updateChartByID(ChartInfo chartInfo);

     //分页返值
     @Select("select * from chart")
     List<ChartInfo> getAllChart(Integer pageIndex, Integer pageSize);

     @Select("select * from chart where City=#{City}")
     List<ChartInfo> findChartByChartID(Integer pageIndex, Integer pageSize, @Param("City") String City);
     //删除
     @Delete("delete from chart where CityID=#{CityID}")
     Integer deleteChartByID(ChartInfo chartInfo);


     /**
      *
      * @return
      */
     //position1图表表格
     @Select("select PositionID,City,Position,Salary from company where position='数据挖掘' group by city limit 10")
     List<ChartInfo> showcitydata();

     @Select("select CityID,City,Position,MinSalary,MaxSalary,AvgSalary from chart where position='数据挖掘' group by city;")
     List<ChartInfo> showsalary();

     //position2图表表格
     @Select("select PositionID,Position,Company,Salary from company where position='人事经理' limit 10")
     List<ChartInfo> showrenshi();
     @Select("select CityID,Position,Education from chart where position='人事经理' limit 6")
     List<ChartInfo> showrenxue();


     //postion3图表表格
     @Select("select CityID,Position,Experience from chart where position='web前端开发' or 'C++游戏开发师' limit 10;")
     List<ChartInfo> showshuren();
     @Select("select CityID,City,Position,AvgSalary from chart where position='C++游戏开发师' group by city;")
     List<ChartInfo> showc();

     //postion4图表表格
     @Select("select CityID,City,Position,MinSalary,MaxSalary,AvgSalary from chart where position='web前端开发' group by city;")
     List<ChartInfo> showwebsalary();
}
