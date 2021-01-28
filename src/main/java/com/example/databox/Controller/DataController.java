package com.example.databox.Controller;

import com.example.databox.Entity.DataInfo;
import com.example.databox.Mapper.CompanyMapper;
import com.example.databox.Mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.util.List;

@Controller
@RequestMapping("data")
public class DataController {
    @Autowired
    private DataMapper dataMapper;


    @GetMapping("/blank")
    public String blankPage() {
        return "blank";
    }
    @GetMapping("/findpassword")
    public String findpasswordPage() {
        return "blank";
    }
    @GetMapping("/login")
    public String loginpasswordPage() {
        return "login";
    }



    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/backstage")
    public String backstagePage() {
        return "backstage";
    }

    @GetMapping("/adduser")
    public String adduserPage() {
        return "adduser";
    }

    @PostMapping("/user")
    public  String addDataInfo(DataInfo dataInfo){
        int i = dataMapper.saveData(dataInfo);
        return "redirect:data/adduser";
    }
    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/index1")
    public String index1Page() {
        return "index1";
    }
    @GetMapping("/a")
    public String aPage() {
        return "a";
    }

      @GetMapping("/index2")
    public String index2Page() {
        return "index2";
    }
    @GetMapping("/deleteposition")
    public String deletepositionPage() {
        return "deleteposition";
    }

    @GetMapping("/index3")
    public String index3Page() {
        return "index3";
    }

    @GetMapping("/index4")
    public String index4Page() {
        return "index4";
    }



    @GetMapping("/picture")
    public String picturePage() {
        return "picture";
    }

    //chart1图表展示
//    @GetMapping("/chart1")
//    public String RankPage(Model model){
//        List<Integer> ranklists=DataMapper.getAvgSalary();
//        model.addAttribute("rank",ranklists);
//        return "chart1";
//    }

    @GetMapping("/datatables")
    public String datatablesPage() {
        return "datatables";
    }

    @GetMapping("/store")
    public String srorePage() {
        return "store";
    }




    @GetMapping("/collections")
    public String collectionsPage() {
        return "collections";
    }


    @GetMapping("/jobdetail")
    public String jobdetailPage() {
        return "jobdetail";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }




}
