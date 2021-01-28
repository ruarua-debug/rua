package com.example.databox.Controller;

import com.example.databox.Entity.CompanyInfo;
import com.example.databox.Entity.MessageInfo;
import com.example.databox.Entity.PositionInfo;
import com.example.databox.Entity.UserInfo;
import com.example.databox.Mapper.CompanyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("data")
public class CompanyController {
    @Autowired
    private CompanyMapper companyMapper;
    //审核
    //所有未通过审核
    //根据公司名称 条件查询未通过审核的公司
    @RequestMapping("/checkposition")
    public String getposition(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                              @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                              @RequestParam(value="Company",defaultValue = "") String Company,
                              Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CompanyInfo> lists = null;
        PageInfo<CompanyInfo> InfoLists = null;
        if (Company.isEmpty()) {
            lists = companyMapper.UnpassPosition(pageIndex, pageSize);//无条件
        } else {
            lists = companyMapper.findPosition0(pageIndex, pageSize,Company);//条件
        }
        PageInfo<CompanyInfo> pages = new PageInfo<>(lists);
        model.addAttribute("posi", pages);
        model.addAttribute("Company", Company);
        return "checkposition";
    }

    //所有通过审核
    //根据公司名称 条件查询已通过审核
    @RequestMapping("/passposition")
    public String passposition(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                               @RequestParam(value="Company",defaultValue = "") String Company,
                               Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CompanyInfo> lists = null;
        PageInfo<CompanyInfo> InfoLists = null;
        if (Company.isEmpty()) {
            lists = companyMapper.passPosition(pageIndex, pageSize);//无条件
        } else {
            lists = companyMapper.findPosition1(pageIndex, pageSize,Company);//条件
        }
        PageInfo<CompanyInfo> pages = new PageInfo<>(lists);
        model.addAttribute("posi", pages);
        model.addAttribute("Company", Company);
        return "passposition";
    }
    //查看职位详情
    @GetMapping("/positiondetail/{id}")
    public  String positiondetail(@PathVariable("id")Integer PositionID, Model model){
        CompanyInfo companyInfo = companyMapper.findPositionByID(PositionID);
        model.addAttribute("posi",companyInfo);
        return "positiondetail";
    }
    //修改审核状态
    @PostMapping("/positiondetail")
    public String positiondetail(CompanyInfo companyInfo){
        companyMapper.updatestatus(companyInfo);
        return "redirect:/data/checkposition";
    }
//审核结束



    //公司登录
    @GetMapping("/login2")
    public String login2(){
        return "login2";
    }

    @PostMapping("/login2")
    @ResponseBody()
    public String login2(@RequestParam("Email") String Email,
                         @RequestParam("c_password") String c_password,
                         HttpSession session) {
        CompanyInfo companyInfo = companyMapper.companyLogin(Email, c_password);
        if (companyInfo != null) {
            session.setAttribute("user", companyInfo);
            return "1";
        } else {
            return "0";
        }
    }
    //公司注册
    @GetMapping("/register2")
    public String register2() {
        return "register2";
    }

//    @PostMapping("/register2")
//    public String register2(CompanyInfo companyInfo){
//        int i = companyMapper.addCompany(companyInfo);
//        return "redirect:/data/login2"; }

    @PostMapping("/register2")
    @ResponseBody()
    public String register2(CompanyInfo companyInfo){
        int i = companyMapper.addCompany(companyInfo);
        if(i==1){
            return "1";
        }else{
            return "0";}
    }

    @GetMapping("/post")
    public String pagePostJob() {
        return "post";
    }

    @PostMapping("/post")
    @ResponseBody()
    public String pagecompanyadd(CompanyInfo companyInfo, HttpSession session){
        session.setAttribute("user",companyInfo);
        int i = companyMapper.savePostJob(companyInfo);
        if(i==1){
            return "1";
        }else{
            return "0";}
    }
    //找回密码
    @GetMapping("/findpwd1")
    public String findpwd1(){
        return "findpwd1";
    }

    @PostMapping("/findpwd1")
    public String findpwd1(@RequestParam("Company") String Company,
                           @RequestParam("Email") String Email,
                           HttpSession session){
        CompanyInfo companyInfo = companyMapper.findpwd1(Company,Email);
        if (companyInfo!=null){
            session.setAttribute("changeUInfo",companyInfo);
            return "redirect:/data/findpwd2";
        }
        return "redirect:/data/findpwd1";
    }
    @GetMapping("/findpwd2")
    public String findpwd2(HttpSession session){
        return "findpwd2";
    }
    @PostMapping("/findpwd2")
    public String findpwd2(@RequestParam("c_password") String c_password,
                           HttpSession session){
        CompanyInfo companyInfo =(CompanyInfo)session.getAttribute("changeUInfo");
        int i = companyMapper.findpwd2(c_password,companyInfo.getPositionID());
        return "redirect:/data/login2";
    }

    //公司查看未通过
    @RequestMapping("/personal")
    public String personal(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                           @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                           Model model,HttpSession session){
        PageHelper.startPage(pageIndex, pageSize);
        List<CompanyInfo> lists = null;
        PageInfo<CompanyInfo> InfoLists = null;
        CompanyInfo companyInfo= (CompanyInfo) session.getAttribute("user");
        lists=companyMapper.unpassallPostion(pageIndex, pageSize,companyInfo.getCompany());
        PageInfo<CompanyInfo> pages = new PageInfo<>(lists);
        model.addAttribute("posi", pages);
        return "personal";
    }
    //公司查看已通过
    @GetMapping("/personal1")
    public String personal1(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                            Model model,HttpSession session){
        PageHelper.startPage(pageIndex, pageSize);
        List<CompanyInfo> lists = null;
        PageInfo<CompanyInfo> InfoLists = null;
        CompanyInfo companyInfo= (CompanyInfo) session.getAttribute("user");
        lists=companyMapper.passallPostion(pageIndex, pageSize,companyInfo.getCompany());
        PageInfo<CompanyInfo> pages = new PageInfo<>(lists);
        model.addAttribute("posi",pages);
        return "personal1";
    }

    @RequestMapping("/dele")
    @ResponseBody()
    public String dele(CompanyInfo companyInfo) {
        int i=companyMapper.deleName(companyInfo);
        if(i==1){
            return "1";
        }else{
            return "0";}
    }





    //    收藏
    @PostMapping("/detail")
    public String computer(HttpSession session, @RequestParam("PositionID") Integer PositionID){
        UserInfo userInfo=(UserInfo) session.getAttribute("UserInfo");
        Integer UserID=userInfo.getUserID();
        Integer i=companyMapper.addshopping(UserID, PositionID);
        return "redirect:/user/shoppingcar";
    }

    @GetMapping("/class/detail/{id}")
    public String pagessingle(@PathVariable("id") Integer PositionID, Model model){
        CompanyInfo companyInfo =companyMapper.getCompany( PositionID );
        model.addAttribute("pro",companyInfo);
        return "detail";
    }




//职位展示页面
    @GetMapping("/position/{id}")
    public String pagePosition(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                                @RequestParam(value="pageSize",defaultValue = "12") Integer pageSize,
                                @PathVariable("id") Integer Number,
                                HttpSession session, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<CompanyInfo> lists = null;
        PageInfo<CompanyInfo> cityInfoLists = null;
        String Position="";
        if(Number == 1)
            Position="数据挖掘";
        if(Number == 2)
            Position="算法工程师";
        if(Number == 3)
            Position="人事经理";
        if(Number == 4)
            Position="项目经理";
        if(Number == 5)
            Position="web前端开发";
        if(Number == 6)
            Position="UI设计师";
        if(Number == 7)
            Position="C++游戏开发工程师";
        if(Number == 8)
            Position="H5游戏开发工程师";
        if(Number == 0) {
            lists = companyMapper.getallPostion1(pageIndex,pageSize);
        }else
        {
            lists = companyMapper.findPositionByPosi(pageIndex,pageSize,Position);
        }
        session.setAttribute("id",Number);
        PageInfo<CompanyInfo> pages=new PageInfo<>(lists);
        model.addAttribute("posi",pages);
        model.addAttribute("Position", Position);
        return "position";
    }


    @GetMapping("/posisearch")
    public String getPosition(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                              @RequestParam(value="pageSize",defaultValue = "12") Integer pageSize,
                              @RequestParam(value="Salary",defaultValue = "") String Salary,
                              @RequestParam(value="Education",defaultValue = "") String Education,
                              @RequestParam(value="Experience",defaultValue = "") String Experience,
                              @RequestParam(value="City",defaultValue = "") String City,
                              @RequestParam(value = "Position",defaultValue = "") String Position,
                              @RequestParam(value = "id",defaultValue = "0") String Number,Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<CompanyInfo> lists = null;
        if(Position.isEmpty()) {
            lists = companyMapper.getallPostion1(pageIndex,pageSize);
        }else {
            if (Salary.isEmpty()) {
                lists = companyMapper.getnosalary(pageIndex, pageSize, Position, Education, Experience, City);
            } else {
                String[] s = Salary.split(",");
                String s1 = s[0];
                String s2 = s[1];
                lists = companyMapper.findByConditions(pageIndex, pageSize, Position, s1, s2, Education, Experience, City);
            }
        }        PageInfo<CompanyInfo> pages=new PageInfo<>(lists);
        model.addAttribute("posi",pages);
        model.addAttribute("position",lists);
        model.addAttribute("id",Number);
        return "position";

    }
//职位展示结束


    //考拉公司页面
    @GetMapping("/detail/{id}")
    public  String detail(@PathVariable("id")Integer PositionID, Model model){
        CompanyInfo companyInfo = companyMapper.getCompany(PositionID);
        model.addAttribute("posi",companyInfo);
        return "detail";
    }

    //首页热门职位
    @GetMapping("/main")
    public String mainPage(Model model) {
        List<CompanyInfo> lists = companyMapper.gethotjob();
        model.addAttribute("hotjob",lists);
        return "main";
    }
    //company表后台管理
    @RequestMapping("/companyadmin")
    public String getcompany(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                            @RequestParam(value="Position",defaultValue = "") String Position, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<CompanyInfo> lists=null;
        PageInfo<CompanyInfo> companyInfoLists=null;
        if(Position.isEmpty()){
            lists=companyMapper.passPosition(pageIndex,pageSize);
        }else{
            lists=companyMapper.selectPosition(pageIndex,pageSize,Position);
        }
        PageInfo<CompanyInfo> pages=new PageInfo<>(lists);
        model.addAttribute("data",pages);
        return "companyadmin";
    }

    //职位详情后台管理
    @GetMapping("/companydetail/{id}")
    private  String detailPage(@PathVariable("id") Integer PositionID,Model model){
        CompanyInfo companyInfo = companyMapper.getPositionByid(PositionID);
        model.addAttribute("company",companyInfo);
        return "companydetail";
    }
    //删除职位
    @GetMapping("/deletecompany/{id}")
    public String deletepositionPage(@PathVariable("id") Integer PositionID,Model model){
        CompanyInfo companyInfo = companyMapper.getPositionByid(PositionID);
        model.addAttribute("companyInfo",companyInfo);
        return "deletecompany";
    }
    @PostMapping("/deletecompany")
    public String deletePositionByID(CompanyInfo PositionID){
        int i = companyMapper.deletePositionByID(PositionID);
        return "redirect:/data/companyadmin";
    }
//新增职位
    @GetMapping("/addcompany")
    public String addCompanyInfo() {
        return "addcompany";
    }


    @PostMapping("/addcompany")
    public  String addCompanyInfo(CompanyInfo companyInfo){
        int i = companyMapper.addPosition(companyInfo);
        return "redirect:/data/companyadmin";
    }
//职位修改
    @GetMapping("/updatecompany/{id}")
    public String updateposition(@PathVariable("id")Integer PositionID,Model model){
        CompanyInfo companyInfo = companyMapper.getPositionByid(PositionID);
        model.addAttribute("companyInfo",companyInfo);
        return "updatecompany";
    }

    @PostMapping("/updatecompany")
    public String updatePosition(CompanyInfo PositionID){
        int i = companyMapper.updatePositionByID(PositionID);
        return "redirect:/data/companyadmin";
    }


}
