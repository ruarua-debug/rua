package com.example.databox.Controller;
import Util.FileUtilLogo;
import Util.FileUtilMap;
import com.example.databox.Entity.MessageInfo;
import com.example.databox.Mapper.MessageMapper;
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
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/addmessage")
    public String addmessageInfo() {
        return "addmessage1";
    }

    /**
     *
     *
     * @param messageInfo 获取messageinfo表
     * @param file1 上传图片1
     * @param file2 上传图片1
     * @return 该路径下点击返回messageadmin页面
     */
    @PostMapping("/addmessage")
    public  String addMessageInfo(MessageInfo messageInfo,
                                  @RequestParam("logo") MultipartFile file1,
                                  @RequestParam("map") MultipartFile file2){
        String fileName1 = file1.getOriginalFilename();
        String filePath1 = FileUtilLogo.getUpLoadFilePath();
        String fileName2 = file2.getOriginalFilename();
        String filepath2 = FileUtilMap.getUpLoadFilePath();
        fileName1 = System.currentTimeMillis()+fileName1;
        fileName2 = System.currentTimeMillis()+fileName2;
        try {
            FileUtilLogo.uploadFile(file1.getBytes(),filePath1,fileName1);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            FileUtilMap.uploadFile(file2.getBytes(),filepath2,fileName2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageInfo.setCompanyLogo(fileName1);
        messageInfo.setCompanyMap(fileName2);
        int i = messageMapper.addMessageInfo(messageInfo);
        return "redirect:/data/messageadmin";
    }


    @GetMapping("/updatemessage/{id}")
    public String updatepositionPage(@PathVariable("id")Integer CommessageID, Model model){
        MessageInfo messageInfo = messageMapper.getCompanyByid(CommessageID);
        model.addAttribute("messageInfo",messageInfo);
        return "updatemessage";
    }

    @PostMapping("/updatemessage")
    public String updatePositionByID(MessageInfo messageInfo,
                                     @RequestParam("logo") MultipartFile file1,@RequestParam("map") MultipartFile file2){
        String fileName1 = file1.getOriginalFilename();
        String filePath1 = FileUtilLogo.getUpLoadFilePath();
        String fileName2 = file2.getOriginalFilename();
        String filepath2 = FileUtilMap.getUpLoadFilePath();
        fileName1 = System.currentTimeMillis()+fileName1;
        fileName2 = System.currentTimeMillis()+fileName2;
        try {
            FileUtilLogo.uploadFile(file1.getBytes(),filePath1,fileName1);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
                FileUtilMap.uploadFile(file2.getBytes(),filepath2,fileName2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageInfo.setCompanyLogo(fileName1);
        messageInfo.setCompanyMap(fileName2);
        int i = messageMapper.updateCompanyByID(messageInfo);
        return "redirect:/data/messageadmin";
    }


    @RequestMapping("/messageadmin")
    public String getPositionID(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                                @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                                @RequestParam(value="CompanyName",defaultValue = "") String CompanyName, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<MessageInfo> lists=null;
        PageInfo<MessageInfo> messageInfoLists=null;
        if(CompanyName.isEmpty()){
            lists=messageMapper.getAllCompany(pageIndex,pageSize);
        }else{
            lists=messageMapper.findCompanyByID(pageIndex,pageSize,CompanyName);
        }
        PageInfo<MessageInfo> pages=new PageInfo<>(lists);
        List<MessageInfo> MessageInfoList = messageMapper.getAllCompany(pageIndex,pageSize);
        model.addAttribute("MessageInfo",MessageInfoList);
        model.addAttribute("Message",pages);
        model.addAttribute("CompanyName", CompanyName);
        return "messageadmin";
    }

    @GetMapping("/messagedetail/{id}")
    private  String detailPage(@PathVariable("id") Integer CommessageID,Model model){
        MessageInfo messageInfo = messageMapper.getCompanyByid(CommessageID);
        model.addAttribute("message",messageInfo);
        return "messagedetail";
    }


    @GetMapping("/deletemessage/{id}")
    public String deleteCompanyPage(@PathVariable("id") Integer CommessageID,Model model){
        MessageInfo companyInfo = messageMapper.getCompanyByid(CommessageID);
        model.addAttribute("messageInfo",companyInfo);
        return "deletemessage";
    }
    @PostMapping("/deletemessage")
    public String deleteCompanyByID(MessageInfo messageInfo){
        int i = messageMapper.deleteCompanyByID(messageInfo);
        return "redirect:/data/messageadmin";
    }





//考拉公司页面

    //从position页面点击不同图片跳转到对应公司的详情介绍页

    /**
     *
     * @param Number 获取点击的公司编号
     * @param session 把用户点击的number封装到session中
     * @param model 使用的模型
     * @return 路径下返回company页面
     */
    @GetMapping("/getcompany/{id}")
    public String Pagegetcompany(@PathVariable("id") Integer Number,
                                 HttpSession session,Model model) {
        String CompanyName = "";
        if(Number == 1)
            CompanyName="浪潮集团";
        if(Number == 2)
            CompanyName="华为";
        if(Number == 3)
            CompanyName="腾讯";
        if(Number == 4)
            CompanyName="阿里巴巴集团";
        if(Number == 5)
            CompanyName="百度";
        if(Number == 6)
            CompanyName="新浪网";
        if(Number == 7)
            CompanyName="Amazon";
        if(Number == 8)
            CompanyName="小米";
//        Integer NO= (Integer) Number;
        session.setAttribute("Number",Number);
        List<MessageInfo> lists=messageMapper.getcompany(CompanyName);
        model.addAttribute("company",lists);
        model.addAttribute("cname", CompanyName);
        return "company";
    }

    /**
     *
     * @param number 获取点击的公司名
     * @param FunctionNumber 获取点击的话题编号
     * @param session 接受封装在session里的内容
     * @param model 使用模型
     * @return 路径下返回company1页面
     */
    //company1根据公司名查询显示对应的职位
    @GetMapping("/getcompany1")
    public String Pagegetcompany1(@RequestParam("cname") String number,
                                  @RequestParam(value = "companyid",defaultValue = "0") Integer FunctionNumber,
                                  HttpSession session,Model model) {
        String Function = "";
        List<MessageInfo> lists=null;
        if(FunctionNumber == 1)
            Function="技术";
        if(FunctionNumber == 2)
            Function="产品";
        if(FunctionNumber == 3)
            Function="运营";
        if(FunctionNumber == 4)
            Function="销售";
        if(FunctionNumber == 0){
            Function="全部";
            lists=messageMapper.getcompanypos(number);
        }else
        {
            lists=messageMapper.getcompanypselect(number,Function);
        }
        Integer Number = (Integer)session.getAttribute("Number");
        model.addAttribute("company1",lists);
        model.addAttribute("fun",Function);
        model.addAttribute("cname",number);
        model.addAttribute("Number",Number);
        return "company1";
    }


}
