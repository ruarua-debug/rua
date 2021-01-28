package com.example.databox.Controller;

import Util.FileUtilCity;
import com.example.databox.Entity.CityInfo;
import com.example.databox.Mapper.CityMapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping("data")

public class CityController {

    @Autowired
    private CityMapper cityMapper;

//    @GetMapping("/city")
//    public String getAllCity(Model model) {
//        List<CityInfo> cityInfoLists = cityMapper.findAllCity();
//        model.addAttribute("City", cityInfoLists);
//        return "city";
//    }
//添加
    @GetMapping("/addcity")
    public String addCityInfo(Model model) {
        return "addcity";
    }

    @PostMapping("/addcity")
    public String addCityInfo(CityInfo cityInfo,@RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(), filePath3, fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cityInfo.setImage(fileName3);

        int i = cityMapper.addCityInfo(cityInfo);
        return "redirect:/data/city";
    }
//更新
    @GetMapping("/updatecity/{id}")
    public String updatecityPage(@PathVariable("id") Integer CityID, Model model) {
        CityInfo cityInfo = cityMapper.findCityByID(CityID);
        model.addAttribute("city", cityInfo);
        return "updatecity";
    }

    @PostMapping("/updatecity")
    public String updateCityByID(CityInfo cityInfo,@RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(), filePath3, fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cityInfo.setImage(fileName3);

        int i = cityMapper.updateCityByID(cityInfo);
        return "redirect:/data/city";
    }
//分页遍历
    @RequestMapping("/city")
    public String getCityID(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            @RequestParam(value = "City", defaultValue = "") String City, Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CityInfo> lists = null;
        PageInfo<CityInfo> cityInfoLists = null;
        if (City.isEmpty()) {
            lists = cityMapper.getAllCity(pageIndex, pageSize);
        } else {
            lists = cityMapper.findCityByCityID(pageIndex, pageSize, City);
        }
        PageInfo<CityInfo> pages = new PageInfo<>(lists);
        model.addAttribute("data", pages);
        model.addAttribute("City", City);
        return "city";
    }
//删除
    @GetMapping("/deletecity/{id}")
    public String deletecityPage(@PathVariable("id") Integer CityID, Model model) {
        CityInfo cityInfo = cityMapper.findCityByID(CityID);
        model.addAttribute("city", cityInfo);
        return "deletecity";
    }

    @PostMapping("/deletecity")
    public String deleteCityByID(CityInfo cityInfo,@RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(), filePath3, fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cityInfo.setImage(fileName3);

        int i = cityMapper.deleteCityByID(cityInfo);
        return "redirect:/data/city";
    }

//后台
    @GetMapping("/backstagecity")
    public String pagebackstagecity() {
        return "backstagecity";
    }

//前端城市返值
    @GetMapping("/getcity/{id}")
    public String Pagegetcity(@PathVariable("id") Integer Number, Model model) {
        String City = "";
        if (Number == 1)
            City = "北京";
        if (Number == 2)
            City = "上海";
        if (Number == 3)
            City = "广州";
        if (Number == 4)
            City = "深圳";
        if (Number == 5)
            City = "杭州";
        if (Number == 6)
            City = "成都";
        if (Number == 7)
            City = "武汉";
        if (Number == 8)
            City = "南京";
        List<CityInfo> lists=cityMapper.getcity(City);
        model.addAttribute("city",lists);
        model.addAttribute("nums",City);
        return "citybeijing";
    }


    //

//查询
//    @GetMapping("/postcity")
//    public String getAllCitys(Model model) {
//    List<CityInfo> lists=cityMapper. findAllCitys();
//        model.addAttribute("city",lists);
//        return "citybeijing";
//    }

    @RequestMapping("/postcity")
    public String getAllCitys(@RequestParam("City") String City,
                              @RequestParam(value="Position",defaultValue = "") String Position,Model model){
        List<CityInfo> lists = null;
        if (City.isEmpty()&&Position.isEmpty()) {
            lists = cityMapper.getAllPosition();
        }
                    else if(City.isEmpty()&&Position.isEmpty()){
                        lists = cityMapper.findAllPosition(City);
            }
                 else {
                    lists = cityMapper.findCityByPositions(City,Position);
                }
        PageInfo<CityInfo> pages = new PageInfo<>(lists);
        model.addAttribute("city",lists);
        model.addAttribute("nums",City);
        model.addAttribute("pos",Position);
        return "citybeijing";
    }


}
