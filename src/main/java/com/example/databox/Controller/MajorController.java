package com.example.databox.Controller;





import Util.FileUtilCity;
import com.example.databox.Entity.MajorInfo;
import com.example.databox.Mapper.MajorMapper;

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
public class MajorController {

    @Autowired
    private MajorMapper majorMapper;

//    @GetMapping("/city")
//    public String getAllCity(Model model) {
//        List<CityInfo> cityInfoLists = cityMapper.findAllCity();
//        model.addAttribute("City", cityInfoLists);
//        return "city";
//    }

    @GetMapping("/addmajor")
    public String addMajorInfo(Model model) {
        return "addmajor";
    }

    @PostMapping("/addmajor")
    public String addMajorInfo(MajorInfo majorInfo, @RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 =System.currentTimeMillis()+fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(),filePath3,fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存文件到数据库
        majorInfo.setImage(fileName3);
        int i = majorMapper.addMajorInfo(majorInfo);
        return "redirect:/data/major";
    }


    @GetMapping("/updatemajor/{id}")
    public String updatemajorPage(@PathVariable("id") Integer MajorID, Model model) {
        MajorInfo majorInfo = majorMapper.findMajorByID(MajorID);
        model.addAttribute("major", majorInfo);
        return "updatemajor";
    }

    @PostMapping("/updatemajor")
    public String updateMajorByID(MajorInfo majorInfo,@RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(), filePath3, fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        majorInfo.setImage(fileName3);

        int i = majorMapper.updateMajorByID(majorInfo);
        return "redirect:/data/major";
    }



    @RequestMapping("/major")
    public String getMajorID(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                            @RequestParam(value="Major",defaultValue = "") String Major, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<MajorInfo> lists=null;
        PageInfo<MajorInfo> majorInfoLists=null;
        if(Major.isEmpty()){
            lists=majorMapper.getAllMajor(pageIndex,pageSize);
        }else{
            lists=majorMapper.findMajorByMajorID(pageIndex,pageSize,Major);
        }
        PageInfo<MajorInfo> pages=new PageInfo<>(lists);
        model.addAttribute("data",pages);
        model.addAttribute("Major",Major );
        return "major";
    }

    @GetMapping("/deletemajor/{id}")
    public String deletemajorPage(@PathVariable("id") Integer MajorID, Model model) {
        MajorInfo majorInfo = majorMapper.findMajorByID(MajorID);
        model.addAttribute("major", majorInfo);
        return "deletemajor";
    }

    @PostMapping("/deletemajor")
    public String deleteMajorByID(MajorInfo majorInfo,@RequestParam("filepic") MultipartFile file) {
        String fileName3 = file.getName();
        String filePath3 = FileUtilCity.getUpLoadFilePath();
        fileName3 = System.currentTimeMillis() + fileName3;

        try {
            FileUtilCity.uploadFile(file.getBytes(), filePath3, fileName3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        majorInfo.setImage(fileName3);

        int i = majorMapper.deleteMajorByID(majorInfo);
        return "redirect:/data/major";
    }

    //自己网页
    @GetMapping("/getmajor/{id}")
    public String Pagegetmajor(@PathVariable("id") Integer Number, Model model) {
        String Major = "";
        if (Number == 1)
            Major = "工商管理";
        if (Number == 2)
            Major = "人力资源管理";
        if (Number == 3)
            Major = "财务管理";
        if (Number == 4)
            Major = "信息系统和信息管理";
        if (Number == 5)
            Major = "软件工程";
        if (Number == 6)
            Major = "计算机科学";
        List<MajorInfo> lists=majorMapper. getmajor(Major);
        model.addAttribute("major",lists);
        model.addAttribute("nums",Major);
        return "majorcaiguan";
    }

    //查询
    @GetMapping("/postmajor")
    public String getAllMajors(Model model) {
        List<MajorInfo> lists=majorMapper. findAllMajors();
        model.addAttribute("major",lists);
        return "majorcaiguan";
    }

    @PostMapping("/postmajor")
    public String getAllMajors(@RequestParam("Major") String Major,
                              @RequestParam(value="Position",defaultValue = "") String Position,Model model){
        List<MajorInfo> lists = null;
        if (Position.isEmpty()) {
            lists = majorMapper.getAllPosition(Major);
        } else {
            lists = majorMapper.findMajorByPositions(Major,Position);
        }
        model.addAttribute("major",lists);
        model.addAttribute("nums",Major);
        model.addAttribute("pos",Position);
        return "majorcaiguan";
    }

}
