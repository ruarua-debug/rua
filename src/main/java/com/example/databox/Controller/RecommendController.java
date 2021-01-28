package com.example.databox.Controller;

import com.example.databox.Entity.ChartInfo;
import com.example.databox.Mapper.RecommendMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("data")
public class RecommendController {
    @Autowired
    private RecommendMapper recommendMapper;

    @GetMapping("/recommend1")
   public String recommend1Page(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "City",defaultValue = "" ) String City,
                                @RequestParam(value = "Position",defaultValue = "") String Position,
                              //  HttpSession session, ChartInfo chartInfo,
                                Model model){
      //  ChartInfo chartInfo1 = recommendMapper.getCityPosition(City,Position);
      //  if (!City.isEmpty()&&!Position.isEmpty()){
        //    return "recommend2";
        //    session.setAttribute("ChartInfo",chartInfo);
       // }else
        //    return "recommend1";
        PageHelper.startPage(pageIndex, pageSize);
        List<ChartInfo> lists = null;
        PageInfo<ChartInfo> listInfo = null;
        if (City.isEmpty() && Position.isEmpty()) {
            lists = recommendMapper.getAllCityPosition(pageIndex, pageSize);
        } else if (!City.isEmpty() && Position.isEmpty()) {
            lists = recommendMapper.getCity(pageIndex, pageSize, City);
        } else {
            lists = recommendMapper.getCityPosition(pageIndex, pageSize, City, Position);
        }
        PageInfo<ChartInfo> pages = new PageInfo<>(lists);
        List<ChartInfo> ChartInfoList = recommendMapper.getAllCityPosition(pageIndex, pageSize);
        model.addAttribute("City", City);
        model.addAttribute("Position", Position);
        model.addAttribute("recommend1", pages);
        model.addAttribute("ChartInfoList",ChartInfoList);
        return "log1";
    }




}
