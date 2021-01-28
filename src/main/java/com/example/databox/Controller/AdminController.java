package com.example.databox.Controller;


import Util.FileUtilAdmin;
import com.example.databox.Entity.AdminInfo;
import com.example.databox.Entity.UserInfo;
import com.example.databox.Mapper.AdminMapper;
import com.example.databox.Mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("data")
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/admin")
    public String adminLogin() {

        return "admin";
    }

    /**
     *
     * @param AdminPhone 管理员电话
     * @param AdminPassword 管理员密码
     * @param session 把管理员的电话和密码封装到session里面
     * @return
     */
//    @PostMapping("/admin")
//    public String adminLogin(@RequestParam("AdminPhone") String AdminPhone,
//                             @RequestParam("AdminPassword") String AdminPassword,
//                             HttpSession session) {
//        session.setAttribute("test",123456);
//        AdminInfo adminInfo = adminMapper.adminLogin(AdminPhone,AdminPassword);
//        if (adminInfo!=null){
//            session.setAttribute("admin",adminInfo);
//            return "redirect:/data/admintable";
//        }
//        return "redirect:/data/admin";
//    }

    @PostMapping("/admin")
    @ResponseBody()
    public String adminLogin(@RequestParam("AdminPhone") String AdminPhone,
                             @RequestParam("AdminPassword") String AdminPassword,
                             HttpSession session) {
//        session.setAttribute("test", 123456);
        AdminInfo adminInfo = adminMapper.adminLogin(AdminPhone, AdminPassword);
        if (adminInfo != null) {
            session.setAttribute("admin", adminInfo);
            return "1";
        } else {
            return "0";
        }
    }
    /**
     *
     * @param pageIndex admin页面的分页码
     * @param pageSize 一页的数据量
     * @param AdminName 管理员姓名
     * @param AdminPhone 管理员电话
     * @param session 把管理员电话和管理员姓名封装到session里面
     * @param model 模型
     * @return
     */

    @RequestMapping("/admintable")

    public String getUserByNameByPhone(@RequestParam (value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                       @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                       @RequestParam(value = "AdminName",defaultValue = "") String AdminName,
                                       @RequestParam(value = "AdminPhone",defaultValue = "") String AdminPhone,HttpSession session,
                                       Model model){
        AdminInfo adminInfo = (AdminInfo) session.getAttribute("admin");
        PageHelper.startPage(pageIndex, pageSize);
        List<AdminInfo> lists = null;
        PageInfo<AdminInfo> listInfo=null;
        if (AdminName.isEmpty()&&AdminPhone.isEmpty()){
            lists = adminMapper.getAllAdmin(pageIndex,pageSize);
        }else if (AdminName.isEmpty()&&!AdminPhone.isEmpty()){
            lists = adminMapper.getAdminByAdminPhone(pageIndex,pageSize,AdminPhone);
        }else {
            lists = adminMapper.getAdminByAdminNameAdminPhone(pageIndex,pageSize,AdminName,AdminPhone);
        }
        PageInfo<AdminInfo> pages=new PageInfo<>(lists);
        List<AdminInfo> UserInfoList=adminMapper.getAllAdmin(pageIndex,pageSize);
        model.addAttribute("AdminName",AdminName);
        model.addAttribute("AdminPhone",AdminPhone);
        model.addAttribute("adminInfo",UserInfoList);
        model.addAttribute("Admin",pages);
        return "admintable";
    }

    /**
     *
     * @return
     */
    @GetMapping("/addadmin")
    public String addadminInfo() {
        return "addadmin";
    }

    /**
     *
     * @param adminInfo admin页面的属性定义
     * @param file 图片名字
     * @return
     */
    @PostMapping("/addadmin")
    public String addAdminInfo(AdminInfo adminInfo, @RequestParam("adminfile") MultipartFile file) {
        String fileName4 = file.getOriginalFilename();
        String filePath4 = FileUtilAdmin.getUpLoadFilePath();
        fileName4 = System.currentTimeMillis()+fileName4;
        try{
            FileUtilAdmin.uploadFile(file.getBytes(),filePath4,fileName4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        adminInfo.setAdmin_image_url(fileName4);
        int i = adminMapper.saveAdminInfo(adminInfo);
        return "redirect:/data/admintable";
    }

    @GetMapping("/updateadmin/{id}")
    public String updatePage(@PathVariable("id") Integer AdminID, Model model){
        AdminInfo adminInfo = adminMapper.getAdminByID(AdminID);
        model.addAttribute("adminInfo", adminInfo);
        return "updateadmin";
    }

    /**
     *
     * @param adminInfo admin页面的属性定义
     * @param file 图片的名字
     * @return
     */
    @PostMapping("/updateadmin")
    public String updateAdminInfo(AdminInfo adminInfo,@RequestParam("adminfile")MultipartFile file) {
        String fileName4 = file.getOriginalFilename();
        String filePath4 = FileUtilAdmin.getUpLoadFilePath();
        fileName4 = System.currentTimeMillis()+fileName4;
        try{
            FileUtilAdmin.uploadFile(file.getBytes(),filePath4,fileName4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        adminInfo.setAdmin_image_url(fileName4);
        int i = adminMapper.updateAdminByID(adminInfo);
        return "redirect:/data/admintable";
    }


}
